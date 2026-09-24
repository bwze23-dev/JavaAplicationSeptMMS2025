package hospital.dao;

import hospital.database.DatabaseConnection;
import hospital.models.Admission;
import hospital.models.Bed;
import hospital.models.Doctor;
import hospital.models.Patient;
import hospital.models.Room;
import hospital.models.Ward;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdmissionDAO {

    // =========================================================
    // ADMIT PATIENT (creates Admission AND marks bed occupied)
    // =========================================================

    public boolean admitPatient(Admission admission) {

        String admissionSql = "INSERT INTO Admission (PatientId, BedId, AttendingDoctorId, AdmissionDate, Reason, Status) "
                             + "VALUES (?, ?, ?, ?, ?, 'Admitted')";

        String bedSql = "UPDATE Bed SET Occupied = 1 WHERE BedId = ?";

        Connection connection = null;

        try {
            connection = DatabaseConnection.getConnection();
            connection.setAutoCommit(false);

            // Step 1: create the Admission row
            PreparedStatement admissionStatement =
                    connection.prepareStatement(admissionSql, Statement.RETURN_GENERATED_KEYS);

            admissionStatement.setInt(1, admission.getPatient().getPatientID());
            admissionStatement.setInt(2, admission.getBed().getId());
            if (admission.getAttendingDoctor() != null) {
                admissionStatement.setInt(3, admission.getAttendingDoctor().getStaffID());
            } else {
                admissionStatement.setNull(3, java.sql.Types.INTEGER);
            }
            admissionStatement.setDate(4, Date.valueOf(admission.getAdmissionDate()));
            admissionStatement.setString(5, admission.getReason());

            admissionStatement.executeUpdate();

            ResultSet keys = admissionStatement.getGeneratedKeys();
            if (keys.next()) {
                admission.setId(keys.getInt(1));
            }
            keys.close();

            // Step 2: mark the bed as occupied
            PreparedStatement bedStatement = connection.prepareStatement(bedSql);
            bedStatement.setInt(1, admission.getBed().getId());
            bedStatement.executeUpdate();

            // Both worked - save permanently
            connection.commit();

            return true;

        } catch (SQLException e) {

            System.out.println("Error admitting patient: " + e.getMessage());

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
    // DISCHARGE PATIENT (updates Admission AND frees the bed)
    // =========================================================

    public boolean dischargePatient(int admissionId, java.time.LocalDate dischargeDate) {

        Connection connection = null;

        try {
            connection = DatabaseConnection.getConnection();
            connection.setAutoCommit(false);

            // Step 1: find which bed this admission is using
            int bedId = getBedIdForAdmission(connection, admissionId);

            if (bedId == -1) {
                connection.rollback();
                System.out.println("Admission not found.");
                return false;
            }

            // Step 2: update the Admission row
            String admissionSql = "UPDATE Admission SET DischargeDate = ?, Status = 'Discharged' "
                                 + "WHERE AdmissionId = ?";

            PreparedStatement admissionStatement = connection.prepareStatement(admissionSql);
            admissionStatement.setDate(1, Date.valueOf(dischargeDate));
            admissionStatement.setInt(2, admissionId);
            admissionStatement.executeUpdate();

            // Step 3: free up the bed
            String bedSql = "UPDATE Bed SET Occupied = 0 WHERE BedId = ?";

            PreparedStatement bedStatement = connection.prepareStatement(bedSql);
            bedStatement.setInt(1, bedId);
            bedStatement.executeUpdate();

            connection.commit();

            return true;

        } catch (SQLException e) {

            System.out.println("Error discharging patient: " + e.getMessage());

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
    // FIND ALL ADMISSIONS
    // =========================================================

    public List<Admission> findAllAdmissions() {

        List<Admission> admissions = new ArrayList<>();

        String sql = baseSelect() + " ORDER BY a.AdmissionId";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                admissions.add(mapAdmission(resultSet));
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error retrieving admissions: " + e.getMessage());
        }

        return admissions;
    }


    // =========================================================
    // FIND ACTIVE ADMISSIONS (patients still in hospital)
    // =========================================================

    public List<Admission> findActiveAdmissions() {

        List<Admission> admissions = new ArrayList<>();

        String sql = baseSelect() + " WHERE a.Status = 'Admitted' ORDER BY a.AdmissionId";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                admissions.add(mapAdmission(resultSet));
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error retrieving active admissions: " + e.getMessage());
        }

        return admissions;
    }


    // =========================================================
    // FIND ADMISSION BY ID
    // =========================================================

    public Admission findAdmissionById(int admissionId) {

        String sql = baseSelect() + " WHERE a.AdmissionId = ?";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, admissionId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Admission admission = mapAdmission(resultSet);
                connection.close();
                return admission;
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error finding admission: " + e.getMessage());
        }

        return null;
    }


    // =========================================================
    // UPDATE ADMISSION (reason only - not bed/patient/dates)
    // =========================================================

    public boolean update(Admission admission) {

        String sql = "UPDATE Admission SET Reason = ? WHERE AdmissionId = ?";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, admission.getReason());
            statement.setInt(2, admission.getId());

            int rows = statement.executeUpdate();
            connection.close();

            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error updating admission: " + e.getMessage());
        }

        return false;
    }


    // =========================================================
    // GET BED ID FOR AN ADMISSION (helper for discharge)
    // =========================================================

    private int getBedIdForAdmission(Connection connection, int admissionId) throws SQLException {

        String sql = "SELECT BedId FROM Admission WHERE AdmissionId = ?";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, admissionId);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            return resultSet.getInt("BedId");
        }

        return -1;
    }


    // =========================================================
    // BASE SELECT (shared by every read method above)
    // =========================================================

    private String baseSelect() {

        return "SELECT a.AdmissionId, a.PatientId, a.BedId, a.AttendingDoctorId, a.AdmissionDate, "
             + "a.DischargeDate, a.Reason, a.Status, "
             + "p.FirstName AS PatientFirstName, p.LastName AS PatientLastName, "
             + "dp.FirstName AS DoctorFirstName, dp.LastName AS DoctorLastName, "
             + "bd.BedNumber, "
             + "r.RoomId, r.RoomNumber, "
             + "w.WardId, w.Name AS WardName "
             + "FROM Admission a "
             + "INNER JOIN Patient pt ON a.PatientId = pt.PatientId "
             + "INNER JOIN Person p ON pt.PersonId = p.PersonId "
             + "INNER JOIN Bed bd ON a.BedId = bd.BedId "
             + "INNER JOIN Room r ON bd.RoomId = r.RoomId "
             + "INNER JOIN Ward w ON r.WardId = w.WardId "
             + "LEFT JOIN Staff ds ON a.AttendingDoctorId = ds.StaffId "
             + "LEFT JOIN Person dp ON ds.PersonId = dp.PersonId";
    }


    // =========================================================
    // MAP RESULTSET TO ADMISSION
    // =========================================================

    private Admission mapAdmission(ResultSet resultSet) throws SQLException {

        Admission admission = new Admission();

        admission.setId(resultSet.getInt("AdmissionId"));
        admission.setReason(resultSet.getString("Reason"));
        admission.setStatus(resultSet.getString("Status"));

        java.sql.Date admissionDate = resultSet.getDate("AdmissionDate");
        if (admissionDate != null) {
            admission.setAdmissionDate(admissionDate.toLocalDate());
        }

        java.sql.Date dischargeDate = resultSet.getDate("DischargeDate");
        if (dischargeDate != null) {
            admission.setDischargeDate(dischargeDate.toLocalDate());
        }

        Patient patient = new Patient();
        patient.setPatientID(resultSet.getInt("PatientId"));
        patient.setFirstName(resultSet.getString("PatientFirstName"));
        patient.setLastName(resultSet.getString("PatientLastName"));
        admission.setPatient(patient);

        int doctorId = resultSet.getInt("AttendingDoctorId");
        if (!resultSet.wasNull()) {
            Doctor doctor = new Doctor();
            doctor.setStaffID(doctorId);
            doctor.setFirstName(resultSet.getString("DoctorFirstName"));
            doctor.setLastName(resultSet.getString("DoctorLastName"));
            admission.setAttendingDoctor(doctor);
        }

        Ward ward = new Ward();
        ward.setId(resultSet.getInt("WardId"));
        ward.setName(resultSet.getString("WardName"));

        Room room = new Room();
        room.setId(resultSet.getInt("RoomId"));
        room.setRoomNumber(resultSet.getString("RoomNumber"));
        room.setWard(ward);

        Bed bed = new Bed();
        bed.setId(resultSet.getInt("BedId"));
        bed.setBedNumber(resultSet.getString("BedNumber"));
        bed.setRoom(room);
        admission.setBed(bed);

        return admission;
    }

    // =========================================================
    // FIND ADMISSIONS BY PATIENT
    // =========================================================

    public List<Admission> findAdmissionsByPatient(int patientId) {

        List<Admission> admissions = new ArrayList<>();

        String sql = baseSelect() + " WHERE a.PatientId = ? ORDER BY a.AdmissionId";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, patientId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                admissions.add(mapAdmission(resultSet));
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error retrieving admissions for patient: " + e.getMessage());
        }

        return admissions;
    }
}
