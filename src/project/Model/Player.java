package project.Model;

import project.Controller.SpaceInvaders;
import project.View.Board;
import project.View.Sprite;

import javax.swing.*;


public class Player extends Sprite implements Shooter, Hittable{

    final static public ImageIcon PLAYER_ICON = new ImageIcon(Player.class.getResource("/player.png"));

    private int score;
    private int shotSpeed = 500;
    private long lastShot;
    private boolean dead = false;
    private int hitPoints = 100;

    //////////////////////////////////////////////////////////////////////
    // CONSTRUCTOR
    //////////////////////////////////////////////////////////////////////

    public Player(int x, int y){
        super(PLAYER_ICON.getImage(), x, y);
        lastShot = System.currentTimeMillis();
        setSpeed(4);
    }

    @Override
    public void move(Direction direction) {
        int x = getX();
        switch (direction){
            case LEFT:
                if(x >= 0) setX(x - getSpeed());
                break;
            case RIGHT:
                if(x <= SpaceInvaders.BOARD_WIDTH - getWidth())setX(x + getSpeed());
                break;
        }
    }

    @Override
    public void update() {
        ;
    }

    //////////////////////////////////////////////////////////////////////
    // SHOOTER
    //////////////////////////////////////////////////////////////////////\

    public Shot shoot (){
        int x = getX() - Shot.SHOT_ICON.getIconWidth();
        int y = getY();
        Shot shot = new Shot(x, y);
        shot.setDirection(Direction.UP);

        return shot;
    }

    //////////////////////////////////////////////////////////////////////
    // Hittable
    //////////////////////////////////////////////////////////////////////\

    @Override
    public boolean getHit(Shot shot) {
        if(this.checkCollision(shot)){
            hitPoints--;
            if(hitPoints <= 0){
                die();
            }
            return true;
        }
        return false;
    }

    @Override
    public void die() {
        dead = true;
    }

    //////////////////////////////////////////////////////////////////////
    // GETTERS & SETTERS
    //////////////////////////////////////////////////////////////////////\

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getShotSpeed() {
        return shotSpeed;
    }

    public void setShotSpeed(int shotSpeed) {
        this.shotSpeed = shotSpeed;
    }

    public long getLastShot() {
        return lastShot;
    }

    public void setLastShot(long lastShot) {
        this.lastShot = lastShot;
    }
}
