package project;

import javax.swing.*;
import java.awt.*;

public class ShotEnemy extends Shot {

    static Image img = new ImageIcon(ShotEnemy.class.getResource("/shot_enemy.png")).getImage();

    public ShotEnemy(int x, int y){
        super(img, x, y);
    }
}
