package project.Model;


import project.View.Sprite;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Enemy extends Sprite implements Shooter {

    final static public ImageIcon ENEMY_ICON = new ImageIcon(Enemy.class.getResource("/alien.png"));
    final static String INITIAL_DIRECTION = "RIGHT";

    static private int count;
    static private int fireProb = 5;
    static private Random random = new Random();
    static private int descentSpeed = 1;

    private int hitPoints = 1;
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
    public void move(String direction) {
        int y = getY();
        int x = getX();
        switch (direction){
            case "DOWN" :
                setY(y + descentSpeed);
                break;
            case "LEFT":
                setX(x - descentSpeed);
                break;
            case "RIGHT":
                setX(x + descentSpeed);
                break;
        }
    }

    @Override
    public void update() {
        ;
    }

    public void gotHit(){
        hitPoints--;
        if(hitPoints <= 0){
            dead = true;
        }
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
        shot.setDirection("DOWN");

        return shot;
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
