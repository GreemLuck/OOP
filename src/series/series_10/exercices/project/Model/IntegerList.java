package project.Model;

import project.View.Sprite;

import java.util.Arrays;

public class IntegerList {

    private final static int LST_SIZE = 10;
    private int[] lst;
    private int size = 0;

    public IntegerList(){
        lst = new int[LST_SIZE];
    }

    public void add(int e){
        lst[size++] = e;
        if (size>=lst.length){
            lst = Arrays.copyOf(lst, lst.length+LST_SIZE);
        }
    }

    public void remove(int pos){
        int[] newLst = new int[lst.length];
        System.arraycopy(lst, 0, newLst, 0, pos);
        System.arraycopy(lst, pos+1, newLst, pos, lst.length-(pos+1));
        lst = newLst;
    }

    public boolean isEmpty(){
        if(size <= 0){
            return true;
        } else {
            return false;
        }
    }

    public int getSize(){
        return size;
    }

    public int[] getList(){
        return lst;
    }

    public int get(int pos){return lst[pos];}

    public int getMax(){

        int temp = get(0);

        for(int i = 0; i<size ; i++){
            int actual = get(i);
            if(actual >= temp) temp = actual;
        }

        return temp;
    }

    public int getMin(){

        int temp = get(0);

        for(int i = 0; i<size ; i++){
            int actual = get(i);
            if(actual <= temp) temp = actual;
        }

        return temp;
    }
}
