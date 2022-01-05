package api;

import entity.Room;

import java.util.List;

public interface RoomDao {

    List<Room> getAllRooms();

    void saveRoom(Room room);

    void removeRoomByRoomNumber(int roomNumber);

    void changeNumberOfSingleBeds(String roomNumber, int newNumber);
    void changeNumberOfDoubleBeds(String roomNumber, int newNumber);
}
