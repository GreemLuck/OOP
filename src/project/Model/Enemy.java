package project.Model;


import project.View.Sprite;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Enemy extends Sprite implements Shooter, Hittable {

    final static public ImageIcon ENEMY_ICON = new ImageIcon(Enemy.class.getResource("/alien.png"));
    final static Direction INITIAL_DIRECTION = Direction.RIGHT;

    static private int count;
    static private int fireProb = 5;
    static private Random random = new Random();
    static private int descentSpeed = 1;

    private int hitPoints = 2;
    private boolean dead = false;

    //////////////////////////////////////////////////////////////////////
    // CONSTRUCTOR
    //////////////////////////////////////////////////////////////////////

    public Enemy (int x, int y){
        super(ENEMY_ICON.getImage(), x, y);
        setDirection(INITIAL_DIRECTION);
        setSpeed(descentSpeed);
    }

    public Enemy clone(){
        return new Enemy(getX(), getY());
    }

    @Override
    public void move(Direction direction) {
        int y = getY();
        int x = getX();
        switch (direction){
            case DOWN:
                setY(y + descentSpeed);
                break;
            case LEFT:
                setX(x - descentSpeed);
                break;
            case RIGHT:
                setX(x + descentSpeed);
                break;
        }
    }

    @Override
    public void update() {
        ;
    }

    public boolean isDead(){
        return dead;
    }

    //////////////////////////////////////////////////////////////////////
    // SHOOTER
    //////////////////////////////////////////////////////////////////////\

    @Override
    public Shot shoot() {
        if( random.nextInt(1000) >= fireProb){
            return null;
        }
        int x = getX() - Shot.SHOT_ICON.getIconWidth();
        int y = getY();
        Shot shot = new Shot(x, y);
        shot.setDirection(Direction.DOWN);

        return shot;
    }

    //////////////////////////////////////////////////////////////////////
    // Hittable
    //////////////////////////////////////////////////////////////////////\

    @Override
    public boolean getHit(Shot shot) {
        if(this.checkCollision(shot)){
            hitPoints--;
            if(hitPoints <= 0){
                die();
            }
            return true;
        }
        return false;
    }

    @Override
    public void die() {
        dead = true;
    }

    //////////////////////////////////////////////////////////////////////
    // GETTERS AND SETTERS
    //////////////////////////////////////////////////////////////////////

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Enemy.count = count;
    }

    public static int getFireProb() {
        return fireProb;
    }

    public static void setFireProb(int fireProb) {
        Enemy.fireProb = fireProb;
    }

    public static int getDescentSpeed() {
        return descentSpeed;
    }

    public static void setDescentSpeed(int descentSpeed) {
        Enemy.descentSpeed = descentSpeed;
    }
}
