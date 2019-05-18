package project.View;

import oop.lib.Display;
import project.Model.*;

import javax.swing.*;
import java.awt.*;

public class Board extends Display {

    Color bgColor = new Color(48,130,247);

    private int height;
    private int width;
    private String state = "PLAY";

    final static public Image WIN_SCREEN = new ImageIcon(Board.class.getResource("/win.png")).getImage()
                                            .getScaledInstance(160,70, Image.SCALE_DEFAULT);
    final static public Image LOSE_SCREEN = new ImageIcon(Board.class.getResource("/lose.png")).getImage()
                                            .getScaledInstance(200, 70, Image.SCALE_DEFAULT);

    private MyLinkedList<Enemy>  enemies;
    private MyLinkedList<Shot> shots;
    private Player player;


    public Board(int height, int width, MyLinkedList<Enemy> enemies, MyLinkedList<Shot> shots, Player player) {
        super(height,width);
        this.height = height;
        this.width = width;
        this.enemies = enemies;
        this.shots = shots;
        this.player = player;

        setBackground(bgColor);
        createEnemies(7,5);
    }

    @Override
    public void paint(Display display) {

        // Game Over screen
        if(state == "WIN"){
            drawImage(WIN_SCREEN,
                    width/2 - WIN_SCREEN.getWidth(this)/2,
                    height/2 - WIN_SCREEN.getHeight(this)/2);
            return;
        } else if(state == "LOSE"){
            drawImage(LOSE_SCREEN,
                    width/2 - LOSE_SCREEN.getWidth(this)/2,
                    height/2 - LOSE_SCREEN.getHeight(this)/2);
            return;
        }


        // Player
        player.paint(display);


        // Enemies and shots
        for(Enemy e: enemies){
            e.paint(display);
        }

        for(Shot s: shots){
            s.paint(display);
        }

        // Player Healthbar
        Image p = Player.PLAYER_ICON.getImage();
        for(int i=0; i < player.getHitPoints(); i++){
            drawImage(p, 10 + (10 + p.getWidth(this))*i, height - p.getHeight(this) - 10);
        }
    }

    public void createEnemies(int col, int row){

        int enemyHeight = Enemy.ENEMY_ICON.getIconHeight();
        int enemyWidth = Enemy.ENEMY_ICON.getIconWidth();

        for(int x = 0; x<col ; x++){
            int xOffset = enemyHeight*(1 + 2*x);
            for(int y = 0; y<row; y++){
                int yOffset = enemyWidth*(1 + 2*y);
                enemies.add(new Enemy(xOffset, yOffset));
            }
        }
    }

    public void gameOver(String s){
        state = s;
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
