package project;

import java.awt.*;

abstract class Actor extends Sprite implements Killable{

    public Actor(Image img, int x, int y) {
        super(img, x, y);
    }

    public void die(){}
}
