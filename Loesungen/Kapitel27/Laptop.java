package Loesungen.Kapitel27;

//Aufgabe 62
// public class Laptop implements Chargeable {
//     private int batteryLevel;
//     private int screenSize;

//     public Laptop(int screenSize) {
//         this.batteryLevel = 0;
//         this.screenSize = screenSize;
//     }

//     public int getScreenSize() {
//         return screenSize;
//     }

//     @Override
//     public void fullyCharge() {
//         batteryLevel = 100;
//     }

//     @Override
//     public void charge(int percentage) {
//         batteryLevel = percentage;
//     }

//     @Override
//     public int getBatteryLevel() {
//         return batteryLevel;
//     }

//     public static void main(String[] args) {
//         Laptop lt = new Laptop(14);
//         lt.charge(45);
//         System.out.println(lt.getBatteryLevel());
//         lt.fullyCharge();
//         System.out.println(lt.getBatteryLevel());
//     }
// }

// Aufgabe 63
public class Laptop extends Computer implements Chargeable {
    private int batteryLevel;
    private int screenSize;

    public Laptop(String ipAddress, int clockSpeed, int memory, int screenSize) {
        super(ipAddress, clockSpeed, memory);
        this.batteryLevel = 0;
        this.screenSize = screenSize;
    }

    public int getScreenSize() {
        return screenSize;
    }

    @Override
    public void fullyCharge() {
        batteryLevel = 100;
    }

    @Override
    public void charge(int percentage) {
        batteryLevel = percentage;
    }

    @Override
    public int getBatteryLevel() {
        return batteryLevel;
    }
}