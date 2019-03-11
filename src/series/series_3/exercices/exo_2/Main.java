package series.series_3.exercices.exo_2;

public class Main {
    public static void main(String[] args){
        Person a = new Person("Alex", 23);
        Person b = new Employee("Bob", 45, 1250.50);
        Student c = new Student("Charles", 18, "Procrastination");

        System.out.print(a.toString());
        System.out.print(b.toString());
        System.out.print(c.toString());
    }
}
