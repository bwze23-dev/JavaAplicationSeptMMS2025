package hospital.userview;

import hospital.models.Room;

import java.util.List;

public class RoomView {

    public void displayRooms(List<Room> rooms) {

        if (rooms == null || rooms.isEmpty()) {
            System.out.println();
            System.out.println("No rooms found.");
            return;
        }

        System.out.println();
        System.out.println("========================================================");
        System.out.printf("%-6s %-10s %-20s %-15s %-10s%n", "ID", "ROOM NO", "WARD", "TYPE", "CAPACITY");
        System.out.println("========================================================");

        for (Room r : rooms) {
            System.out.printf("%-6d %-10s %-20s %-15s %-10d%n",
                    r.getId(), r.getRoomNumber(),
                    r.getWard() != null ? r.getWard().getName() : "",
                    r.getRoomType() != null ? r.getRoomType() : "",
                    r.getCapacity());
        }

        System.out.println("========================================================");
    }

    public void displayRoomAdded() {
        System.out.println();
        System.out.println("Room added successfully.");
    }
}
