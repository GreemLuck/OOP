package core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> intList = new ArrayList<>();
        for (int i = 4; i > 0; i--) {
            intList.add(i);
        }

        System.out.println("Integer list before");
        for(Integer i : intList){
            System.out.println("i = " + i);
        }

        shuffle(intList);
        Collections.sort(intList);

        System.out.println("Integer list sorted");
        for(Integer i : intList){
            System.out.println("i = " + i);
        }


        ArrayList<Double> doubleList = new ArrayList<>();
        for (double i = 4; i > 0; i--) {
            doubleList.add(i);
        }

        System.out.println("Double list before");
        for(Double d : doubleList){
            System.out.println("d = " + d);
        }

        shuffle(doubleList);
        Collections.sort(doubleList);

        System.out.println("Double list sorted");
        for(Double d : doubleList){
            System.out.println("d = " + d);
        }
    }

    private static void shuffle(ArrayList<? extends Number> list){
        ArrayList lst = list;
        Random rnd = new Random();
        for (int i=0; i<lst.size(); i++)  {
            int j = rnd.nextInt(lst.size());
            Number ii = ((Number)lst.get(i)).intValue();
            Number ij = ((Number)lst.get(j)).intValue();
            lst.set(i, ij);
            lst.set(j, ii);
        }
    }
}


