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

    public Enemy get(int pos) {
        return (Enemy) super.get(pos);
    }
}
