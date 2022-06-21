package Loesungen.Kapitel22;

import Loesungen.Kapitel21.ChainedCounter;
import Loesungen.Kapitel21.ClockView;

// Aufgabe 55
public class AlarmClockView extends ClockView {
    protected int tHours;
    protected int tMins;
    protected int tSecs;

    public AlarmClockView(ChainedCounter hoursCounter, ChainedCounter minsCounter, ChainedCounter secsCounter,
            int tHours, int tMins, int tSecs) {
        super(hoursCounter, minsCounter, secsCounter);

        this.tHours = tHours;
        this.tMins = tMins;
        this.tSecs = tSecs;
    }

    @Override
    protected void updateClock() {
        secsCounter.count();
        if (hoursCounter.getValue() == tHours && minsCounter.getValue() == tMins && secsCounter.getValue() == tSecs) {
            trigger();
        }
        repaint();
    }

    // extract the behavior on triggering an alarm into its own method
    protected void trigger() {
        new AudioStreamPlayer().play("B5\\A7\\alarm.wav");
    }
}
