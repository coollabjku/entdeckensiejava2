package Aufgaben.Kapitel24_A5Z;

public class Mammal {
    private int size; // in cm
    private String sound;
    private String type;

    public Mammal(int size, String sound, String type) {
        this.size = size;
        this.sound = sound;
        this.type = type;
    }

    public void communicate() {
        System.out.println(type + " macht " + sound);
    }
}
