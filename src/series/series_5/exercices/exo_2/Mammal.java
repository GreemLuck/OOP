package series.series_5.exercices.exo_2;

public abstract class Mammal extends Animal implements Lactating{
    private int numberOfNipples;

    protected Mammal(int age, int weight, String sex){
        super(age, weight, sex);
    }

    public int getNumberOfNipples() {
        return numberOfNipples;
    }
}
