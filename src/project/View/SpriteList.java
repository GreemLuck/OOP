package project.View;

import project.Model.Sprite;

import java.util.Arrays;

public class SpriteList {

    private final static int LST_SIZE = 10;
    private Sprite[] lst;
    private int size = 0;

    public SpriteList(){
        lst = new Sprite[LST_SIZE];
    }

    public void add(Sprite e){
        lst[size++] = e;
        if (size>=lst.length){
            lst = Arrays.copyOf(lst, lst.length+LST_SIZE);
        }
    }

    public void remove(int pos){
        Sprite[] newLst = new Sprite[lst.length];
        System.arraycopy(lst, 0, newLst, 0, pos);
        System.arraycopy(lst, pos+1, newLst, pos, lst.length-(pos+1));
        lst = newLst;
    }

    public int getSize(){
        return size;
    }

    public Sprite get(int pos){
        return lst[pos];
    }
}
