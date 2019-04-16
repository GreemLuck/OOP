package oop.demo.swing.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author ingold
 */
public class ButtonController extends AbstractController {

    private Model model;
    private JPanel panel = new JPanel();

    public ButtonController(Model model, View view) {
        this.model = model;
        view.add(button("Turn Left"));
        view.add(button("Turn Right"));
    }

    public JPanel getPanel() {
        return panel;
    }

    private JButton button(String command) {
        JButton button = new JButton(command);
        button.addActionListener(actionListener);
        return button;
    }
    
    private ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Turn Left")) {
                model.rotateLeft();
            }
            if (e.getActionCommand().equals("Turn Right")) {
                model.rotateRight();
            }
        }
    };

}
