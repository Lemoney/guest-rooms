package service;

import entity.Room;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RoomServiceImplTest {
    List<Room> rooms;
    RoomServiceImpl roomService;
    @Before
    public void setUp() throws Exception {
        rooms = new ArrayList<>();
        rooms.add(new Room(1, 1, 1, true));
        rooms.add(new Room(2, 1, 2, true));
        rooms.add(new Room(3, 2, 1, false));
        rooms.add(new Room(4, 0, 2, false));
        rooms.add(new Room(5, 0, 0, false));
        roomService = new RoomServiceImpl(rooms);
    }

    @Test
    public void getAllRooms(){
        List<Room> roomList = new ArrayList<>(List.copyOf(rooms));
        Room nextRoom = new Room(20, 1, 1, true);

        roomList.add(nextRoom);
        roomService.saveRoom(nextRoom);

        assertEquals(roomList, roomService.getAllRooms());
    }

    @Test
    public void getRoomByIdCorrect() {
        assertEquals(rooms.get(0), roomService.getRoomById(1));
    }

    @Test
    public void getRoomByIdNotCorrect() {
        assertNotEquals(rooms.get(3), roomService.getRoomById(1));
    }

    @Test
    public void saveRoom() {
        List<Room> roomList = new ArrayList<>(List.copyOf(rooms));
        Room room20 = new Room(20, 1, 1, true);
        roomList.add(room20);
        roomService.saveRoom(room20);
        assertEquals(roomList.toString(), rooms.toString());
    }

    @Test
    public void deleteRoom() {
        List<Room> roomList = new ArrayList<>(List.copyOf(rooms));
        roomList.remove(0);
        roomService.deleteRoom(1);
        assertEquals(roomList.toString(), rooms.toString());

    }
}