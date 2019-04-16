package series.series_6.exercices.exo3;

import javax.swing.*;

public class Main implements Runnable{

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Main());
    }

    private static void init() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(content());
        frame.pack();
        frame.setVisible(true);
    }

    private static JPanel content() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Hello World ! This is my first Swing application");
        JButton button = new JButton("Exit");
        button.addActionListener(e -> System.exit(0));
        panel.add(label);
        panel.add(button);
        return panel;
    }

    @Override
    public void run(){
        init();
    }
}
