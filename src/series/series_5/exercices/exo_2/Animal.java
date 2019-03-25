package series.series_5.exercices.exo_2;

public abstract class Animal {
    private int age;
    private int weight;
    private String sex;

    protected Animal(int age, int weight, String sex) {
        this.age = age;
        this.weight = weight;
        this.sex = sex;
    }

    protected abstract void doSound();

    protected abstract void est();

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public String getSex() {
        return sex;
    }
}