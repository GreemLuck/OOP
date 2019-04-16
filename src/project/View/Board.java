package project.View;

import oop.lib.Display;
import project.Model.*;

import java.awt.*;

public class Board extends Display {

    Color bgColor = new Color(48,130,247);

    private int height;
    private int width;

    private EnemyList enemies;
    private ShotList shots;
    private Player player;


    public Board(int height, int width, EnemyList enemies, ShotList shots, Player player) {
        super(height,width);
        this.height = height;
        this.width = width;
        this.enemies = enemies;
        this.shots = shots;
        this.player = player;

        setBackground(bgColor);
        createEnemies(7,3);
    }

    @Override
    public void paint(Display display) {
        player.paint(display);

        for(int i = 0; enemies.get(i) != null; i++){
            enemies.get(i).paint(display);
        }

        for(int i = 0; shots.get(i) != null; i++){
            shots.get(i).paint(display);
        }
    }

    public void createEnemies(int col, int row){

        int enemyHeight = Enemy.ENEMY_ICON.getIconHeight();
        int enemyWidth = Enemy.ENEMY_ICON.getIconWidth();

        for(int x = 0; x<col ; x++){
            int xOffset = enemyHeight*(1 + 2*x);
            for(int y = 0; y<row; y++){
                int yOffset = enemyWidth*(1 + 2*y);
                enemies.addEnemy(xOffset, yOffset);
            }
        }
    }

    public void gameOver(){
        // display a win of lose screen
    }

    //////////////////////////////////////////////////////////////////////
    // GETTERS & SETTERS
    //////////////////////////////////////////////////////////////////////

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
