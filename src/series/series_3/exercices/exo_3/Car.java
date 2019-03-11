package core;

public class Car {

    public static int NUMBER_OF_WHEELS = 4;
    protected String model;

    public Car(String model){
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                '}';
    }
}
