import java.io.IOException;
import java.net.MalformedURLException;

public class Geodistance {
    public static void main(String[] args) throws IOException {
        int rows = Csv.csvSize("https://pkgstore.datahub.io/core/country-list/data_csv/data/d7c9d7cfb42cb69f4422dec222dbbaa8/data_csv.csv", "rows");
        int columns = Csv.csvSize("https://pkgstore.datahub.io/core/country-list/data_csv/data/d7c9d7cfb42cb69f4422dec222dbbaa8/data_csv.csv", "columns");
        String countries[][] = new String[rows][columns];
        countries = Csv.csvToArray("https://pkgstore.datahub.io/core/country-list/data_csv/data/d7c9d7cfb42cb69f4422dec222dbbaa8/data_csv.csv", countries);
        String locationOne = Randomizer.getRandomFromArray(countries);
        String locationTwo = Randomizer.getRandomFromArray(countries);
        do{
            locationTwo = Randomizer.getRandomFromArray(countries);
        } while (locationOne.equals(locationTwo));
        System.out.println(locationOne);
        System.out.println(locationTwo);
        System.out.println(Api.getDistance(locationOne, locationTwo));
    }
}
