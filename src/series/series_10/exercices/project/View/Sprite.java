package project.View;

import oop.lib.Paintable;
import oop.lib.Painting;
import project.Model.Direction;
import project.Model.Movable;

import java.awt.*;

public abstract class Sprite implements Paintable, Movable {

    private int x;
    private int y;
    private int speed;
    private Direction direction;
    private Image img;

    //////////////////////////////////////////////////////////////////////
    // CONSTRUCTOR
    //////////////////////////////////////////////////////////////////////

    public Sprite(Image img, int x, int y){
        this.x = x;
        this.y = y;
        this.img = img.getScaledInstance(50,50,1);
    }

    abstract public void update();

    protected boolean checkCollision(Sprite sprite){
        return getBoundingBox().intersects(sprite.getBoundingBox());
    }

    //////////////////////////////////////////////////////////////////////
    // PAINTABLE
    //////////////////////////////////////////////////////////////////////

    @Override
    public void paint(Painting painting){
        painting.drawImage(img, x, y);
    }

    //////////////////////////////////////////////////////////////////////
    // MOVABLE
    //////////////////////////////////////////////////////////////////////

    public void move(Direction direction){
        int x = getX();
        int y = getY();
        switch (direction){
            case LEFT:
                x -= speed;
                break;
            case RIGHT:
                x += speed;
                break;
            case DOWN:
                y += speed;
                break;
            case UP:
                y -= speed;
                break;
        }
    }

    //////////////////////////////////////////////////////////////////////
    // GETTERS & SETTERS
    //////////////////////////////////////////////////////////////////////

    public Rectangle getBoundingBox(){
        return new Rectangle(getX(),getY(),getWidth(),getHeight());
    }

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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
