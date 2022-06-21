package Loesungen.Kapitel37;

// Aufgabe 80
public class Flight {
    private int flightnumber;
    private int capacity;
    private String from;
    private String to;

    public Flight(int flightnumber, int capacity, String from, String to) {
        this.flightnumber = flightnumber;
        this.capacity = capacity;
        this.from = from;
        this.to = to;
    }

    public int getFlightnumber() {
        return flightnumber;
    }

    public void setFlightnumber(int flightnumber) {
        this.flightnumber = flightnumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void reserveSeat() throws NoSeatsAvailableException {
        if (this.capacity <= 0) {
            throw new NoSeatsAvailableException(this);
        }
        this.capacity--;
    }

    @Override
    public String toString() {
        return "Flight number " + this.flightnumber + " from " + this.from + " to " + this.to + ". Seats left: "
                + this.capacity;
    }

}
