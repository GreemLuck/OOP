package oop.demo.swing.mvc;

import oop.demo.geom.Shape;
import oop.lib.Display;

/**
 * @author ingold
 */
public class View extends Display implements Observer {

    private Model model;
    
    public View(Model model) {
        super(400, 400);
        setOrigin(200, 200);
        setScale(1, true);
        this.model = model;
        model.addObserver(this);
    }
    
    @Override
    public void paint(Display display) {
        for (Shape shp : model.getShapes()) {
            shp.paint(display);
        }
    }

    @Override
    public void update() {
        repaint();
    }

}
