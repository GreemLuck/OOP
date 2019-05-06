package series.series_10.exercices.exo_2;

public class Main {
    public static void main(String[] args) {

        // Some variables of different types
        int int_a = 10, int_b = 20, int_c = 30, int_d =100;
        double double_a = 0.1, double_b = 0.2, double_c = 0.5;
        String string_a = "This is string a",
                string_b = "This is string b",
                string_c = "This is string c";


        // Creation of boxes
        Box boxInt = new Box(int_a, int_b);
        Box boxDouble = new Box(double_a, double_b);
        Box boxStrDouble = new Box(string_a, double_c);
        Box boxStringInt = new Box(string_b, int_c);
        Box boxStringInt2 = new Box(string_c, int_d);

        // Test of moveFirstTo
        System.out.print("Test of moveFirstTo \n");
        boxStringInt.display("Box 1");
        boxStringInt2.display("Box 2");
        boxStringInt.moveFirstTo(boxStringInt2);
        boxStringInt.display("Box 1");
        boxStringInt2.display("Box 2");
        System.out.print("\n \n");

    }
}
