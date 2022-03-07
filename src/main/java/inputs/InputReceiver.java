package inputs;

import entity.Room;
import service.RoomServiceImpl;

import java.util.Scanner;

import static statements.MessageProvider.TYPE_ROOM_NUMBER;

public class InputReceiver {

    RoomServiceImpl roomService = new RoomServiceImpl();
    public Room typeRoom(Scanner scanner) {

        do {
            String number;
            int singlebed;
            int doubleBed;
            boolean balcony;
            try {
                number = inputRoomNumber(scanner);
                if (!roomService.isRoomNumberAvailable(number))  {
                    System.out.println("Room number exists");
                    continue;
                }
                System.out.println("Type number of single beds:");
                singlebed = scanner.nextInt();
                System.out.println("Type number of double bed:");
                doubleBed = scanner.nextInt();
                System.out.println("Does the room contain balcony? true/false");
                balcony = scanner.nextBoolean();
                return new Room(number, singlebed, doubleBed, balcony);
            } catch (Exception e) {
                System.out.println("Wrong input. Try again");
                scanner.nextLine();
            }
        } while (true);
    }

    public String inputRoomNumber(Scanner scanner) {
        boolean isDone = false;
        String number = null;
        do {
            System.out.println(TYPE_ROOM_NUMBER);
            if (scanner.hasNext()) {
                number = scanner.next();
                if (isInputTheNumber(number)) {
                    isDone = true;
                } else {
                    System.out.println("Wrong input - numbers only");
                }
            }
        } while (!isDone);
        return number;
    }

    private boolean isInputTheNumber(String input) {
            return input.matches("[0-9]+");
    }
}
