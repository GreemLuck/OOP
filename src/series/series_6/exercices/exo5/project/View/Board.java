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
