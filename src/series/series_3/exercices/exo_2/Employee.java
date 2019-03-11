package series.series_3.exercices.exo_2;

public class Employee extends Person{

    protected double salary;

    public Employee(String name, int age, double salary){
        super(name, age);
        this.salary = salary;
    }

    public double getSalary(){
        return salary;
    }

    @Override
    public String toString(){
        String str = "name: " + getName() + "\n" +
                     "age: "  + getAge() + "\n" +
                     "salary: " + getSalary() + "\n\n";
        return str;
    }
}
