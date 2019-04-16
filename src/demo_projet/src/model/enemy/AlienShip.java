package model.enemy;


import model.shot.Shot;
import javax.swing.*;
import java.util.LinkedList;
import java.util.List;

public class AlienShip extends Enemy {
    /**
     * Initial coordinates for the alien
     */
    private final static int ALIEN_INIT_X = 150;
    private final static int ALIEN_INIT_Y = 5;
    private final static double FIRE_CHANCE = 0.005;

    //////////////////////////////////////////////////////////////////////
    // CONSTRUCTOR
    //////////////////////////////////////////////////////////////////////
    public AlienShip(int xOffset, int yOffset) {
        super(new ImageIcon(AlienShip.class.getResource("/alien.png")).getImage(),
                ALIEN_INIT_X + xOffset,
                ALIEN_INIT_Y + yOffset,
                15,
                1);
    }

    //////////////////////////////////////////////////////////////////////
    // ATTACKER
    //////////////////////////////////////////////////////////////////////
    @Override
    public List<Shot> attack() { return null; }
}
