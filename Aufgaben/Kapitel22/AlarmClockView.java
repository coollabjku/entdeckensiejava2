package Aufgaben.Kapitel22;

import Aufgaben.Kapitel21.ChainedCounter;
import Aufgaben.Kapitel21.ClockView;

// Aufgabe 55
public class AlarmClockView /* extends ClockView */ {
    // TODO: Declare necessary variables and constructors

    // @Override
    protected void updateClock() {
        // TODO: Your code here
        // call trigger() if the alarm should play
    }

    // extract the behavior on triggering an alarm into its own method
    protected void trigger() {
        // add filepath to the audio file
        new AudioStreamPlayer().play("B5\\A7\\alarm.wav");
    }
}
