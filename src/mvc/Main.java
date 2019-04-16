package oop.demo.swing.mvc;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * @author ingold
 */
public class Main extends JFrame implements Runnable {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Main());
    }
    
    @Override
    public void run() {
        Model model = new Model();
        View view = new View(model);
        AbstractController controller = new ButtonController(model, view);
        initializeFrame(view, controller);
    }    
    
    public void initializeFrame(View view, AbstractController controller) {
        setTitle("Model-View-Controller Example");        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(view);
        pack();
        view.requestFocusInWindow();
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
