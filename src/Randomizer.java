import java.util.Random;

public class Randomizer {
    public static String getRandomFromArray(String[][] array)
    {
        Random r = new Random();
        int randomNumber = r.nextInt(array.length);
        return array[randomNumber][0];
    }
}
