package project.Model;

import project.View.Sprite;

public class ShotList extends SpriteList {

    public ShotList(){
        super();
    }

    public void addShot(Shot shot){
        add(shot);
    }
}
