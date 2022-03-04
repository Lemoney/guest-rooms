import entity.Room;
import service.RoomServiceImpl;


import java.util.Scanner;

import static statements.MessageProvider.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        RoomServiceImpl roomService = new RoomServiceImpl();
        boolean appOn = true;

        while(appOn) {
            showMainMenu();

            switch (scanner.nextInt()) {
                // shows all rooms
                case 1 -> System.out.println(roomService.getAllRooms() + "\n");
                // show more information about room with specific number
                case 2 -> {
                    System.out.println(TYPE_ROOM_NUMBER);
                    String number = scanner.next();
                    System.out.println(roomService.showRoomDetails(number));
                }
                // Add room
                case 3 -> {
                    System.out.println(TYPE_ROOM_NUMBER);
                    Room room = typeRoom();
                    roomService.saveRoom(room);
                    System.out.println("Room added: " + roomService.getRoomByRoomNumber(room.getRoomNumber()));
                }
                // Edit room
                case 4 -> {
                    System.out.println(TYPE_ROOM_NUMBER);
                    Room room = typeRoom();
                    System.out.println(room);
                    roomService.editRoom(room);
                }
                // Delete room
                case 5 -> {
                    System.out.println(TYPE_ROOM_NUMBER);
                    String number = scanner.next();
                    roomService.deleteRoom(number);
                }
                // Showing rooms with specific capacity
                case 6 -> {
                    System.out.println(TYPE_ROOM_CAPACITY);
                    int capacity = scanner.nextInt();
                    System.out.println(roomService.showRoomsWithNumberOfCapacity(capacity));
                }
                case 0 -> {
                    appOn = false;
                    System.out.println(EXIT);
                }
            }
        }
    }

    private static Room typeRoom() {
        String numer = scanner.next();
        System.out.println("Type number of single beds:");
        int singlebed = scanner.nextInt();
        System.out.println("Type number of double bed:");
        int doubleBed = scanner.nextInt();
        System.out.println("Does the room contain balcony? true/false");
        boolean balkon = scanner.nextBoolean();
        return new Room(numer, singlebed, doubleBed, balkon);
    }
}
