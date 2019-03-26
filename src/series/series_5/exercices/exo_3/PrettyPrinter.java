package series.series_5.exercices.exo_3;

public class PrettyPrinter {
    public static String printCharacter(Character character) {
        return "Character{" +
                "bookTitle='" + character.bookTitle + '\'' +
                ", name='" + character.name + '\'' +
                ", age=" + character.age +
                '}';
    }
}
