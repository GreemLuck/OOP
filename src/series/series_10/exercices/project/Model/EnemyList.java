package project.Model;

import project.View.Sprite;

public class EnemyList extends SpriteList {
    private Enemy[] enemyLst;

    public EnemyList(){
        super();;
    }

    public void addEnemy(int x, int y){
        this.add(new Enemy(x, y));
    }

    private int findIndex(Enemy enemy){
        for(int i = 0; i <= getSize(); i++){
            if(enemy.equals((Enemy)get(i))){
                return i;
            }
        }
        return -1;
    }

    public void remove(Enemy enemy){
        int index = findIndex(enemy);
        if(index != -1) remove(index);
    }

    public Enemy get(int pos) {
        return (Enemy) super.get(pos);
    }
}
