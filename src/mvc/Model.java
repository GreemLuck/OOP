package oop.demo.swing.mvc;

import java.awt.Color;
import oop.demo.geom.Point;
import oop.demo.geom.Shape;
import oop.demo.geom.Square;

/**
 * @author ingold
 */
public class Model extends Observable {
    
    private Shape shape = new Square(100, Color.RED, new Point(0, 0));
    
    public void rotateLeft() {
        shape.rotate(15);
        notifyObservers();
    }
    
    public void rotateRight() {
        shape.rotate(-15);
        notifyObservers();
    }
    
    public Shape[] getShapes() {
        return new Shape[]{shape};
    }

}
