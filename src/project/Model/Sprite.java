package project.Model;

import oop.lib.Paintable;
import oop.lib.Painting;
import project.Controller.Movable;

import java.awt.*;

public abstract class Sprite implements Paintable, Movable {

    private int x;
    private int y;
    private Image img;

    //////////////////////////////////////////////////////////////////////
    // CONSTRUCTOR
    //////////////////////////////////////////////////////////////////////

    public Sprite(Image img, int x, int y){
        this.x = x;
        this.y = y;
        this.img = img.getScaledInstance(50,50,1);
    }

    //////////////////////////////////////////////////////////////////////
    // PUBLIC
    //////////////////////////////////////////////////////////////////////
    @Override
    public void paint(Painting painting){
        painting.drawImage(img, x, y);
    }

    public void move(int dx, int dy){
        x += dx;
        y += dy;
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
