package model.shot;


import javax.swing.*;

public class Bomb extends Shot {

    //////////////////////////////////////////////////////////////////////
    // CONSTRUCTOR
    //////////////////////////////////////////////////////////////////////
    public Bomb(int x, int y, String direction){
        super(new ImageIcon(Bomb.class.getResource("/bomb.png")).getImage(),
                x, y, direction, 1);
    }

    //////////////////////////////////////////////////////////////////////
    // PUBLIC
    //////////////////////////////////////////////////////////////////////
    @Override
    public void move() {
        int y_VELOCITY = 2;
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
