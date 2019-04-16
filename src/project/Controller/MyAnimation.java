package project.Controller;

import oop.lib.Display;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyAnimation implements Runnable, ActionListener
{
    private JFrame frame;
    private Timer timer;
    private boolean autoplay;
    private Display display;

    @Override
    public void run()
    {
        frame = new JFrame("My frame");
        frame.setDefaultCloseOperation(3);

        timer = new Timer (20, this);

        init();

        frame.add(display);
        frame.pack();

        frame.setLocationRelativeTo(null);
        display.requestFocus();
        frame.setVisible(true);

        timer.start();
        if(autoplay) timer.setInitialDelay(20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        step();
        display.repaint();
    }

    protected void init()
    {
        ;
    }

    protected void step()
    {
        ;
    }

    protected synchronized void launch(boolean automatic)
    {
        autoplay = automatic;
        SwingUtilities.invokeLater(this);
    }

    public void setDisplay(Display display) {
        this.display = display;
    }
}
