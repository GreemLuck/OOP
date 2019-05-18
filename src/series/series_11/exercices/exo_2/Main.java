package week_11.Implementation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        long start = System.nanoTime();

        Random rand = new Random();
        LinkedList<Integer> linkedList = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < 1e4; i++) {
            linkedList.add(rand.nextInt());
            arrayList.add(rand.nextInt());
        }

        long sum = 0;
        for (int i = 0; i < 1e6; i++) {
            sum += arrayList.get(rand.nextInt(arrayList.size()));
        }
        long chrono = System.nanoTime();
        System.out.println(chrono-start);

        sum = 0;
        for (int i = 0; i < 1e6; i++) {
            sum += linkedList.get(rand.nextInt(linkedList.size()));
        }
        System.out.println(System.nanoTime()-chrono);

    }
}
