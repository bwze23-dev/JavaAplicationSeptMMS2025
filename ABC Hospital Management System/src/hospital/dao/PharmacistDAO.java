package hospital.dao;

import hospital.database.DatabaseConnection;
import hospital.models.Department;
import hospital.models.Pharmacist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PharmacistDAO {

    // =========================================================
    // CREATE PHARMACIST
    // =========================================================

    public boolean addPharmacist(Pharmacist pharmacist) {

        String personSql = "INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) "
                          + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        String staffSql = "INSERT INTO Staff (EmploymentDate, Salary, DepartmentId, PersonId) VALUES (?, ?, ?, ?)";

        String pharmacistSql = "INSERT INTO Pharmacist (StaffId, Qualification, LicenseNumber) VALUES (?, ?, ?)";

        Connection connection = null;

        try {
            connection = DatabaseConnection.getConnection();
            connection.setAutoCommit(false);

            PreparedStatement personStatement = connection.prepareStatement(personSql, Statement.RETURN_GENERATED_KEYS);
            personStatement.setString(1, pharmacist.getFirstName());
            personStatement.setString(2, pharmacist.getLastName());
            personStatement.setString(3, String.valueOf(pharmacist.getGender()));
            personStatement.setDate(4, pharmacist.getDateOfBirth() != null ? Date.valueOf(pharmacist.getDateOfBirth()) : null);
            personStatement.setString(5, pharmacist.getPhone());
            personStatement.setString(6, pharmacist.getEmail());
            personStatement.setString(7, pharmacist.getStreet());
            personStatement.setString(8, pharmacist.getCity());
            personStatement.setString(9, pharmacist.getCountry());
            personStatement.executeUpdate();

            int personId = 0;
            ResultSet personKeys = personStatement.getGeneratedKeys();
            if (personKeys.next()) {
                personId = personKeys.getInt(1);
            }
            personKeys.close();

            PreparedStatement staffStatement = connection.prepareStatement(staffSql, Statement.RETURN_GENERATED_KEYS);
            staffStatement.setDate(1, pharmacist.getEmploymentDate() != null ? Date.valueOf(pharmacist.getEmploymentDate()) : null);
            staffStatement.setDouble(2, pharmacist.getSalary());
            if (pharmacist.getDepartment() != null) {
                staffStatement.setInt(3, pharmacist.getDepartment().getId());
            } else {
                staffStatement.setNull(3, Types.INTEGER);
            }
            staffStatement.setInt(4, personId);
            staffStatement.executeUpdate();

            int staffId = 0;
            ResultSet staffKeys = staffStatement.getGeneratedKeys();
            if (staffKeys.next()) {
                staffId = staffKeys.getInt(1);
            }
            staffKeys.close();

            PreparedStatement pharmacistStatement = connection.prepareStatement(pharmacistSql);
            pharmacistStatement.setInt(1, staffId);
            pharmacistStatement.setString(2, pharmacist.getQualification());
            pharmacistStatement.setString(3, pharmacist.getLicenseNumber());
            pharmacistStatement.executeUpdate();

            connection.commit();
            pharmacist.setStaffID(staffId);

            return true;

        } catch (SQLException e) {

            System.out.println("Error adding pharmacist: " + e.getMessage());

            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException rollbackError) {
                    rollbackError.printStackTrace();
                }
            }

        } finally {

            if (connection != null) {
                try {
                    connection.setAutoCommit(true);
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return false;
    }


    // =========================================================
    // FIND ALL PHARMACISTS
    // =========================================================

    public List<Pharmacist> findAllPharmacists() {

        List<Pharmacist> pharmacists = new ArrayList<>();

        String sql = baseSelect() + " ORDER BY ph.StaffId";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                pharmacists.add(mapPharmacist(resultSet));
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error retrieving pharmacists: " + e.getMessage());
        }

        return pharmacists;
    }


    // =========================================================
    // FIND PHARMACIST BY ID
    // =========================================================

    public Pharmacist findPharmacistById(int staffId) {

        String sql = baseSelect() + " WHERE ph.StaffId = ?";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, staffId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Pharmacist pharmacist = mapPharmacist(resultSet);
                connection.close();
                return pharmacist;
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error finding pharmacist: " + e.getMessage());
        }

        return null;
    }


    // =========================================================
    // DELETE PHARMACIST
    // =========================================================

    public boolean deletePharmacist(int staffId) {

        String sql = "DELETE FROM Staff WHERE StaffId = ?"; // cascades to Pharmacist and Person

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, staffId);

            int rows = statement.executeUpdate();
            connection.close();

            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error deleting pharmacist: " + e.getMessage());
        }

        return false;
    }


    // =========================================================
    // BASE SELECT / MAP
    // =========================================================

    private String baseSelect() {

        return "SELECT ph.StaffId, ph.Qualification, ph.LicenseNumber, "
             + "s.EmploymentDate, s.Salary, s.DepartmentId, "
             + "p.FirstName, p.LastName, p.Gender, p.DateOfBirth, p.Phone, p.Email, p.Street, p.City, p.Country, "
             + "d.Name AS DepartmentName "
             + "FROM Pharmacist ph "
             + "INNER JOIN Staff s ON ph.StaffId = s.StaffId "
             + "INNER JOIN Person p ON s.PersonId = p.PersonId "
             + "LEFT JOIN Department d ON s.DepartmentId = d.DepartmentId";
    }

    private Pharmacist mapPharmacist(ResultSet resultSet) throws SQLException {

        Pharmacist pharmacist = new Pharmacist();

        pharmacist.setStaffID(resultSet.getInt("StaffId"));
        pharmacist.setQualification(resultSet.getString("Qualification"));
        pharmacist.setLicenseNumber(resultSet.getString("LicenseNumber"));
        pharmacist.setFirstName(resultSet.getString("FirstName"));
        pharmacist.setLastName(resultSet.getString("LastName"));

        String gender = resultSet.getString("Gender");
        if (gender != null && !gender.isEmpty()) {
            pharmacist.setGender(gender.charAt(0));
        }

        Date dateOfBirth = resultSet.getDate("DateOfBirth");
        if (dateOfBirth != null) {
            pharmacist.setDateOfBirth(dateOfBirth.toLocalDate());
        }

        pharmacist.setPhone(resultSet.getString("Phone"));
        pharmacist.setEmail(resultSet.getString("Email"));
        pharmacist.setStreet(resultSet.getString("Street"));
        pharmacist.setCity(resultSet.getString("City"));
        pharmacist.setCountry(resultSet.getString("Country"));
        pharmacist.setSalary(resultSet.getDouble("Salary"));

        Date employmentDate = resultSet.getDate("EmploymentDate");
        if (employmentDate != null) {
            pharmacist.setEmploymentDate(employmentDate.toLocalDate());
        }

        int departmentId = resultSet.getInt("DepartmentId");
        if (!resultSet.wasNull()) {
            Department department = new Department();
            department.setId(departmentId);
            department.setName(resultSet.getString("DepartmentName"));
            pharmacist.setDepartment(department);
        }

        return pharmacist;
    }
}
