package Loesungen.Kapitel27;

// Aufgabe 64
public class Tablet extends Computer implements Chargeable {
    private int battery;
    private boolean mobileInternet;

    public Tablet(String ipAddress, int clockSpeed, int memory, boolean mobileInternet) {
        super(ipAddress, clockSpeed, memory);
        this.battery = 0;
        this.mobileInternet = mobileInternet;
    }

    public boolean isMobileInternet() {
        return mobileInternet;
    }

    public void setMobileInternet(boolean mobileInternet) {
        this.mobileInternet = mobileInternet;
    }

    @Override
    public void fullyCharge() {
        battery = 90;
    }

    @Override
    public void charge(int percentage) {
        battery = percentage / 2;
    }

    @Override
    public int getBatteryLevel() {
        return battery;
    }
}