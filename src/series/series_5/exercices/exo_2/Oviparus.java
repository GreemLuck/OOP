package series.series_5.exercices.exo_2;

abstract public class Oviparus extends Animal implements Ovipar{
    private int averageAmountOfEggs;

    Oviparus(int age, int weight, String sex){
        super(age, weight, sex);
    }

    public int getAverageAmountOfEggs() {
        return averageAmountOfEggs;
    }
}
