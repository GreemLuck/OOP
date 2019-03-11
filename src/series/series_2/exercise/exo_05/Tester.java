package project;

import oop.lib.Animation;
import oop.lib.Painting;

import javax.print.StreamPrintService;
import javax.swing.*;
import java.awt.*;

public class Tester extends Animation {

    public static void main(String[] args) {
        new Tester().launch(true);
    }

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

        SpriteList sprites = new SpriteList();

        Sprite chungus = Sprite.makeBigChungus(0,0);
        Sprite shaggy = Sprite.makeShaggy(50,50);
        Sprite matt = Sprite.makeMatt(-100,-20);
        Sprite chungu2 = Sprite.makeBigChungus(10, 200);

        sprites.add(matt);
        sprites.add(chungus);
        sprites.add(chungu2);
        sprites.add(shaggy);

        for(int i = 0; i<sprites.getSize(); i++){
            add(sprites.get(i));
        }
    }
}
