package series.series_5.exercices.exo_3;

import series.series_5.exercices.exo_3.Character ;
import series.series_5.exercices.exo_3.PrettyPrinter ;

public class Main {
    public static void main(String[] args) {
        Character character = new Character("How to Avoid Huge Ships", "John W. Trimmer", 35);
        System.out.println(character);
        System.out.println(PrettyPrinter.printCharacter(character));
    }
}


