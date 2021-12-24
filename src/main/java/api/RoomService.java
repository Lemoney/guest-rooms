package api;

import entity.Room;

import java.util.List;

public interface RoomService {
    List<Room> getAllRooms();
    Room getRoomById(int id);

    boolean isRoomAvailable(int id);

    void saveRoom(Room room);
    void editRoom(int id);
    void deleteRoom(int id);
}
