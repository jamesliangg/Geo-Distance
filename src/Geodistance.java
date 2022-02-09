import java.io.IOException;
import java.net.MalformedURLException;

public class Geodistance {
    public static void main(String[] args) throws IOException {
        boolean result = false;
        int rows = Csv.csvSize("https://pkgstore.datahub.io/core/country-list/data_csv/data/d7c9d7cfb42cb69f4422dec222dbbaa8/data_csv.csv", "rows");
        int columns = Csv.csvSize("https://pkgstore.datahub.io/core/country-list/data_csv/data/d7c9d7cfb42cb69f4422dec222dbbaa8/data_csv.csv", "columns");
        String countries[][] = new String[rows][columns];
        countries = Csv.csvToArray("https://pkgstore.datahub.io/core/country-list/data_csv/data/d7c9d7cfb42cb69f4422dec222dbbaa8/data_csv.csv", countries);
        for (int i = 0; i <= 20; i++) {
            do {
                String locationOne = Randomizer.getRandomFromArray(countries);
                String locationTwo = Randomizer.getRandomFromArray(countries);
                do {
                    locationTwo = Randomizer.getRandomFromArray(countries);
                } while (locationOne.equals(locationTwo));
                System.out.println(locationOne);
                System.out.println(locationTwo);
                String distance = Api.getDistance(locationOne, locationTwo);
                if (distance != null) {
                    result = true;
                }
                System.out.println(distance);
            } while (result == false);
        }
    }
}
