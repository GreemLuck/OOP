package series.series_2.exercise.exo_02;

public class Person {

    private String fname, lname;
    private int age;
    private static Person[] persons = new Person[10];
    private static int counter = 0;

    private Person(String fname, String lname, int age){
        this.fname = fname;
        this.lname = lname;
        this.age = age;
    }

    public static Person fromFirstName(String fname, int age){
        return new Person(fname, null, age);
    }

    public static Person fromLastName(String lname, int age){
        return new Person(null, lname, age);
    }

    public void setFirstName(String fname){
        this.fname = fname;
        if(this.exists()){
            System.out.println("The persone " + this.fname + " " + this.lname + " already exists.");
        } else {
            persons[counter++] = this;
        }

    }

    public void setLastName(String lname){
        this.lname = lname;
        if(this.exists()){
            System.out.println("The persone " + this.fname + " " + this.lname + " already exists.");
        } else {
            persons[counter++] = this;
        }
    }

    public void setAge(int age){
        this.age = age;
    }

    public boolean exists(){
        for(Person p: persons){
            if(this.equals(p)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object other){
        if(this == other) return true;
        if(other == null || getClass() != other.getClass()) return false;

        Person person = (Person) other;

        return (this.fname == person.fname) && (this.lname  == person.lname);
    }

    @Override
    public int hashCode(){
        int returnValue = lname != null ? lname.hashCode() : 0;
        returnValue += fname != null ? fname.hashCode() : 0;
        returnValue += age;
        return returnValue;
    }
}
