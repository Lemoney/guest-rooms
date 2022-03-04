import entity.Room;
import service.RoomServiceImpl;


import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        RoomServiceImpl roomService = new RoomServiceImpl();

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
                    Room room = typeRoom();
                    roomService.saveRoom(room);
                    System.out.println("Dodano pokój: " + roomService.getRoomByRoomNumber(room.getRoomNumber()));
                }
                case 4 -> {

                    System.out.println("Podaj numer pokoju który chcesz edytować");
                    Room room = typeRoom();
                    System.out.println(room);
                    roomService.editRoom(room);
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

    private static Room typeRoom() {
        String numer = scanner.next();
        System.out.println("Podaj ilość pojedynczych łóżek w pokoju:");
        int singlebed = scanner.nextInt();
        System.out.println("Podaj ilość podwójnych łóżek w pokoju:");
        int doubleBed = scanner.nextInt();
        System.out.println("Czy pokój posiada balkon? true/false");
        boolean balkon = scanner.nextBoolean();
        return new Room(numer, singlebed, doubleBed, balkon);
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
}
