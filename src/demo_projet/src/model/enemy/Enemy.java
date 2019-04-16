package model.enemy;


import model.Attacker;
import model.Hittable;
import model.Moveable;
import model.shot.Shot;
import view.Sprite;

import java.awt.*;
import java.util.List;
import java.util.Random;

public abstract class Enemy extends Sprite implements Attacker, Hittable, Moveable {

    private final int descentStep;
    private int healthPoints;
    static final Random random = new Random();

    //////////////////////////////////////////////////////////////////////
    // CONSTRUCTOR
    //////////////////////////////////////////////////////////////////////
    Enemy(Image alienImg, int x, int y, int descentStep, int healthPoints) {
        super(alienImg, x, y);
        setX(x);
        setY(y);
        this.descentStep = descentStep;
        this.healthPoints = healthPoints;
    }

    //////////////////////////////////////////////////////////////////////
    // HITTABLE
    //////////////////////////////////////////////////////////////////////
    @Override
    public void gotHit(Shot shot) {
        healthPoints -= shot.damage;
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
        int y = getY();
        switch (direction) {
            case "LEFT":
                setX(x--);
                break;
            case "RIGHT":
                setX(x++);
                break;
            case "DOWN":
                setY(y + descentStep);
                break;
            default:
                throw new RuntimeException("Invalid direction for moving received: " + direction.toString());
        }
    }

    //////////////////////////////////////////////////////////////////////
    // ATTACKER
    //////////////////////////////////////////////////////////////////////
    @Override
    public abstract List<Shot> attack();

}
