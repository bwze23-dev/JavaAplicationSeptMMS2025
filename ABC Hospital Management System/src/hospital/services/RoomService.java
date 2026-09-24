package hospital.services;

import hospital.dao.RoomDAO;
import hospital.models.Room;

import java.util.List;

public class RoomService {

    private final RoomDAO roomDAO;

    public RoomService() {
        roomDAO = new RoomDAO();
    }

    public boolean addRoom(Room room) {

        if (room == null) {
            System.out.println("Room cannot be null.");
            return false;
        }

        if (room.getRoomNumber() == null || room.getRoomNumber().trim().isEmpty()) {
            System.out.println("Room number is required.");
            return false;
        }

        roomDAO.addRoom(room);
        return true;
    }

    public List<Room> getAllRooms() {
        return roomDAO.findAllRooms();
    }

    public Room getRoomById(int roomId) {

        if (roomId <= 0) {
            System.out.println("Invalid room ID.");
            return null;
        }

        return roomDAO.findRoomById(roomId);
    }

    public List<Room> getRoomsByWard(int wardId) {
        return roomDAO.findRoomsByWard(wardId);
    }
}
