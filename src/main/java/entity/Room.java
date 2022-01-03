package entity;

public class Room {
    private int roomNumber;
    private int singleBed;
    private int doubleBed;
    private int roomCapacity;
    private boolean balcony;

    public Room(int roomNumber, int singleBed, int doubleBed, boolean balcony) {

        this.roomNumber = roomNumber;
        this.singleBed = singleBed;
        this.doubleBed = doubleBed;
        this.balcony = balcony;
        if (singleBed > 0) roomCapacity += singleBed;
        if (doubleBed > 0) roomCapacity += doubleBed * 2;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }

    public int getSingleBed() {
        return singleBed;
    }

    public void setSingleBed(int singleBed) {
        this.singleBed = singleBed;
    }

    public int getDoubleBed() {
        return doubleBed;
    }

    public void setDoubleBed(int doubleBed) {
        this.doubleBed = doubleBed;
    }



    public boolean isBalcony() {
        return balcony;
    }

    public void setBalcony(boolean balcony) {
        this.balcony = balcony;
    }



    public String roomDetails() {
        return "Room number: " + roomNumber +
                ", \nSingle beds: " + singleBed +
                ", \nDouble beds: " + doubleBed +
                ", \nBalcony: " + balcony + "\n";
    }

    @Override
    public String toString() {
        return "\nRoom number: " + roomNumber +
                ", Room capacity: " + roomCapacity +
                ", Balcony: " + balcony;
    }
}
