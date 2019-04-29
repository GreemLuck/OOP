package project.Model;

import oop.lib.Paintable;
import oop.lib.Painting;

public class Group<T extends  Enemy> extends EnemyList implements Movable, Shooter, Hittable, Paintable {

    private static Direction direction = Direction.LEFT;
    private static boolean dead = false;

    //////////////////////////////////////////////////////////////////////
    // CONSTRUCTOR
    //////////////////////////////////////////////////////////////////////

    public Group(){
        super();
    }

    public void detectAndRemoveDeadEnemies(){
        EnemyList enemiesToRemove = new EnemyList();
        Enemy e;
        for(int i = 0; (e = this.get(i)) != null; i++){
            if(e.isDead()){
                enemiesToRemove.add(e);
            }
        }

        for(int i = 0; enemiesToRemove.get(i) != null; i++){
            remove(enemiesToRemove.get(i));
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
        Enemy e;
        for(int i = 0; (e = this.get(i)) != null; i++){
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
        Enemy e;
        for(int i = 0; (e = this.get(i)) != null; i++){
            this.get(i).move(direction);
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
        IntegerList xCoordinates = new IntegerList();
        Enemy e;
        for(int i = 0; (e = this.get(i)) != null; i++){
            xCoordinates.add(e.getX());
        }
        return xCoordinates.getMax();
    }

    public int getMin(){
        IntegerList xCoordinates = new IntegerList();
        Enemy e;
        for(int i = 0; (e = this.get(i)) != null; i++){
            xCoordinates.add(e.getX());
        }
        return xCoordinates.getMin();
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
