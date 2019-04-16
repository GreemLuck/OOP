package week_6.exercise;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class ButtonCreator implements Runnable {

    private JFrame frame1 = new JFrame();
    private JFrame frame2 = new JFrame();
    private JPanel panel2 = new JPanel();
    private JTextField text = new JTextField(2);
    private Color[] colors = {new Color(255,255,0),
            new Color(120,120,120),
            new Color(255,0,0),
            new Color(0,255,0),
            new Color(0,255,255),
            new Color(255,0,255),
            new Color(255,100,0),
            new Color(100,50,0),
            new Color(100,0,100),
            new Color(0,0,0),
            new Color(255,255,255),
        };
    private String[] colorNames = {"Yellow", "Grey", "Red", "Green", "Cyan", "Pink", "Orange", "Brown", "Purple", "Black", "White"};

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new ButtonCreator());
    }

    @Override
    public void run() {
        defineFrame();
    }

    private void defineFrame() {
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.add(content());
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }

    private JPanel content() {
        JLabel label = new JLabel("Amount of Buttons");
        JButton button = new JButton("OK");
        button.addActionListener(new ChangeListener());
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));
        panel.add(label);
        panel.add(text);
        panel.add(button);
        return panel;
    }

    private JPanel content2(int n) {
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));
        Random rand = new Random();
        for(int i=0; i<n; ++i) {
            int random = rand.nextInt(colors.length);
            panel2.add(new ColorButton(colors[random], colorNames[random]));
        }
        return panel2;
    }

    private class ChangeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame1.setVisible(false);
            frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame2.add(content2(Integer.parseInt(text.getText())));
            frame2.pack();
            frame2.setLocationRelativeTo(null);
            frame2.setVisible(true);
        }
    }

    private class ColorButton extends JButton {

        public ColorButton(Color color, String name) {
            super(name);
            setPreferredSize(new Dimension(100, 25));
            addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    panel2.setBackground(color);
                }
            });
        }

    }

}
