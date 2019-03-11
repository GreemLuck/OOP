package project;
import java.awt.*;

public class Enemy extends Actor {
    static public int count;

    public Enemy (Image img, int x, int y){
        super(img, x, y);
    }

    public int getCount(){
        return count;
    }
}
