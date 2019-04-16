package model.shot;


import javax.swing.*;

public class Bullet extends Shot {

    //////////////////////////////////////////////////////////////////////
    // CONSTRUCTOR
    //////////////////////////////////////////////////////////////////////
    public Bullet(int x, int y, String direction){
        super(new ImageIcon(Bullet.class.getResource("/shot.png")).getImage(),
                x, y, direction, 1);
    }

    //////////////////////////////////////////////////////////////////////
    // PUBLIC
    //////////////////////////////////////////////////////////////////////
    @Override
    public void move() {
        int y_VELOCITY = 5;
        int y = getY();
        switch (direction){
            case "UP":
                setY(y - y_VELOCITY);
                break;
            case "DOWN":
                setY(y + y_VELOCITY);
                break;
        }
    }
}
