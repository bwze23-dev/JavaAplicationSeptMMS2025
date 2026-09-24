package hospital.dao;

import hospital.database.DatabaseConnection;
import hospital.models.Diagnosis;
import hospital.models.Doctor;
import hospital.models.Patient;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DiagnosisDAO {

    // =========================================================
    // ADD DIAGNOSIS
    // =========================================================

    public boolean addDiagnosis(Diagnosis diagnosis) {

        String sql = "INSERT INTO Diagnosis (PatientId, DoctorId, DiagnosisName, Description, DiagnosisDate, Status) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setInt(1, diagnosis.getPatient().getPatientID());
            statement.setInt(2, diagnosis.getDoctor().getStaffID());
            statement.setString(3, diagnosis.getDiagnosisName());
            statement.setString(4, diagnosis.getDescription());
            statement.setDate(5, Date.valueOf(diagnosis.getDiagnosisDate()));
            statement.setString(6, diagnosis.getStatus());

            statement.executeUpdate();

            ResultSet keys = statement.getGeneratedKeys();
            if (keys.next()) {
                diagnosis.setId(keys.getInt(1));
            }
            keys.close();
            connection.close();

            return true;

        } catch (SQLException e) {
            System.out.println("Error adding diagnosis: " + e.getMessage());
        }

        return false;
    }


    // =========================================================
    // FIND ALL DIAGNOSES
    // =========================================================

    public List<Diagnosis> findAllDiagnoses() {

        List<Diagnosis> diagnoses = new ArrayList<>();

        String sql = baseSelect() + " ORDER BY d.DiagnosisId";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                diagnoses.add(mapDiagnosis(resultSet));
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error retrieving diagnoses: " + e.getMessage());
        }

        return diagnoses;
    }


    // =========================================================
    // FIND DIAGNOSES BY PATIENT
    // =========================================================

    public List<Diagnosis> findDiagnosesByPatient(int patientId) {

        List<Diagnosis> diagnoses = new ArrayList<>();

        String sql = baseSelect() + " WHERE d.PatientId = ? ORDER BY d.DiagnosisId";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, patientId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                diagnoses.add(mapDiagnosis(resultSet));
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error retrieving diagnoses for patient: " + e.getMessage());
        }

        return diagnoses;
    }


    // =========================================================
    // FIND DIAGNOSIS BY ID (used by TreatmentDAO)
    // =========================================================

    public Diagnosis findDiagnosisById(int diagnosisId) {

        String sql = baseSelect() + " WHERE d.DiagnosisId = ?";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, diagnosisId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Diagnosis diagnosis = mapDiagnosis(resultSet);
                connection.close();
                return diagnosis;
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error finding diagnosis: " + e.getMessage());
        }

        return null;
    }


    // =========================================================
    // BASE SELECT (shared by every read method above)
    // =========================================================

    private String baseSelect() {

        return "SELECT d.DiagnosisId, d.PatientId, d.DoctorId, d.DiagnosisName, "
             + "d.Description, d.DiagnosisDate, d.Status, "
             + "pp.FirstName AS PatientFirstName, pp.LastName AS PatientLastName, "
             + "dp.FirstName AS DoctorFirstName, dp.LastName AS DoctorLastName "
             + "FROM Diagnosis d "
             + "INNER JOIN Patient pt ON d.PatientId = pt.PatientId "
             + "INNER JOIN Person pp ON pt.PersonId = pp.PersonId "
             + "INNER JOIN Staff ds ON d.DoctorId = ds.StaffId "
             + "INNER JOIN Person dp ON ds.PersonId = dp.PersonId";
    }


    // =========================================================
    // MAP RESULTSET TO DIAGNOSIS
    // =========================================================

    private Diagnosis mapDiagnosis(ResultSet resultSet) throws SQLException {

        Diagnosis diagnosis = new Diagnosis();

        diagnosis.setId(resultSet.getInt("DiagnosisId"));
        diagnosis.setDiagnosisName(resultSet.getString("DiagnosisName"));
        diagnosis.setDescription(resultSet.getString("Description"));
        diagnosis.setStatus(resultSet.getString("Status"));

        Date diagnosisDate = resultSet.getDate("DiagnosisDate");
        if (diagnosisDate != null) {
            diagnosis.setDiagnosisDate(diagnosisDate.toLocalDate());
        }

        Patient patient = new Patient();
        patient.setPatientID(resultSet.getInt("PatientId"));
        patient.setFirstName(resultSet.getString("PatientFirstName"));
        patient.setLastName(resultSet.getString("PatientLastName"));
        diagnosis.setPatient(patient);

        Doctor doctor = new Doctor();
        doctor.setStaffID(resultSet.getInt("DoctorId"));
        doctor.setFirstName(resultSet.getString("DoctorFirstName"));
        doctor.setLastName(resultSet.getString("DoctorLastName"));
        diagnosis.setDoctor(doctor);

        return diagnosis;
    }
}
