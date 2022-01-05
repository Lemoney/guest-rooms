import entity.Room;
import service.RoomServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Room> rooms = defaultRooms();
        RoomServiceImpl roomService = new RoomServiceImpl(rooms);

        boolean appOn = true;


        while(appOn) {
            showMainMenu();

            switch (scanner.nextInt()) {
                case 1 -> System.out.println(roomService.getAllRooms() + "\n");
                case 2 -> {
                    System.out.println("Podaj numer pokoju");
                    String numer = scanner.next();
                    System.out.println(roomService.showRoomDetails(numer));
                }
                case 3 -> {
                    System.out.println("Podaj numer pokoju:");
                    String numer = scanner.next();
                    System.out.println("Podaj ilość pojedynczych łóżek w pokoju:");
                    int singlebed = scanner.nextInt();
                    System.out.println("Podaj ilość podwójnych łóżek w pokoju:");
                    int doubleBed = scanner.nextInt();
                    System.out.println("Czy pokój posiada balkon? true/false");
                    boolean balkon = scanner.nextBoolean();
                    roomService.saveRoom(new Room(numer, singlebed, doubleBed, balkon));
                    System.out.println("Dodano pokój: " + roomService.getRoomByRoomNumber(numer));
                }
                case 4 -> {
                    System.out.println("Podaj numer pokoju który chcesz edytować");
                    String numer = scanner.next();
                    System.out.println("Podaj ilość pojedynczych łóżek w pokoju:");
                    int singlebed = scanner.nextInt();
                    System.out.println("Podaj ilość podwójnych łóżek w pokoju:");
                    int doubleBed = scanner.nextInt();
                    System.out.println("Czy pokój posiada balkon? true/false");
                    boolean balkon = scanner.nextBoolean();
                    roomService.editRoom(numer, singlebed, doubleBed, balkon);
                }
                case 5 -> {
                    System.out.println("Podaj numer pokoju który chcesz usunąć");
                    String numer = scanner.next();
                    roomService.deleteRoom(numer);
                }
                case 6 -> {
                    System.out.println("Podaj pojemność pokoi które mają być wyświetlone");
                    int capacity = scanner.nextInt();
                    System.out.println(roomService.showRoomsWithNumberOfCapacity(capacity));
                }
                case 0 -> {
                    appOn = false;
                    System.out.println("Żegnaj kowboju!");
                }
            }
        }




    }

    private static void showMainMenu() {
        System.out.println("----------MENU----------");
        System.out.println("1. Wyświetl inforamcje o wszystkich pokojach");
        System.out.println("2. Wyświetl informacje o pokoju");
        System.out.println("3. Dodaj pokój");
        System.out.println("4. Edytuj pokój");
        System.out.println("5. Usuń pokój");
        System.out.println("6. Pokaż pokoje o określonej pojemności");
        System.out.println("0. Wyjdź");
    }



    static List<Room> defaultRooms() {
        Room room_1 = new Room("1", 1, 1, true);
        Room room_2 = new Room("2", 1, 2, true);
        Room room_3 = new Room("3", 2, 1, false);
        Room room_4 = new Room("4", 0, 2, false);
        Room room_5 = new Room("5", 0, 0, false);
        Room room_6 = new Room("6", 2, 1, false);
        Room room_7 = new Room("7", 2, 1, false);
        Room room_8 = new Room("8", 1, 2, false);
        Room room_9 = new Room("9", 1, 2, false);
        Room room_10 = new Room("10", 1, 2, true);
        Room room_11 = new Room("11", 1, 1, true);
        Room room_12 = new Room("12", 2, 1, false);
        Room room_13 = new Room("13", 0, 1, false);
        Room room_14 = new Room("14", 0, 1, false);
        Room room_15 = new Room("15", 1, 1, false);
        Room room_16 = new Room("16", 1, 1, false);

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
