package Loesungen.Kapitel20;

// Aufgabe 52
public class BasicCounter {
    protected int value;

    public BasicCounter() {
        value = 0;
    }

    public void count() {
        value++;
    }

    public void reset() {
        value = 0;
    }

    public int getValue() {
        return value;
    }
}
