package Loesungen.Kapitel5;

// Aufgabe 12
public class HotelRoom {
    boolean doubleBed;
    int roomNo;
    int floorNo;

    public HotelRoom(boolean doubleBed, int roomNo, int floorNo) {
        this.doubleBed = doubleBed;
        this.roomNo = roomNo;
        this.floorNo = floorNo;
    }

    public boolean isDoubleBed() {
        return doubleBed;
    }

    public void setDoubleBed(boolean doubleBed) {
        this.doubleBed = doubleBed;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }
}
