package view;

import oop.lib.Painting;
import view.Representation;

import java.awt.*;

public abstract class Sprite implements Representation {

    /**
     * x-coordinate of the whole sprite
     */
    private int x;
    /**
     * y-coordinate of the whole sprite
     */
    private int y;

    /**
     * Image representing the sprite
     */
    private final Image img;

    //////////////////////////////////////////////////////////////////////
    // CONSTRUCTOR
    //////////////////////////////////////////////////////////////////////
    public Sprite(Image img, int x, int y) {
        this.x = x;
        this.y = y;
        this.img = img;
    }

    //////////////////////////////////////////////////////////////////////
    // PUBLIC
    //////////////////////////////////////////////////////////////////////
    @Override
    public void paint(Painting painting){
        painting.drawImage(img, x, y);
    }

    @Override
    public Rectangle getBoundingBox() {
        return new Rectangle(x, y, img.getWidth(null), img.getHeight(null));
    }

    public boolean checkCollision(Sprite sprite){
        return sprite.getBoundingBox().intersects(this.getBoundingBox());
    }

    //////////////////////////////////////////////////////////////////////
    // GETTERS & SETTERS
    //////////////////////////////////////////////////////////////////////
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getWidth(){
        return img.getWidth(null);
    }

    public int getHeight(){
        return img.getHeight(null);
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
