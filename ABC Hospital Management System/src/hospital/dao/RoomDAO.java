package hospital.dao;

import hospital.database.DatabaseConnection;
import hospital.models.Room;
import hospital.models.Ward;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {

    // =========================================================
    // ADD ROOM
    // =========================================================

    public boolean addRoom(Room room) {

        String sql = "INSERT INTO Room (RoomNumber, WardId, RoomType, Capacity) VALUES (?, ?, ?, ?)";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, room.getRoomNumber());
            statement.setInt(2, room.getWard().getId());
            statement.setString(3, room.getRoomType());
            statement.setInt(4, room.getCapacity());

            statement.executeUpdate();

            ResultSet keys = statement.getGeneratedKeys();
            if (keys.next()) {
                room.setId(keys.getInt(1));
            }
            keys.close();
            connection.close();

            return true;

        } catch (SQLException e) {
            System.out.println("Error adding room: " + e.getMessage());
        }

        return false;
    }


    // =========================================================
    // FIND ALL ROOMS
    // =========================================================

    public List<Room> findAllRooms() {

        List<Room> rooms = new ArrayList<>();

        String sql = baseSelect() + " ORDER BY r.RoomId";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                rooms.add(mapRoom(resultSet));
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error retrieving rooms: " + e.getMessage());
        }

        return rooms;
    }


    // =========================================================
    // FIND ROOM BY ID
    // =========================================================

    public Room findRoomById(int roomId) {

        String sql = baseSelect() + " WHERE r.RoomId = ?";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, roomId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Room room = mapRoom(resultSet);
                connection.close();
                return room;
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error finding room: " + e.getMessage());
        }

        return null;
    }


    // =========================================================
    // FIND ROOMS BY WARD
    // =========================================================

    public List<Room> findRoomsByWard(int wardId) {

        List<Room> rooms = new ArrayList<>();

        String sql = baseSelect() + " WHERE r.WardId = ? ORDER BY r.RoomId";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, wardId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                rooms.add(mapRoom(resultSet));
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error retrieving rooms for ward: " + e.getMessage());
        }

        return rooms;
    }


    // =========================================================
    // BASE SELECT (shared by every read method above)
    // =========================================================

    private String baseSelect() {

        return "SELECT r.RoomId, r.RoomNumber, r.RoomType, r.Capacity, "
             + "w.WardId, w.Name AS WardName, w.WardType, w.Capacity AS WardCapacity "
             + "FROM Room r "
             + "INNER JOIN Ward w ON r.WardId = w.WardId";
    }


    // =========================================================
    // MAP RESULTSET TO ROOM
    // =========================================================

    private Room mapRoom(ResultSet resultSet) throws SQLException {

        Ward ward = new Ward();
        ward.setId(resultSet.getInt("WardId"));
        ward.setName(resultSet.getString("WardName"));
        ward.setWardType(resultSet.getString("WardType"));
        ward.setCapacity(resultSet.getInt("WardCapacity"));

        Room room = new Room();
        room.setId(resultSet.getInt("RoomId"));
        room.setRoomNumber(resultSet.getString("RoomNumber"));
        room.setRoomType(resultSet.getString("RoomType"));
        room.setCapacity(resultSet.getInt("Capacity"));
        room.setWard(ward);

        return room;
    }
}
