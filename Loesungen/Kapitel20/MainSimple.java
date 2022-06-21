package Loesungen.Kapitel20;

import javax.swing.JFrame;

/**
 * This application provides a graphical user interface (GUI) to a
 * {@link BasicCounter} object. The {@link BasicCounter} can be operated by
 * clicking on a "counter"-button and a "reset"-button.
 * 
 * @author ESOP Team 2012
 * 
 */
public class MainSimple {
    public static void main(String[] args) {
        SimpleCounter simple = new SimpleCounter(95);
        CounterView view = new CounterView(simple);
        JFrame f = new JFrame("Counter");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(view);
        f.pack();
        f.setResizable(false);
        f.setVisible(true);
    }
}
