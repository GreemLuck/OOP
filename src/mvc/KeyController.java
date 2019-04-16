package oop.demo.swing.mvc;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 * @author ingold
 */
public class KeyController extends AbstractController {

    private Model model;
    private JPanel panel = new JPanel();

    public KeyController(Model model, View view) {
        this.model = model;
        view.addKeyListener(keyListener);
        view.requestFocusInWindow();
    }

    public JPanel getPanel() {
        return new JPanel();
    }

    public KeyListener keyListener = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                model.rotateLeft();
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                model.rotateRight();
            }
        }

    };

}
