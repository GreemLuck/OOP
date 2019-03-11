package series.series_3.exercices.exo_2;

public class Student extends Person {

    protected String major;

    public Student (String name, int age, String major){
        super(name, age);
        this.major = major;
    }

    public String getMajor(){
        return major;
    }

    @Override
    public String toString(){
        String str = "name: " + getName() + "\n" +
                     "age: "  + getAge() + "\n" +
                     "major: " + getMajor() + "\n\n";
        return str;
    }
}
