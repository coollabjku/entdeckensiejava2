package Aufgaben.Kapitel20;

import javax.swing.JFrame;

/**
 * This application provides a graphical user interface (GUI) to a
 * {@link BasicCounter} object. The {@link BasicCounter} can be operated by
 * clicking on a "counter"-button and a "reset"-button.
 * 
 * @author ESOP Team 2012
 * 
 */
public class MainBasic {
    public static void main(String[] args) {
        BasicCounter basic = new BasicCounter();
        CounterView view = new CounterView(basic);
        JFrame f = new JFrame("Counter");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(view);
        f.pack();
        f.setResizable(false);
        f.setVisible(true);
    }
}
