package core;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("MyCar");

        System.out.println(car);

        ElectricCar electricCar = new Car("MyElectricCar", 100);

        System.out.println(electricCar);
    }
}
