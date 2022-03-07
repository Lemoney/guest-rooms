package service;

import api.RoomDao;
import api.RoomService;
import dao.RoomDaoImpl;
import entity.Room;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RoomServiceImpl implements RoomService {

    RoomDao roomDao = new RoomDaoImpl();


    @Override
    public List<Room> getAllRooms() {
        return roomDao.getAllRooms();
    }

    public Room getRoomByRoomNumber(String roomNumber) {
        List<Room> rooms = getAllRooms();
        for (Room room : rooms) {
            if (room.getRoomNumber().equals(roomNumber)) return room;
        }
        return null;
    }

    public String showRoomDetails(String roomNumber) {
        List<Room> rooms = getAllRooms();
        for (Room room : rooms) {
            if (room.getRoomNumber().equals(roomNumber)) return room.roomDetails();
        }
        return "Room doesn't exist";
    }

    @Override
    public boolean isRoomAvailable(String roomNumber) { //jak połączę z bazą danych
        return true;
    }

    public boolean isRoomNumberAvailable(String roomNumber) {
        List<Room> rooms = getAllRooms();
        for (Room room : rooms) {
            if (roomNumber.equals(room.getRoomNumber())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void saveRoom(Room room) {
        roomDao.saveRoom(room);
    }

    @Override
    public void editRoom(String roomNumber, int singleBed, int doubleBed, boolean balcony) {
        List<Room> rooms = getAllRooms();
        for (Room room : rooms) {
            if (room.getRoomNumber().equals(roomNumber)) {
                room.setSingleBeds(singleBed);
                room.setDoubleBeds(doubleBed);
                room.setBalcony(balcony);
            }
        }
    }

    public void editRoom(Room editedRoom) {
        List<Room> rooms = getAllRooms();

        for (Room room : rooms) {
            if (room.getRoomNumber().equals(editedRoom.getRoomNumber())) {
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
        if (isRoomNumberAvailable(roomNumber)) {
            roomDao.removeRoomByRoomNumber(Integer.parseInt(roomNumber));
        } else {
            System.out.println("Room doesn't exist");
        }
    }

    public List<Room> showRoomsWithNumberOfCapacity(int capacity) {
        List<Room> rooms = getAllRooms();
        List<Room> roomList = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getRoomCapacity() == capacity) {
                roomList.add(room);
            }
        }
        return roomList;
    }
}
