package project.Controller;

import oop.lib.Animation;
import project.Model.*;
import project.View.Board;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

public class SpaceInvaders extends MyAnimation {

    final static public int BOARD_WIDTH = 800;
    final static public int BOARD_HEIGHT = 800;

    public static void main(String[] args) {
        new SpaceInvaders().launch(true);
    }

    private SpaceInvaders(){;}

    MyLinkedList<Shot> shots = new MyLinkedList<Shot>();
    Group<Enemy> enemies = new Group<>();
    Player player = new Player(BOARD_WIDTH/2, BOARD_HEIGHT-(Player.PLAYER_ICON.getIconHeight() +10 )*2);

    Board board = new Board(BOARD_HEIGHT, BOARD_WIDTH, enemies, shots, player);

    @Override
    protected void init() {
        super.init();

        board.addKeyListener(new KeyController(player, board).keyListener);
        setDisplay(board);
    }

    @Override
    protected void step() {
        super.step();

        gameOver();

        // Updating the ShotList
        for(Shot s: shots){
            s.update();
        }

        // Updating the EnemyList
        for(Enemy e: enemies){
            Shot s = e.shoot();
            if(s != null) shots.add(s);
        }

        try {
            moveEnemies();
        } catch (NullPointerException e){
            board.gameOver("WIN");
        }

        player.move(player.getDirection());
        resolveShotsCollision();
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
                switch (e.getKeyCode()){
                    case KeyEvent.VK_LEFT:
                        player.setDirection(Direction.LEFT);
                        break;
                    case KeyEvent.VK_RIGHT:
                        player.setDirection(Direction.RIGHT);
                        break;
                    case KeyEvent.VK_SPACE:
                        if((System.currentTimeMillis() - player.getLastShot())>= player.getShotSpeed()) {
                            shots.add(player.shoot());
                            player.setLastShot(System.currentTimeMillis());
                        }
                        break;
                }
            }

            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_LEFT:
                        if(player.getDirection() == Direction.LEFT){
                            player.setDirection(Direction.UP);
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        if(player.getDirection() == Direction.RIGHT){
                            player.setDirection(Direction.UP);
                        }
                }
            }

        };
    }

    public void moveEnemies(){
        // Step for the enemies
        enemies.move(enemies.getDirection());

        // If the border is met, everybody goes down and direction is changed
        if(enemies.getMax() >= BOARD_WIDTH - enemies.getWidth()){
            enemies.setDirection(Direction.LEFT);
            enemies.move(Direction.DOWN);
        } else if( enemies.getMin() <= 0){
            enemies.setDirection(Direction.RIGHT);
            enemies.move(Direction.DOWN);
        }
    }

    public void resolveShotsCollision(){
        MyLinkedList<Shot> shotsToRemove = new MyLinkedList<>();

        // Check for damage
        for(Shot shot: shots){

            if(shot == null){
                continue;
            }
            // Check if enemies are hit
            if(shot.getDirection() == Direction.UP){
                if(enemies.getHit(shot)){
                    shotsToRemove.add(shot);
                }
            }

            // Check if player is hit
            if(shot.getDirection() == Direction.DOWN){
                if(player.getHit(shot)){
                    shotsToRemove.add(shot);
                }
            }

            // Out of bounds shots
            if(shot.getY() < 0 || shot.getY() > BOARD_HEIGHT){
                shotsToRemove.add(shot);
            }
        }

        // remove all shots
        for(Shot shot: shotsToRemove){
            shots.remove(shot);
        }

        // Check for dead enemies
        enemies.detectAndRemoveDeadEnemies();
    }

    public void gameOver(){

        // Check if enemies crossed the losing line
        for(Enemy e: enemies){
            if(e.getY() > BOARD_HEIGHT - 200){
                board.gameOver("LOSE");
            }
        }

        // Check player hitpoints
        if(player.isDead()){
            board.gameOver("LOSE");
        }
    }


}
