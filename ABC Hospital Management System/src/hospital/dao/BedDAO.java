package hospital.dao;

import hospital.database.DatabaseConnection;
import hospital.models.Bed;
import hospital.models.Room;
import hospital.models.Ward;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BedDAO {

    // =========================================================
    // ADD BED
    // =========================================================

    public boolean addBed(Bed bed) {

        String sql = "INSERT INTO Bed (BedNumber, RoomId, Occupied) VALUES (?, ?, 0)";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, bed.getBedNumber());
            statement.setInt(2, bed.getRoom().getId());

            statement.executeUpdate();

            ResultSet keys = statement.getGeneratedKeys();
            if (keys.next()) {
                bed.setId(keys.getInt(1));
            }
            keys.close();
            connection.close();

            bed.setStatus("AVAILABLE");
            return true;

        } catch (SQLException e) {
            System.out.println("Error adding bed: " + e.getMessage());
        }

        return false;
    }


    // =========================================================
    // FIND ALL BEDS
    // =========================================================

    public List<Bed> findAllBeds() {

        List<Bed> beds = new ArrayList<>();

        String sql = baseSelect() + " ORDER BY bd.BedId";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                beds.add(mapBed(resultSet));
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error retrieving beds: " + e.getMessage());
        }

        return beds;
    }


    // =========================================================
    // FIND BED BY ID
    // =========================================================

    public Bed findBedById(int bedId) {

        String sql = baseSelect() + " WHERE bd.BedId = ?";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, bedId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Bed bed = mapBed(resultSet);
                connection.close();
                return bed;
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error finding bed: " + e.getMessage());
        }

        return null;
    }


    // =========================================================
    // FIND AVAILABLE BEDS
    // =========================================================

    public List<Bed> findAvailableBeds() {

        List<Bed> beds = new ArrayList<>();

        String sql = baseSelect() + " WHERE bd.Occupied = 0 ORDER BY bd.BedId";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                beds.add(mapBed(resultSet));
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error retrieving available beds: " + e.getMessage());
        }

        return beds;
    }


    // =========================================================
    // FIND OCCUPIED BEDS
    // =========================================================

    public List<Bed> findOccupiedBeds() {

        List<Bed> beds = new ArrayList<>();

        String sql = baseSelect() + " WHERE bd.Occupied = 1 ORDER BY bd.BedId";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                beds.add(mapBed(resultSet));
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error retrieving occupied beds: " + e.getMessage());
        }

        return beds;
    }


    // =========================================================
    // BASE SELECT (shared by every read method above)
    // =========================================================

    private String baseSelect() {

        return "SELECT bd.BedId, bd.BedNumber, bd.Occupied, "
             + "r.RoomId, r.RoomNumber, "
             + "w.WardId, w.Name AS WardName "
             + "FROM Bed bd "
             + "INNER JOIN Room r ON bd.RoomId = r.RoomId "
             + "INNER JOIN Ward w ON r.WardId = w.WardId";
    }


    // =========================================================
    // MAP RESULTSET TO BED
    // =========================================================

    private Bed mapBed(ResultSet resultSet) throws SQLException {

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
        bed.setStatus(resultSet.getBoolean("Occupied") ? "OCCUPIED" : "AVAILABLE");

        return bed;
    }
}
