package api;

import entity.Room;

import java.util.List;

public interface RoomService {
    List<Room> getAllRooms();
    Room getRoomByRoomNumber(String roomNumber);

    boolean isRoomAvailable(String roomNumber);

    void saveRoom(Room room);
    void editRoom(String roomNumber, int singleBed, int doubleBed, boolean balcony);
   void deleteRoom(String roomNumber);
}
