package hospital.dao;

import hospital.database.DatabaseConnection;
import hospital.models.Medication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MedicationDAO {

    // =========================================================
    // ADD MEDICATION
    // =========================================================

    public boolean addMedication(Medication medication) {

        String sql = "INSERT INTO Medication (Name, Description, DosageForm, Price, QuantityInStock) "
                   + "VALUES (?, ?, ?, ?, ?)";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, medication.getName());
            statement.setString(2, medication.getDescription());
            statement.setString(3, medication.getDosageForm());
            statement.setDouble(4, medication.getPrice());
            statement.setInt(5, medication.getQuantityInStock());

            statement.executeUpdate();

            ResultSet keys = statement.getGeneratedKeys();
            if (keys.next()) {
                medication.setId(keys.getInt(1));
            }
            keys.close();
            connection.close();

            return true;

        } catch (SQLException e) {
            System.out.println("Error adding medication: " + e.getMessage());
        }

        return false;
    }


    // =========================================================
    // FIND ALL MEDICATIONS
    // =========================================================

    public List<Medication> findAllMedications() {

        List<Medication> medications = new ArrayList<>();

        String sql = "SELECT MedicationId, Name, Description, DosageForm, Price, QuantityInStock "
                   + "FROM Medication ORDER BY MedicationId";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                medications.add(mapMedication(resultSet));
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error retrieving medications: " + e.getMessage());
        }

        return medications;
    }


    // =========================================================
    // FIND MEDICATION BY ID
    // =========================================================

    public Medication findMedicationById(int medicationId) {

        String sql = "SELECT MedicationId, Name, Description, DosageForm, Price, QuantityInStock "
                   + "FROM Medication WHERE MedicationId = ?";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, medicationId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Medication medication = mapMedication(resultSet);
                connection.close();
                return medication;
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error finding medication: " + e.getMessage());
        }

        return null;
    }


    // =========================================================
    // FIND AVAILABLE MEDICATIONS (in stock)
    // =========================================================

    public List<Medication> findAvailableMedications() {

        List<Medication> medications = new ArrayList<>();

        String sql = "SELECT MedicationId, Name, Description, DosageForm, Price, QuantityInStock "
                   + "FROM Medication WHERE QuantityInStock > 0 ORDER BY MedicationId";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                medications.add(mapMedication(resultSet));
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error retrieving available medications: " + e.getMessage());
        }

        return medications;
    }


    // =========================================================
    // FIND LOW STOCK MEDICATIONS (20 or fewer units)
    // =========================================================

    public List<Medication> findLowStockMedications() {

        List<Medication> medications = new ArrayList<>();

        String sql = "SELECT MedicationId, Name, Description, DosageForm, Price, QuantityInStock "
                   + "FROM Medication WHERE QuantityInStock <= 20 ORDER BY MedicationId";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                medications.add(mapMedication(resultSet));
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error retrieving low stock medications: " + e.getMessage());
        }

        return medications;
    }


    // =========================================================
    // UPDATE STOCK QUANTITY
    // =========================================================

    public boolean updateStock(int medicationId, int newQuantity) {

        String sql = "UPDATE Medication SET QuantityInStock = ? WHERE MedicationId = ?";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, newQuantity);
            statement.setInt(2, medicationId);

            int rows = statement.executeUpdate();
            connection.close();

            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error updating medication stock: " + e.getMessage());
        }

        return false;
    }


    // =========================================================
    // MAP RESULTSET TO MEDICATION
    // =========================================================

    private Medication mapMedication(ResultSet resultSet) throws SQLException {

        Medication medication = new Medication();

        medication.setId(resultSet.getInt("MedicationId"));
        medication.setName(resultSet.getString("Name"));
        medication.setDescription(resultSet.getString("Description"));
        medication.setDosageForm(resultSet.getString("DosageForm"));
        medication.setPrice(resultSet.getDouble("Price"));
        medication.setQuantityInStock(resultSet.getInt("QuantityInStock"));

        return medication;
    }
}
