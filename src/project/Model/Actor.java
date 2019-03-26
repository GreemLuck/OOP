package project.Model;

import project.Controller.Killable;

import java.awt.*;

public abstract class Actor extends Sprite implements Killable {

    public Actor(Image img, int x, int y) {
        super(img, x, y);
    }

    public void die(){}
}
