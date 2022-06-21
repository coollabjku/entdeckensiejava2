package Aufgaben.Kapitel20;

import javax.swing.*;
import java.awt.*;

/**
 * Serves to visual display a {@link BasicCounter} object in a the graphical
 * user interface.
 * 
 * Extends {@link JPanel}, hosts a {@link BasicCounter} object.
 * 
 * @author ESOP Team 2012
 * 
 */
public class CounterPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private BasicCounter counter;
    private Font font;

    /**
     * Creates a new CounterPanel to serve as visual host for the specified
     * BasicCounter.
     * 
     * @param counter the counter
     */
    public CounterPanel(BasicCounter counter) {
        this.counter = counter;
        setPreferredSize(new Dimension(190, 130));
        setBackground(Color.BLACK);
        setOpaque(true);
        font = new Font("Monospaced", Font.BOLD, 140);
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.setFont(font);
        int val = counter.getValue();
        if (val < 10)
            g.drawString("0" + val, 10, 110);
        else
            g.drawString("" + val, 10, 110);
    }
}
