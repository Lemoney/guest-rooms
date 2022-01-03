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
    public List<Room> getAllRooms() {
        return rooms;
    }

    @Override
    public Room getRoomById(int id) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == id) {
                return room;
            }
        }
        return null;
    }

    public String showRoomDetails(int id) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == id) {
                return room.roomDetails();
            }
        }
        return null;
    }

    @Override
    public boolean isRoomAvailable(int id) { //jak połączę z bazą danych
        return false;
    }

    @Override
    public void saveRoom(Room room) {
        rooms.add(room);
    }

    @Override
    public void editRoom(int id, int singleBed, int doubleBed, boolean balcony) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == id) {
                room.setSingleBed(singleBed);
                room.setDoubleBed(doubleBed);
                room.setBalcony(balcony);
            }
        }
    }

    @Override
    public void deleteRoom(int id) {
        rooms.removeIf(room -> room.getRoomNumber() == id);
    }

    public List<Room> showRoomsWithNumberOfCapacity(int capacity) {
        List<Room> roomList = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getRoomCapacity() == capacity) {
                roomList.add(room);
            }
        }
        return roomList;
    }
}
