package project.Model;

import oop.lib.Paintable;
import oop.lib.Painting;

import java.util.Collections;
import java.util.ListIterator;

public class Group<T extends  Enemy> extends MyLinkedList<Enemy> implements Movable, Shooter, Hittable, Paintable {

    private static Direction direction = Direction.LEFT;
    private static boolean dead = false;

    //////////////////////////////////////////////////////////////////////
    // CONSTRUCTOR
    //////////////////////////////////////////////////////////////////////

    public Group(){
        super();
    }

    public void detectAndRemoveDeadEnemies(){
        MyLinkedList<Enemy> enemiesToRemove = new MyLinkedList<>();
        for(Enemy e: this){
            if(e.isDead()){
                enemiesToRemove.add(e);
            }
        }

        for(Enemy e: enemiesToRemove){
            remove(e);
        }
    }

    //////////////////////////////////////////////////////////////////////
    // PAINTABLE
    //////////////////////////////////////////////////////////////////////

    @Override
    public void paint(Painting painting) {

    }

    //////////////////////////////////////////////////////////////////////
    // HITTABLE
    //////////////////////////////////////////////////////////////////////

    @Override
    public boolean getHit(Shot shot) {
        for(Enemy e: this){
            if(e.getHit(shot)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void die() {
        dead = true;
    }

    //////////////////////////////////////////////////////////////////////
    // MOVEABLE
    //////////////////////////////////////////////////////////////////////

    @Override
    public void move(Direction direction) {
        for(Enemy e: this){
            e.move(direction);
        }
    }

    //////////////////////////////////////////////////////////////////////
    // SHOOTER
    //////////////////////////////////////////////////////////////////////

    @Override
    public Shot shoot() {
        return null;
    }

    //////////////////////////////////////////////////////////////////////
    // GETTERS AND SETTERS
    //////////////////////////////////////////////////////////////////////

    public int getMax(){
        MyLinkedList<Integer> xCoordinates = new MyLinkedList<>();
        for(Enemy e : this){
            xCoordinates.add(e.getX());
        }
        return Collections.max(xCoordinates);
    }

    public int getMin(){
        MyLinkedList<Integer> xCoordinates = new MyLinkedList<>();
        for(Enemy e: this){
            xCoordinates.add(e.getX());
        }
        return Collections.min(xCoordinates);
    }

    public  int getWidth(){
        if(!this.isEmpty()){
            return this.get(0).getWidth();
        }
        return 0;
    }

    public  int getHeight(){
        if(!this.isEmpty()){
            return this.get(0).getHeight();
        }
        return 0;
    }

    public static Direction getDirection() {
        return direction;
    }

    public static void setDirection(Direction direction) {
        Group.direction = direction;
    }
}
