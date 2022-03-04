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

    public Room getRoomByRoomNumber(String roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber().equals(roomNumber)) {
                return room;
            }
        }
        return null;
    }

    public String showRoomDetails(String roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber().equals(roomNumber)) {
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
    public void editRoom(String roomNumber, int singleBed, int doubleBed, boolean balcony) {
        for (Room room : rooms) {
            if (room.getRoomNumber().equals(roomNumber)) {
                room.setSingleBeds(singleBed);
                room.setDoubleBeds(doubleBed);
                room.setBalcony(balcony);
            }
        }
    }

    public void editRoom(Room editedRoom) {
        for (Room room : rooms) {
            if(room.getRoomNumber().equals(editedRoom.getRoomNumber())) {
                room.setSingleBeds(editedRoom.getSingleBeds());
                room.setDoubleBeds(editedRoom.getDoubleBeds());
                room.setBalcony(editedRoom.isBalcony());
                System.out.println(room);
                System.out.println(editedRoom);
            }

        }
    }

    @Override
    public void deleteRoom(String roomNumber) {
        rooms.removeIf(room -> room.getRoomNumber().equals(roomNumber));
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
