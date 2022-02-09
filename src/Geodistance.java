import java.io.IOException;
import java.util.Scanner;

public class Geodistance {
    public static void main(String[] args) throws IOException {
        int guesses = 0;
        boolean testInput = false;
        boolean correctGuess = false;
        int rows = Csv.csvSize("https://pkgstore.datahub.io/core/country-list/data_csv/data/d7c9d7cfb42cb69f4422dec222dbbaa8/data_csv.csv", "rows");
        int columns = Csv.csvSize("https://pkgstore.datahub.io/core/country-list/data_csv/data/d7c9d7cfb42cb69f4422dec222dbbaa8/data_csv.csv", "columns");
        String countries[][] = new String[rows][columns];
        countries = Csv.csvToArray("https://pkgstore.datahub.io/core/country-list/data_csv/data/d7c9d7cfb42cb69f4422dec222dbbaa8/data_csv.csv", countries);
        Scanner sc = new Scanner(System.in);
        String locationOne = Randomizer.getRandomFromArray(countries);
        do {
            String distance = Api.getDistance(locationOne, "Canada");
            if (distance != null) {
                testInput = true;
            }
        } while (testInput = false);
        do {
            System.out.println(locationOne);
            System.out.println("Enter Guess:");
            String locationTwo = sc.nextLine();
            if (locationTwo.toLowerCase().trim().equals("quit")){
                break;
            }
            locationTwo = locationTwo.replaceAll(" ","%20");
            System.out.println(locationTwo);
            String distance = Api.getDistance(locationOne, locationTwo);
            if (locationOne.trim().toLowerCase().equals(locationTwo.trim().toLowerCase())){
                correctGuess = true;
                break;
            }
            System.out.println(locationTwo + " is " + distance + "km away from the country.");
            guesses++;
            System.out.println("Guesses: " + guesses);
        } while (correctGuess == false);
        System.out.println("The answer was " + locationOne.replaceAll("%20", " "));
        if (correctGuess == true){
            System.out.println("Congrats, you finished in " + guesses + " guesses!");
        }
    }
}
