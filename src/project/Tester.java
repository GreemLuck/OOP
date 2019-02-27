package project;

import oop.lib.Animation;
import oop.lib.Painting;

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
        Image img = new ImageIcon(Tester.class.getResource("/player.jpg")).getImage();
        Sprite sprite = new Sprite(img, 0,0);
        add(sprite);
        System.out.println(sprite.getX());
        System.out.println(sprite.getWidth());
    }
}
