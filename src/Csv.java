import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class Csv {
    public static String[][] csvToArray(String csvUrl, String[][] modifiedArray) throws IOException {
        try
        {
            String distance = "";
            URL url = new URL(csvUrl);
            URLConnection connection = url.openConnection();
            BufferedReader infile = new BufferedReader (new InputStreamReader(connection.getInputStream()));
            String line;
//            System.out.println("Beginning to read the file now:");
            line=infile.readLine();
            int lineNum = 0;
            while (line!=null)
            {
                String data[]=line.split(",");
                for (int i=0;i<data.length;i++)
                {
                    if (i == 0)
                        modifiedArray[lineNum][0] = data[i].replaceAll(" ","%20").replace("\"","");
                    else if (i == 1)
                        modifiedArray[lineNum][1] = data[i];
                }
                line=infile.readLine();
                lineNum++;
            }
//            System.out.println("Closing file.");
            infile.close();
        }catch (FileNotFoundException e)
        {
            System.out.println("Incorrect filename or location. Please verify path and filename. ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return modifiedArray;
    }
    public static int csvSize(String csvUrl, String type) throws IOException {
        int columns = 0;
        int rows = 0;
        try
        {
            URL url = new URL(csvUrl);
            URLConnection connection = url.openConnection();
            BufferedReader infile = new BufferedReader (new InputStreamReader(connection.getInputStream()));
            String line;
//            System.out.println("Beginning to read the file now:");
            line=infile.readLine();
            String data[]=line.split(",");
            columns = data.length;
            while (line!=null)
            {
                line=infile.readLine();
                rows++;
            }
//            System.out.println("Closing file.");
            infile.close();
        }catch (FileNotFoundException e)
        {
            System.out.println("Incorrect filename or location. Please verify path and filename. ");
        }
        if (type.equalsIgnoreCase("rows"))
            return rows;
        return columns;
    }
}
