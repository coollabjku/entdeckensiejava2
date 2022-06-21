package Loesungen.Kapitel9_A4;

// Aufgabe 27
public class StopWatch {
    private long tStart;

    public void start() {
        tStart = System.currentTimeMillis();
    }

    public double elapsedTime() {
        long tNow = System.currentTimeMillis();
        return (tNow - tStart) / 1000.0;
    }
}