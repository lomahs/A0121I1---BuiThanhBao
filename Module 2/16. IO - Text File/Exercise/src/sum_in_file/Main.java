package sum_in_file;

import java.io.*;
import java.util.ArrayList;

/**
 * Project: Exercise
 * Package: sum_in_file
 * User: lomahs
 * Date time: 17/06/2021 09:52
 * Created with IntelliJ IDEA
 */
public class Main {

    public static int sum(String filePath) throws IOException, NumberFormatException {
        File file = new File(filePath);

        if (!file.exists()) {
            throw new IOException("File not exist");
        }

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        int sum = 0;
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            // ... do something with line
            sum += Integer.parseInt(line);
        }
        bufferedReader.close();

        return sum;
    }

    public static void main(String[] args) {
        final String FILE_PATH = "src//sum_in_file//doc//doc.txt";

        try {
            System.out.println(sum(FILE_PATH));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e){
            System.out.println("NOT NUMBER EXIST or MORE THAN ONE NUMBER IN LINE");
        }
    }
}
