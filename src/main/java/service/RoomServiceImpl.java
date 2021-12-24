package service;

import api.RoomService;
import entity.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomServiceImpl implements RoomService {

    List<Room> rooms;

    public RoomServiceImpl(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public List<Room> getAllRooms() { //Będę używął jak połącze z bazą danych
        return rooms;
    }

    @Override
    public Room getRoomById(int id) {
        for (Room room : rooms) {
            if (room.getRoomID() == id) {
                return room;
            }
        }
        return null;
    }

    @Override
    public boolean isRoomAvailable(int id) {
        return false;
    }

    @Override
    public void saveRoom(Room room) { //next to do
    }

    @Override
    public void editRoom(int id) {

    }

    @Override
    public void deleteRoom(int id) {

    }

    public void saveRooms(List<Room> rooms) {

    }
}
