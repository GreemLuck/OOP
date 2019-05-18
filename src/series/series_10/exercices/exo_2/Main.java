package series.series_10.exercices.exo_2;

public class Main {
    public static void main(String[] args) {


        // Test of moveFirstTo
        Box<String, Integer> box1 = new Box<>("Sentece A", 12);
        Box<String, Integer> box2 = new Box<>("Sentence B", 23);

        System.out.print("Test of moveFirstTo \n");
        box1.display("Box 1");
        box2.display("Box 2");
        box1.moveFirstTo(box2);
        box1.display("Box 1");
        box2.display("Box 2");
        System.out.print("\n \n");

        // Test of moveItemsFrom
        box2.first = "Sentence B";

        System.out.print("Test of moveItemsFrom \n");
        box1.display("Box 1");
        box2.display("Box 2");
        box1.moveItemsFrom(box2);
        box1.display("Box 1");
        box2.display("Box 2");
        System.out.print("\n \n");

        // Test of swapItemsWith
        box1.first = "Sentence A";
        box1.second = 12;

        System.out.print("Test of swapItemsWith \n");
        box1.display("Box 1");
        box2.display("Box 2");
        box1.swapItemsWith(box2);
        box1.display("Box 1");
        box2.display("Box 2");
        System.out.print("\n \n");

        // Test of  moveFirstToSecond
        Box<Integer, Integer> box3 = new Box<>(12, 67);

        System.out.print("Test of moveFirstToSecond \n");
        box3.display("Box");
        box3.moveFirstToSecond(box3);
        box3.display("Box");
        System.out.print("\n \n");

        // Test of swapItems
        box3.second = 56;

        System.out.print("Test of swapItems \n");
        box3.display("Box");
        box3.swapItems(box3);
        box3.display("Box");
        System.out.print("\n \n");

    }
}
