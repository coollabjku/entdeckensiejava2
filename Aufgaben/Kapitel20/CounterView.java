package Aufgaben.Kapitel20;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A part of the graphical user interface used to interact with a
 * {@link BasicCounter}. Used by the {@link MainBasic} application.
 * 
 * Extends {@link JPanel}, hosts and manages one {@link BasicCounter} object and
 * provides buttons for user interaction.
 * 
 * @author ESOP Team 2012
 * 
 */
public class CounterView extends JPanel {
    private static final long serialVersionUID = 1L;
    private BasicCounter counter;
    private CounterPanel panel;

    /**
     * Constructs a new view for the specified {@link BasicCounter} object.
     * 
     * This constructor sets up all the necessary GUI elements needed to manipulate
     * the {@link BasicCounter} (a "count"-button and a "reset"-button).
     * 
     * @param counter the {@link BasicCounter} that should be displayed in the view.
     */
    public CounterView(BasicCounter counter) {
        this.counter = counter;
        panel = new CounterPanel(counter);
        JButton countButton = new JButton("Count");
        JButton resetButton = new JButton("Reset");
        countButton.addActionListener(new CountListener());
        resetButton.addActionListener(new ResetListener());
        setLayout(new BorderLayout());
        add(panel, BorderLayout.NORTH);
        add(countButton, BorderLayout.WEST);
        add(resetButton, BorderLayout.EAST);
        setOpaque(true);
    }

    private class CountListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            counter.count();
            panel.repaint();
        }
    }

    private class ResetListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            counter.reset();
            panel.repaint();
        }
    }
}