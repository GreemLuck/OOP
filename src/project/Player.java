package project;
import javax.swing.*;
import java.awt.*;


public class Player extends Actor{

    public int score;

    static Image player_img;
    static int starting_x;
    static int staarting_y;

    public Player(){
        super(player_img, starting_x, staarting_y);
    }

    public int getScore(){
        return score;
    }
}
