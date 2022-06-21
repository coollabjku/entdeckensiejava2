package Loesungen.Kapitel14;

// Aufgabe 42
public class Laptop {
    private int battery;
    private String manufacturer;

    public Laptop(String hersteller) {
        this.battery = 100;
        this.manufacturer = hersteller;
    }

    public void browse1(int durationInHrs) {
        while (durationInHrs > 0 && battery >= 10) {
            battery -= 10;
            durationInHrs--;
        }
    }

    public void browse2(int durationInHrs) {
        if (durationInHrs <= 0) {
            return;
        }
        battery -= 10 * Math.min(battery / 10, durationInHrs);
    }

    public void browse3(int durationInHrs) {
        if (durationInHrs <= 0) {
            return;
        }
        if (battery - durationInHrs * 10 >= 0) {
            battery -= durationInHrs * 10;
        } else {
            battery %= 10;
        }
    }

    public void charge() {
        battery += 5;
        if (battery > 100) {
            battery = 100;
        }
    }

    public int getBattery() {
        return battery;
    }

    public String getManufacturer() {
        return manufacturer;
    }
}