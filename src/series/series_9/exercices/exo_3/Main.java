package series.series_9.exercices.exo_3;

public class Main {
    public static void main(String[] args) {

        Point p = new Point(5,7);
        Circle c1 = new Circle(p, 3);
        Circle c2 = new Circle(p.clone(), 5);

        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);

        c1.moveTo(2,3);

        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);

    }
}


