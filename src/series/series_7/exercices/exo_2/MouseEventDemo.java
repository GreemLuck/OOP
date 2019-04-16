package series.series_7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseEventDemo extends JPanel{
    JFrame f = new JFrame("Main");
    JTextArea textArea = new JTextArea(10,30);
    JScrollPane scrollPane = new JScrollPane(textArea);

    MouseEventDemo(){
        defineFrame();
    }

    void content(){
        JPanel top = new JPanel();
        JPanel bot = new JPanel();

        scrollPane.setName("ScrollPane");
        textArea.setName("TextArea");
        scrollPane.addMouseListener(new CustomMouseListener());
        textArea.setEditable(false);

        bot.add(scrollPane);
        bot.setName("BottomPanel");
        bot.addMouseListener(new CustomMouseListener());

        top.setName("Top Panel");
        top.addMouseListener(new CustomMouseListener());

        top.setBackground(Color.blue);
        bot.setBackground(Color.white);

        f.setName("MainFrame");
        f.addMouseListener(new CustomMouseListener());

        f.add(top);
        f.add(bot);
    }

    void defineFrame(){
        content();
        f.setLayout(new BoxLayout(f.getContentPane(), BoxLayout.Y_AXIS));
        f.setSize(400,400);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new MouseEventDemo();
    }

    private class CustomMouseListener implements MouseListener{ ;

        @Override
        public void mouseReleased(MouseEvent e) {
            textArea.append("Mouse released in " + e.getComponent().getName() + "\n");
    }

        @Override
        public void mouseExited(MouseEvent e) {
            textArea.append("Mouse exited in " + e.getComponent().getName() + "\n");

        }

        @Override
        public void mousePressed(MouseEvent e) {
            textArea.append("Mouse pressed in " + e.getComponent().getName() + "\n");

        }

        @Override
        public void mouseClicked(MouseEvent e) {
            textArea.append("Mouse clicked in " + e.getComponent().getName() + "\n");

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            textArea.append("Mouse entered in " + e.getComponent().getName() + "\n");

        }
    }
}
