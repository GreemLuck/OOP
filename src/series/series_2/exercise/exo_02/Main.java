package series.series_2.exercise.exo_02;

public class Main {
    public static void main(String[] args){
        Person a = Person.fromFirstName("Alex", 54);
        Person b = Person.fromLastName("Big", 98);
        Person c = Person.fromFirstName("Alex", 21);

        a.setLastName("Jones");
        b.setFirstName("Chungus");
        b.setAge(32);
        c.setLastName("Jones");
    }
}
