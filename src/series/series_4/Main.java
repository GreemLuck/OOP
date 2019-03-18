package core;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random random = new Random(42L);

        Tuple[] list = new Tuple[5];

        for (int i = 0; i < list.length; i++) {
            list[i] = new Tuple(random.nextInt(10),random.nextInt(10)+10);
        }

        for(Tuple t: list) {
            System.out.println(t.getA());
        }

    }
}


