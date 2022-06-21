package Aufgaben.Kapitel23;

import javax.swing.*;

import Aufgaben.Kapitel21.ChainedCounter;
import Aufgaben.Kapitel22.AlarmClockView;

/**
 * A part of the graphical user interface used by the
 * {@link MainCountDownAlarmClock} application.
 * 
 * Extends {@link JPanel}, hosts and manages three {@link ChainedCounter}
 * objects.
 * 
 * @author ESOP Team 2012
 * 
 */
public class CountDownAlarmClockView extends AlarmClockView {
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new view for the three specified {@link ChainedCounter} objects.
     * 
     * This constructor sets up all the necessary GUI elements needed to display a
     * digital count down alarm clock.
     * 
     * @param hoursCounter the counter representing the hours
     * @param minsCounter  the counter representing the minutes
     * @param secsCounter  the counter representing the seconds
     * @param alarmH       the value of the hoursCounter when the alarm should sound
     *                     (is normally 0)
     * @param alarmM       the value of the minsCounter when the alarm should sound
     *                     (is normally 0)
     * @param alarmS       the value of the secsCounter when the alarm should sound
     *                     (is normally 0)
     */
    public CountDownAlarmClockView(ChainedCounter hoursCounter, ChainedCounter minsCounter, ChainedCounter secsCounter,
            int alarmH, int alarmM, int alarmS) {
        // super(hoursCounter, minsCounter, secsCounter, alarmH, alarmM, alarmS);
    }

    // override the behavior that happens upon triggering an alarm
    @Override
    public void trigger() {
        // TODO: Your code here
    }
}
