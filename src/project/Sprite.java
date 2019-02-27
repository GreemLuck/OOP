package project;

import oop.lib.Paintable;
import oop.lib.Painting;

import java.awt.*;
import java.awt.image.ImageObserver;

public class Sprite implements Paintable {

    private int x;
    private int y;
    private Image img;

    //////////////////////////////////////////////////////////////////////
    // CONSTRUCTOR
    //////////////////////////////////////////////////////////////////////

    public Sprite(Image img, int x, int y){
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

    //////////////////////////////////////////////////////////////////////
    // GETTERS & SETTERS
    //////////////////////////////////////////////////////////////////////

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getWidth(){
        return img.getWidth(null);
    }

    public int getHeight(){
        return img.getHeight(null);
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }
}
