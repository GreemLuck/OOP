package core;

public class ElectricCar extends Car {

    private int enginePower;

    public ElectricCar(final String model, final int enginePower){
        super.model = model;
        this.enginePower = enginePower;
    }
}
