package project.Controller;

import oop.lib.Animation;
import project.Model.*;
import project.View.Board;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SpaceInvaders extends MyAnimation {

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

        board.addKeyListener(new KeyController(player, board).keyListener);
        setDisplay(board);
    }

    @Override
    protected void step() {
        super.step();

        if(enemies.isEmpty()){
            board.gameOver();
        }

        // Updating the ShotList
        for(int i = 0; shots.get(i) != null; i++){
            shots.get(i).update();
        }

        // Updating the EnemyList
        for(int i = 0; enemies.get(i) != null; i++){
            Shot s = enemies.get(i).shoot();
            if(s != null) shots.addShot(s);
        }
        moveEnemies();
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
                        player.move("LEFT");
                        break;
                    case KeyEvent.VK_RIGHT:
                        player.move("RIGHT");
                        break;
                    case KeyEvent.VK_SPACE:
                        if((System.currentTimeMillis() - player.getLastShot())>= player.getShotSpeed()) {
                            shots.add(player.shoot());
                            player.setLastShot(System.currentTimeMillis());
                        }
                        break;
                }
            }

        };
    }

    public void moveEnemies(){

        // Get X coordinates of all enemies
        IntegerList xCoordinates = new IntegerList();
        Enemy e;
        for(int i = 0; (e = enemies.get(i)) != null; i++){
            xCoordinates.add(e.getX());
        }

        // Step for the enemies
        for(int i = 0; (e = enemies.get(i)) != null; i++){
            e.move(e.getDirection());
        }

        // if the border is met, everybody goes down and direction is changed
        if (xCoordinates.getMax() >= BOARD_WIDTH - enemies.get(0).getWidth()){
            for(int i = 0; (e = enemies.get(i)) != null; i++){
                e.setDirection("LEFT");
                e.move("DOWN");
            }
        } else if (xCoordinates.getMin() <= 0){

            for(int i = 0; (e = enemies.get(i)) != null; i++){
                e.setDirection("RIGHT");
                e.move("DOWN");
            }
        }
    }

    public void resolveShotsCollision(){
        ShotList shotsToRemove = new ShotList();
        EnemyList enemiesToRemove = new EnemyList();

        Enemy e;
        Shot shot;

        // Check for damage
        for(int i = 0; (shot = shots.get(i)) != null; i++){
            // Check if enemies are hit
            if(shot == null){
                continue;
            }

            if(shot.getDirection().equals("UP")){

                for(int j = 0; (e = enemies.get(j)) != null; j++){
                    if(e.checkCollision(shot)){
                        e.gotHit();
                        shotsToRemove.add(shot);
                        break;
                    }
                }
            }
            // Out of bounds shots
            if(shot.getY() < 0 || shot.getY() > BOARD_HEIGHT){
                shotsToRemove.add(shot);
            }
        }

        // remove all shots
        for(int i = 0; (shot = shotsToRemove.get(i)) != null; i++){
            shots.remove(shot);
        }

        // Check for dead enemies
        for(int i = 0; (e = enemies.get(i)) != null; i++){
            if(e.isDead()){
                enemiesToRemove.add(e);
            }
        }

        // remove dead enemies
        for(int i = 0; (e = enemiesToRemove.get(i)) != null; i++){
            enemies.remove(e);
        }
    }


}
