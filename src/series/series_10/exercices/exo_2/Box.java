package series.series_10.exercices.exo_2;

public class Box<F, S> {
    F first;
    S second;

    public Box(F first, S second){
        this.first = first;
        this.second = second;
    }

    void moveFirstTo(Box<F, ?> box){
        System.out.print("Moving ... \n");

        box.first = this.first;
    }

    void moveItemsFrom(Box<F, S> box){
        System.out.print("Moving ... \n");

        this.first = box.first;
        this.second = box.second;
    }

    void swapItemsWith(Box<F, S> box){
        System.out.print("Swapping ... \n");

        F temp1 = box.first;
        S temp2 = box.second;

        box.first = this.first;
        box.second = this.second;

        this.first = temp1;
        this.second = temp2;
    }

    <T> void moveFirstToSecond(Box<T, T> box){
        System.out.print("Moving ... \n");

        box.second = box.first;
    }

    <T> void swapItems(Box<T, T> box){
        System.out.print("Swapping ... \n");

        T temp = box.first;
        box.first = box.second;
        box.second = temp;
    }

    void display(String name){
        System.out.print(name + " :" + first + ", " + second + "\n");
    }
}
