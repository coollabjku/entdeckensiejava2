package Aufgaben.Kapitel37;

// Aufgabe 71
public class TravelOffice {
    private Flight[] flights;
    private String name;

    public TravelOffice(String name) {
        this.name = name;
        this.flights = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addFlight(Flight flight) {
        if (this.flights == null) {
            this.flights = new Flight[] { flight };
        } else {
            Flight[] tmp = new Flight[this.flights.length + 1];
            for (int i = 0; i < this.flights.length; i++) {
                tmp[i] = this.flights[i];
            }
            tmp[tmp.length - 1] = flight;
            this.flights = tmp;
        }
    }

    public Flight hasFlight(String from, String to) {
        Flight f = null;
        for (int i = 0; i < this.flights.length; i++) {
            if (this.flights[i].getFrom().equals(from) && this.flights[i].getTo().equals(to)) {
                f = this.flights[i];
                break;
            }
        }
        return f;
    }

    // Aufgabe 81
    // TODO: Overwrite this method
    public boolean bookFlight(Flight f) {
        return f.reserveSeat();
    }

    // Aufgabe 81
    // TODO: Overwrite this method
    public boolean bookFlight2(Flight f) {
        return f.reserveSeat();
    }
}