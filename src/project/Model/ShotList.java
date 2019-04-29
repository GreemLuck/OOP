package project.Model;

import project.View.Sprite;

public class ShotList extends SpriteList {

    public ShotList(){
        super();
    }

    public void addShot(Shot shot){
        add(shot);
    }

    private int findIndex(Shot shot){
        for(int i = 0; i <= getSize(); i++){
            if(shot.equals((Shot)get(i))){
                return i;
            }
        }
        return -1;
    }

    public void remove(Shot shot){
        int index = findIndex(shot);
        if(index != -1) remove(index);
    }

    public Shot get(int pos){
        return (Shot) super.get(pos);
    }

    public void addAll(ShotList s){
        for(int i = 0; s.get(i) != null; i++){
            this.add(s.get(i));
        }
    }
}
