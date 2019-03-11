package series.series_3.exercices.exo_2;

public class Person {

    protected String name;
    protected int age;

    public Person (String name, int age){
        this.age = age;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    @Override
    public String toString(){
        String str = "name: " + getName() + "\n" +
                     "age: "  + getAge() + "\n\n";
        return str;
    }
}
