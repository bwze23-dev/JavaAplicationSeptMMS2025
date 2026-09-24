package hospital.dao;

import hospital.database.DatabaseConnection;
import hospital.models.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {

    // =========================================================
    // ADD DEPARTMENT
    // =========================================================

    public boolean addDepartment(Department department) {

        String sql = "INSERT INTO Department (Name, HeadOfDepartment) VALUES (?, ?)";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, department.getName());
            statement.setString(2, department.getHeadOfDepartment());

            statement.executeUpdate();

            ResultSet keys = statement.getGeneratedKeys();
            if (keys.next()) {
                department.setId(keys.getInt(1));
            }
            keys.close();
            connection.close();

            return true;

        } catch (SQLException e) {
            System.out.println("Error adding department: " + e.getMessage());
        }

        return false;
    }


    // =========================================================
    // FIND ALL DEPARTMENTS
    // =========================================================

    public List<Department> findAllDepartments() {

        List<Department> departments = new ArrayList<>();

        String sql = "SELECT DepartmentId, Name, HeadOfDepartment FROM Department ORDER BY DepartmentId";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                departments.add(mapDepartment(resultSet));
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error retrieving departments: " + e.getMessage());
        }

        return departments;
    }


    // =========================================================
    // FIND DEPARTMENT BY ID
    // =========================================================

    public Department findDepartmentById(int departmentId) {

        String sql = "SELECT DepartmentId, Name, HeadOfDepartment FROM Department WHERE DepartmentId = ?";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, departmentId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Department department = mapDepartment(resultSet);
                connection.close();
                return department;
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error finding department: " + e.getMessage());
        }

        return null;
    }


    // =========================================================
    // MAP RESULTSET TO DEPARTMENT
    // =========================================================

    private Department mapDepartment(ResultSet resultSet) throws SQLException {

        Department department = new Department();

        department.setId(resultSet.getInt("DepartmentId"));
        department.setName(resultSet.getString("Name"));
        department.setHeadOfDepartment(resultSet.getString("HeadOfDepartment"));

        return department;
    }
}
