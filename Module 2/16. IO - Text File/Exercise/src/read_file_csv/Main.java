package read_file_csv;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Project: Exercise
 * Package: read_file_csv
 * User: lomahs
 * Date time: 16/06/2021 19:28
 * Created with IntelliJ IDEA
 */
public class Main {

    public static List<Country> readCountry(String filePath){
        List<Country> listCountry = new ArrayList<>();
        File file = new File(filePath);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] countryInfo = line.split(",");
                Country country = new Country(countryInfo[0],countryInfo[1],countryInfo[2],countryInfo[3],countryInfo[4],countryInfo[5]);
                listCountry.add(country);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return listCountry;
    }

    public static void displayCountry(List<Country> listCountry){
        for (Country country : listCountry) {
            System.out.println(country);
        }
    }

    public static void main(String[] args) {

        String FILE_PATH = "src//read_file_csv//doc//country.csv";

        displayCountry(readCountry(FILE_PATH));
    }
}
