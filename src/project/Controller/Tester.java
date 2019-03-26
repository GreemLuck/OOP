package project.Controller;

import oop.lib.Animation;
import project.View.Enemy;
import project.View.Player;
import project.View.ShotEnemy;
import project.View.ShotPlayer;

public class Tester extends Animation {

    public static void main(String[] args) {
        new Tester().launch(true);
    }

    Enemy enemy;
    Player player = new Player();
    ShotPlayer shot_p;
    ShotEnemy shot_e;

    @Override
    public void init() {
        super.init();

        // Put here the filename/path of the image (e.g. /player.png)
        // DO NOT FORGET THE / IN THE BEGINNING
        // DO NOT FORGET TO MARK YOUR FOLDER AS "RESOURCES" (Google it: IntelliJ marking folder as resources)
//        Image img = new ImageIcon(Tester.class.getResource("/player.jpg")).getImage();
//        Sprite sprite = new Sprite(img, 0,0);
//        add(sprite);
//        System.out.println(sprite.getX());
//        System.out.println(sprite.getWidth());

        add(enemy = new Enemy(100, 100));
        add(player);
        add(shot_p = new ShotPlayer(300, 250));
        add(shot_e = new ShotEnemy(20, 30));
    }

    @Override
    public void step(){
        enemy.move(-1,-1);
        player.move(1,0);
        shot_e.move(0,-1);
        shot_p.move(0, 1);
    }

}
