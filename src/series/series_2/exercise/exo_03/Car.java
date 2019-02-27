//package core;
//
//public class Car {
//
//    public static int NUMBER_OF_WHEELS = 4;
//    private String model;
//
//    public Car(String model){
//        this.model = model;
//    }
//
//    public String getModel() {
//        return model;
//    }
//
//    public void setModel(String model) {
//        this.model = model;
//    }
//
//    public static void printModel(){
//        System.out.println(this.model);
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Car car = (Car) o;
//
//        return model != null ? model == car.model : car.model == null;
//    }
//
//    @Override
//    public int hashCode() {
//        int returnValue = model != null ? model.hashCode() : 0;
//        return returnValue;
//    }
//}
