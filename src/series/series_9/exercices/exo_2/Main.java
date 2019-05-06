package series.series_9.exercices.exo_2;

import java.awt.Point;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> intStack = new Stack<>();
        Stack<Point> pointStack = new Stack<>();
        Random rand = new Random();


        for (int i = 0; i < 157; i++) {
            intStack.push(new Integer(rand.nextInt(1000)));
            pointStack.push(new Point(rand.nextInt(1000),rand.nextInt(1000)));
        }

        while (!intStack.isEmpty()) {
            System.out.println(intStack.pop());
        }

        while (!pointStack.isEmpty()) {
            System.out.println(pointStack.pop());
        }
    }
}
