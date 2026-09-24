package hospital.dao;

import hospital.database.DatabaseConnection;
import hospital.models.Admission;
import hospital.models.Nurse;
import hospital.models.NurseAssignment;
import hospital.models.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class NurseAssignmentDAO {

    // =========================================================
    // ASSIGN NURSE
    // =========================================================

    public boolean assignNurse(NurseAssignment assignment) {

        String sql = "INSERT INTO NurseAssignment (NurseId, PatientId, AdmissionId, AssignmentDate, Shift, Status) "
                   + "VALUES (?, ?, ?, ?, ?, 'ACTIVE')";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setInt(1, assignment.getNurse().getStaffID());
            statement.setInt(2, assignment.getPatient().getPatientID());
            if (assignment.getAdmission() != null) {
                statement.setInt(3, assignment.getAdmission().getId());
            } else {
                statement.setNull(3, java.sql.Types.INTEGER);
            }
            statement.setTimestamp(4, Timestamp.valueOf(assignment.getAssignmentDate()));
            statement.setString(5, assignment.getShift());

            statement.executeUpdate();

            ResultSet keys = statement.getGeneratedKeys();
            if (keys.next()) {
                assignment.setId(keys.getInt(1));
            }
            keys.close();
            connection.close();

            assignment.setStatus("ACTIVE");
            return true;

        } catch (SQLException e) {
            System.out.println("Error assigning nurse: " + e.getMessage());
        }

        return false;
    }


    // =========================================================
    // FIND ALL NURSE ASSIGNMENTS
    // =========================================================

    public List<NurseAssignment> findAllAssignments() {

        List<NurseAssignment> assignments = new ArrayList<>();

        String sql = baseSelect() + " ORDER BY na.AssignmentId";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                assignments.add(mapAssignment(resultSet));
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error retrieving nurse assignments: " + e.getMessage());
        }

        return assignments;
    }


    // =========================================================
    // FIND ASSIGNMENTS BY PATIENT
    // =========================================================

    public List<NurseAssignment> findAssignmentsByPatient(int patientId) {

        List<NurseAssignment> assignments = new ArrayList<>();

        String sql = baseSelect() + " WHERE na.PatientId = ? ORDER BY na.AssignmentId";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, patientId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                assignments.add(mapAssignment(resultSet));
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error retrieving assignments for patient: " + e.getMessage());
        }

        return assignments;
    }


    // =========================================================
    // FIND ASSIGNMENTS BY NURSE
    // =========================================================

    public List<NurseAssignment> findAssignmentsByNurse(int nurseStaffId) {

        List<NurseAssignment> assignments = new ArrayList<>();

        String sql = baseSelect() + " WHERE na.NurseId = ? ORDER BY na.AssignmentId";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, nurseStaffId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                assignments.add(mapAssignment(resultSet));
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error retrieving assignments for nurse: " + e.getMessage());
        }

        return assignments;
    }


    // =========================================================
    // BASE SELECT (shared by every read method above)
    // =========================================================

    private String baseSelect() {

        return "SELECT na.AssignmentId, na.NurseId, na.PatientId, na.AdmissionId, "
             + "na.AssignmentDate, na.EndDate, na.Shift, na.Status, na.Notes, "
             + "np.FirstName AS NurseFirstName, np.LastName AS NurseLastName, "
             + "pp.FirstName AS PatientFirstName, pp.LastName AS PatientLastName "
             + "FROM NurseAssignment na "
             + "INNER JOIN Staff ns ON na.NurseId = ns.StaffId "
             + "INNER JOIN Person np ON ns.PersonId = np.PersonId "
             + "INNER JOIN Patient pt ON na.PatientId = pt.PatientId "
             + "INNER JOIN Person pp ON pt.PersonId = pp.PersonId";
    }


    // =========================================================
    // MAP RESULTSET TO NURSEASSIGNMENT
    // =========================================================

    private NurseAssignment mapAssignment(ResultSet resultSet) throws SQLException {

        NurseAssignment assignment = new NurseAssignment();

        assignment.setId(resultSet.getInt("AssignmentId"));
        assignment.setShift(resultSet.getString("Shift"));
        assignment.setStatus(resultSet.getString("Status"));
        assignment.setNotes(resultSet.getString("Notes"));

        Timestamp assignmentDate = resultSet.getTimestamp("AssignmentDate");
        if (assignmentDate != null) {
            assignment.setAssignmentDate(assignmentDate.toLocalDateTime());
        }

        Timestamp endDate = resultSet.getTimestamp("EndDate");
        if (endDate != null) {
            assignment.setEndDate(endDate.toLocalDateTime());
        }

        Nurse nurse = new Nurse();
        nurse.setStaffID(resultSet.getInt("NurseId"));
        nurse.setFirstName(resultSet.getString("NurseFirstName"));
        nurse.setLastName(resultSet.getString("NurseLastName"));
        assignment.setNurse(nurse);

        Patient patient = new Patient();
        patient.setPatientID(resultSet.getInt("PatientId"));
        patient.setFirstName(resultSet.getString("PatientFirstName"));
        patient.setLastName(resultSet.getString("PatientLastName"));
        assignment.setPatient(patient);

        int admissionId = resultSet.getInt("AdmissionId");
        if (!resultSet.wasNull()) {
            Admission admission = new Admission();
            admission.setId(admissionId);
            assignment.setAdmission(admission);
        }

        return assignment;
    }
}
