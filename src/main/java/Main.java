import entity.Room;
import service.RoomServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        List<Room> rooms = defaultRooms();
        RoomServiceImpl roomService = new RoomServiceImpl(rooms);

        System.out.println(roomService.getAllRooms());
        System.out.println(roomService.getRoomById(5));

    }



        static List<Room> defaultRooms() {
            Room room_1 = new Room(1, 3, true);
            Room room_2 = new Room(2, 3, true);
            Room room_3 = new Room(3, 4, false);
            Room room_4 = new Room(4, 2, false);
            Room room_5 = new Room(5, 0, false);
            Room room_6 = new Room(6, 4, false);
            Room room_7 = new Room(7, 4, false);
            Room room_8 = new Room(8, 3, false);
            Room room_9 = new Room(9, 3, false);
            Room room_10 = new Room(10, 3, true);
            Room room_11 = new Room(11, 3, true);
            Room room_12 = new Room(12, 4, false);
            Room room_13 = new Room(13, 2, false);
            Room room_14 = new Room(14, 2, false);
            Room room_15 = new Room(15, 3, false);
            Room room_16 = new Room(16, 3, false);

            List<Room> rooms = new ArrayList<>();
            rooms.add(room_1);
            rooms.add(room_2);
            rooms.add(room_3);
            rooms.add(room_4);
            rooms.add(room_5);
            rooms.add(room_6);
            rooms.add(room_7);
            rooms.add(room_8);
            rooms.add(room_9);
            rooms.add(room_10);
            rooms.add(room_11);
            rooms.add(room_12);
            rooms.add(room_13);
            rooms.add(room_14);
            rooms.add(room_15);
            rooms.add(room_16);
            return rooms;
        }
}
