package project.Controller;

import oop.lib.Animation;
import project.Model.*;
import project.View.Board;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SpaceInvaders extends Animation {

    final static public int BOARD_WIDTH = 500;
    final static public int BOARD_HEIGHT = 500;

    public static void main(String[] args) {
        new SpaceInvaders().launch(true);
    }

    private SpaceInvaders(){;}

    ShotList shots = new ShotList();
    EnemyList enemies = new EnemyList();
    Player player = new Player(BOARD_WIDTH/2, BOARD_HEIGHT-Player.PLAYER_ICON.getIconHeight()*2);

    Board board = new Board(BOARD_HEIGHT, BOARD_WIDTH, enemies, shots, player);

    @Override
    protected void init() {
        super.init();

        enemies.addEnemy(125,150);
        enemies.addEnemy(200,150);
        enemies.addEnemy(275,150);

        board.addKeyListener(new KeyController(player, board).keyListener);
        setDisplay(board);
    }

    @Override
    protected void step() {
        super.step();

        // Updating the ShotList
        for(int i = 0; shots.get(i) != null; i++){
            shots.get(i).update();
        }

        // Updating the EnemyList
        for(int i = 0; enemies.get(i) != null; i++){
            Shot s = enemies.get(i).shoot();
            if(s != null) shots.addShot(s);
        }
    }

    public class KeyController {

        private Player player;

        public KeyController(Player player, Board board) {
            this.player = player;
            board.addKeyListener(keyListener);
            board.requestFocusInWindow();
        }

        public KeyListener keyListener = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    player.move("LEFT");
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    player.move("RIGHT");
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE){
                    if((System.currentTimeMillis() - player.getLastShot())>= player.getShotSpeed()) {
                        shots.addShot(player.shoot());
                        player.setLastShot(System.currentTimeMillis());
                    }
                }
            }

        };
    }
}
