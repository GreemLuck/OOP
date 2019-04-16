package oop.demo.swing.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 * @author ingold
 */
public class MenuController extends AbstractController {

    private Model model;
    private JPopupMenu menu;

    public MenuController(Model model, View view) {
        this.model = model;
        view.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent event) {
                menu.show(event.getComponent(), event.getX() - 100, event.getY() - 20);
            }
        });
        menu = new JPopupMenu();
        menu.add(menuItem("Turn Left"));
        menu.add(menuItem("Turn Right"));
    }

    private JMenuItem menuItem(String label) {
        JMenuItem item = new JMenuItem(label);
        item.addActionListener(actionListener);
        return item;
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
