package project.View;
import project.Model.Actor;

import javax.swing.*;
import java.awt.*;


public class Player extends Actor {

    public int score;

    static Image player_img = new ImageIcon(Player.class.getResource("/player.png")).getImage();
    static int starting_x = 150;
    static int starting_y = 200;

    public Player(){
        super(player_img, starting_x, starting_y);
    }

    public int getScore(){
        return score;
    }
}
