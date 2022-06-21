package Loesungen.Kapitel21;

import Loesungen.Kapitel20.BoundedCounter;

// Aufgabe 54
public class ChainedCounter extends BoundedCounter {
    protected ChainedCounter next;

    public ChainedCounter(int init, int modulo, ChainedCounter next) {
        super(init, modulo);
        this.next = next;
    }

    @Override
    public void count() {
        this.value++;
        if (this.value >= this.modulo) {
            this.value %= this.modulo;
            if (next != null)
                next.count();
        }
    }
}
