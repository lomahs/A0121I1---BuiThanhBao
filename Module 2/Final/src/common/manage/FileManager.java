package common.manage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Project: FuramaResort
 * Package: commons.io.manage
 * User: lomahs
 * Date time: 21/06/2021 16:24
 * Created with IntelliJ IDEA
 */
public class FileManager {

    public boolean isFileEmpty(String path){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

            if (bufferedReader.readLine()!=null){
                return false;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return true;
    }
}
