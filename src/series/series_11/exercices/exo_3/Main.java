package core;

import project.Model.IntegerList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(random.nextInt(10));
        }

        //removeEvilEvenNumbers1(arrayList);
        //removeEvilEvenNumbers2(arrayList);
        removeEvilEvenNumbers3(arrayList);
    }

    private static void removeEvilEvenNumbers1(ArrayList<Integer> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i) % 2 == 0){
                arrayList.remove(i);
            }
        }
    }

    private static void removeEvilEvenNumbers2(ArrayList<Integer> arrayList) {
        for(Iterator<Integer> iter = arrayList.iterator(); iter.hasNext();){
            Integer i = iter.next();
            if(arrayList.get(i) % 2 == 0){
                iter.remove();
            }
        }
    }

    private static void removeEvilEvenNumbers3(ArrayList<Integer> arrayList) {
        int n = arrayList.size();
        for (int i = 0; i < n; i++) {
            if(arrayList.get(i) % 2 == 0){
                arrayList.remove(i);
            }
        }
    }
}


