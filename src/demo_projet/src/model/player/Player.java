package model.player;


import model.Attacker;
import model.Hittable;
import model.Moveable;
import model.shot.Shot;
import view.Sprite;

import javax.swing.*;
import java.util.List;

public class Player extends Sprite implements Hittable, Moveable, Attacker {

    private int healthPoints = 5;
    private long lastShot;

    //////////////////////////////////////////////////////////////////////
    // CONSTRUCTOR
    //////////////////////////////////////////////////////////////////////
    public Player(int x, int y) {
        super(new ImageIcon(Player.class.getResource("/player.png")).getImage(), x, y);
    }

    //////////////////////////////////////////////////////////////////////
    // HITTABLE
    //////////////////////////////////////////////////////////////////////
    @Override
    public void gotHit(Shot shot) {
        healthPoints-= shot.damage;
    }

    @Override
    public boolean isDead() {
        return healthPoints <= 0;
    }

    //////////////////////////////////////////////////////////////////////
    // MOVABLE
    //////////////////////////////////////////////////////////////////////
    @Override
    public void move(String direction) {
        int x = getX();
        switch (direction) {
            case "LEFT":
                setX(x - 10);
                break;
            case "RIGHT":
                setX(x + 10);
                break;
            default:
                throw new RuntimeException("Invalid direction for moving received: " + direction.toString());
        }
    }

    //////////////////////////////////////////////////////////////////////
    // ATTACKER
    //////////////////////////////////////////////////////////////////////
    @Override
    public List<Shot> attack() {
        return null;
    }
}