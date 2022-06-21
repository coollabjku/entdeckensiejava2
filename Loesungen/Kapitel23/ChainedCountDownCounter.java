package Loesungen.Kapitel23;

import Loesungen.Kapitel21.ChainedCounter;

// Aufgabe 56
public class ChainedCountDownCounter extends ChainedCounter {
    public ChainedCountDownCounter(int init, int modulo, ChainedCounter next) {
        super(init, modulo, next);
    }

    @Override
    public void count() {
        if (this.value > 0) {
            this.value--;
        } else {
            if (next != null)
                next.count();
        }
    }
}
