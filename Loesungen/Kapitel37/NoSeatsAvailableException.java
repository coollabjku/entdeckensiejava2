package Loesungen.Kapitel37;

// Aufgabe 79
public class NoSeatsAvailableException extends Exception {
    private Flight flight;

    public NoSeatsAvailableException(Flight flight) {
        this.flight = flight;
    }

    @Override
    public String getMessage() {
        return "No seats available for : " + flight;
    }

}
