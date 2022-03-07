import entity.Room;
import inputs.InputReceiver;
import service.RoomServiceImpl;


import java.util.Scanner;

import static statements.MessageProvider.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        RoomServiceImpl roomService = new RoomServiceImpl();
        InputReceiver inputReceiver = new InputReceiver();
        boolean appOn = true;

        while (appOn) {
            showMainMenu();

            switch (scanner.nextInt()) {
                // shows all rooms
                case 1 -> System.out.println(roomService.getAllRooms() + "\n");
                // show more information about room with specific number
                case 2 -> {
                    String number = inputReceiver.inputRoomNumber(scanner);
                    System.out.println("\nRoom details:\n");
                    System.out.println(roomService.showRoomDetails(number));
                }
                // Add room
                case 3 -> {
                    Room room = inputReceiver.typeRoom(scanner);
                    roomService.saveRoom(room);
                    System.out.println("Room added: " + roomService.getRoomByRoomNumber(room.getRoomNumber()));
                }
                // Edit room
                case 4 -> {
                    Room room = inputReceiver.typeRoom(scanner);
                    System.out.println(room);
                    roomService.editRoom(room);
                }
                // Delete room
                case 5 -> {
                    String number = inputReceiver.inputRoomNumber(scanner);
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
}
