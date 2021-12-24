package entity;

public class Room {
    private int roomID;
    private int roomCapacity;
    private boolean balcony;

    public Room(int roomID, int roomCapacity, boolean balcony) {
        this.roomID = roomID;
        this.roomCapacity = roomCapacity;
        this.balcony = balcony;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(int roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    public boolean isBalcony() {
        return balcony;
    }

    public void setBalcony(boolean balcony) {
        this.balcony = balcony;
    }

    @Override
    public String toString() {
        return "Room number: " + roomID +
                ", roomCapacity: " + roomCapacity +
                ", balcony: " + balcony + " |";
    }
}
