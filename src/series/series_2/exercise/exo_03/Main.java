package week2.src.ex3;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("MyCar");
        System.out.println(Car.NUMBER_OF_WHEELS);

        Car car2 = new Car(new String("MyCar"));

        if(car1.equals(car2)){
            System.out.println("They are the same car!");
        }

        car1.hashCode();
    }
}