package project.Model;

import java.awt.*;
import project.View.Sprite;

import javax.swing.*;

public class Shot extends Sprite {

    final static public ImageIcon SHOT_ICON = new ImageIcon(Shot.class.getResource("/shot.png"));

    static private int speed = 10;

    //////////////////////////////////////////////////////////////////////
    // CONSTRUCTOR
    //////////////////////////////////////////////////////////////////////

    public Shot( int x, int y){
        super(SHOT_ICON.getImage(), x, y);
    }

    @Override
    public void move(Direction direction) {
        int y = getY();
        switch (direction){
            case UP :
                setY(y - speed);
                break;
            case DOWN:
                setY(y + speed);
                break;
        }
    }

    @Override
    public void update() {
        move(getDirection());
    }

    //////////////////////////////////////////////////////////////////////
    // GETTERS AND SETTERS
    //////////////////////////////////////////////////////////////////////
}
