package Loesungen.Kapitel27;

// Aufgabe 63
public class Computer {
    private String ipAddress;
    private int clockSpeed;
    private int memory;

    public Computer(String ipAddress, int clockSpeed, int memory) {
        this.ipAddress = ipAddress;
        this.clockSpeed = clockSpeed;
        this.memory = memory;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getClockSpeed() {
        return clockSpeed;
    }

    public void setClockSpeed(int clockSpeed) {
        this.clockSpeed = clockSpeed;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }
}

/*
 * The edited Laptop class is found in Laptop.java at the bottom.
 */