package Aufgaben.Kapitel37;

public class TravelOfficeRun {

    public static void main(String[] args) {

        Flight f1 = new Flight(4711, 5, "Hong Kong", "Vienna");
        Flight f2 = new Flight(2318, 1, "Vienna", "New York");
        Flight f3 = new Flight(8899, 3, "Klagenfurt", "Frankfurt");
        Flight f4 = new Flight(9921, 7, "Graz", "Paris");
        Flight f5 = new Flight(4322, 5, "Zuerich", "Amsterdam");

        TravelOffice office1 = new TravelOffice("Linger Reisebuero");
        TravelOffice office2 = new TravelOffice("Holliday Booking");

        office1.addFlight(f1);
        office1.addFlight(f2);
        office1.addFlight(f3);

        office2.addFlight(f4);
        office2.addFlight(f5);
        office2.addFlight(f2);

        /*
         * printBookingDetails("Vienna", "New York", office1);
         * printBookingDetails("Hong Kong", "Vienna", office1);
         * printBookingDetails("Vienna", "New York", office2);
         * printBookingDetails("Klagenfurt", "Frankfurt", office2);
         */

        printBookingDetails2("Vienna", "New York", office1);
        printBookingDetails2("Hong Kong", "Vienna", office1);
        printBookingDetails2("Vienna", "New York", office2);
        printBookingDetails2("Klagenfurt", "Frankfurt", office2);

    }

    public static void printBookingDetails(String from, String to, TravelOffice office) {
        // TODO: Your code here
    }

    public static void printBookingDetails2(String from, String to, TravelOffice office) {
        Flight route = office.hasFlight(from, to);
        if (route != null) {
            if (office.bookFlight2(route)) {
                System.out.println("Successfuly booked flight: " + route.toString());
            } else {
                System.err.println("There are no seats left on flight: " + route.toString());
            }
        } else {
            System.err.println("This office has no flight from " + from + " to " + to + ".");
        }
    }
}