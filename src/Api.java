import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Api {
    public static String getDistance(String locationOne, String locationTwo) throws IOException {
        String distance = "";
        URL url = new URL("https://www.distance24.org/result.distance?stops=" + locationOne + "|" + locationTwo);
        URLConnection connection = url.openConnection();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))){
            String line;
            while ((line = in.readLine()) != null){
                if (line.contains("\"The distance between")){
                    distance = line.substring(line.lastIndexOf("is") + 3, line.indexOf("kilometers") - 6);
//                    distance = line;
                }
            }
        }catch(Exception e){
            return null;
        }
        return distance;
    }
}
