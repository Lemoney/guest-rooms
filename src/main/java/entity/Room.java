package entity;

public class Room {
    private String roomNumber;
    private int singleBeds;
    private int doubleBeds;
    private int roomCapacity;
    private boolean balcony;

    public Room(String roomNumber, int singleBed, int doubleBed, boolean balcony) {

        this.roomNumber = roomNumber;
        this.singleBeds = singleBed;
        this.doubleBeds = doubleBed;
        this.balcony = balcony;
        if (singleBed > 0) roomCapacity += singleBed;
        if (doubleBed > 0) roomCapacity += doubleBed * 2;
    }


    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }

    public int getSingleBeds() {
        return singleBeds;
    }

    public void setSingleBeds(int singleBeds) {
        roomCapacity = doubleBeds + singleBeds;
        this.singleBeds = singleBeds;
    }

    public int getDoubleBeds() {
        return doubleBeds;
    }

    public void setDoubleBeds(int doubleBeds) {
        roomCapacity = singleBeds + 2 * doubleBeds;
        this.doubleBeds = doubleBeds;
    }


    public boolean isBalcony() {
        return balcony;
    }

    public void setBalcony(boolean balcony) {
        this.balcony = balcony;
    }


    public String roomDetails() {
        return "Room number: " + roomNumber +
                ", \nSingle beds: " + singleBeds +
                ", \nDouble beds: " + doubleBeds +
                ", \nBalcony: " + balcony + "\n";
    }

    @Override
    public String toString() {
        return "\nRoom number: " + roomNumber +
                ", Room capacity: " + roomCapacity +
                ", Balcony: " + balcony;
    }


}
