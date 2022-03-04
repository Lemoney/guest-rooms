package statements;

public class MessageProvider {

    public static final String TYPE_ROOM_NUMBER = "Type the room number:";
    public static final String TYPE_ROOM_CAPACITY = "Input capacity to search rooms:";
    public static final String EXIT = "Good bye!";

    public static void showMainMenu() {
        System.out.println("----------MENU----------");
        System.out.println("1. Show all rooms");
        System.out.println("2. Show room details");
        System.out.println("3. Add room");
        System.out.println("4. Edit room");
        System.out.println("5. Delete room");
        System.out.println("6. Show rooms with specific capacity");
        System.out.println("0. Exit");
    }
}
