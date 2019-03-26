package project.View;

import project.Model.Shot;

import javax.swing.*;
import java.awt.*;

public class ShotPlayer extends Shot {

    static Image img = new ImageIcon(Shot.class.getResource("/shot_player.png")).getImage();

    public ShotPlayer(int x, int y){
        super(img, x, y);
    }
}
