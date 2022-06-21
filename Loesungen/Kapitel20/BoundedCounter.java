package Loesungen.Kapitel20;

// Aufgabe 53
public class BoundedCounter extends SimpleCounter {
    protected int modulo;

    public BoundedCounter(int init, int modulo) {
        super(init);
        this.modulo = modulo;
    }

    @Override
    public void count() {
        this.value++;
        this.value %= modulo;
    }
}
