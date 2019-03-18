package project;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class Enemy extends Actor {
    static public int count;
    static Image img = new ImageIcon(Enemy.class.getResource("/enemy.png")).getImage();

    public Enemy (int x, int y){
        super(img, x, y);
    }

    public int getCount(){
        return count;
    }

    public Enemy clone(){
        return new Enemy(getX(), getY());
    }
}
