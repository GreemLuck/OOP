package project.Model;


import project.View.Sprite;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Enemy extends Sprite implements Shooter {

    static private int count;
    static private int fireProb = 5;
    static private Random random = new Random();

    static Image img = new ImageIcon(Enemy.class.getResource("/alien.png")).getImage();

    //////////////////////////////////////////////////////////////////////
    // CONSTRUCTOR
    //////////////////////////////////////////////////////////////////////

    public Enemy (int x, int y){
        super(img, x, y);
    }

    public Enemy clone(){
        return new Enemy(getX(), getY());
    }

    @Override
    public void move(String direction) {
        ;
    }

    @Override
    public void update() {
        ;
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
}
