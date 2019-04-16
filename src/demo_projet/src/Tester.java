import model.enemy.AlienShip;
import model.player.Player;
import model.shot.Bomb;
import oop.lib.Animation;


public class Tester extends Animation {

    private AlienShip alien = null;
    private Player player = null;
    private Bomb bomb = null;

    public static void main(String[] args){
        new Tester().launch(true);
    }

    @Override
    public void init() {
        super.init();

        alien = new AlienShip(100, 100);
        player = new Player(400, 200);
        bomb = new Bomb(200,200, "DOWN");

        add(alien);
        add(player);
        add(bomb);

    }

    @Override
    protected void step() {
        alien.move("RIGHT");
        player.move("LEFT");
        bomb.move();
    }
}
