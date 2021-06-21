package copy_text_file.manage;

import java.io.*;

/**
 * Project: Exercise
 * Package: copy_text_file.manage
 * User: lomahs
 * Date time: 16/06/2021 18:59
 * Created with IntelliJ IDEA
 */
public class Main {

    public static void copyFile(String srcPath, String destPath) throws IOException {

        File srcFile = new File(srcPath);
        File destFile = new File(destPath);

        if (!srcFile.exists())
            throw new IOException("File src not exist");
        if (destFile.exists()){
            throw new IOException("File dest is exist");
        }

        FileInputStream fis = new FileInputStream(srcFile);
        FileOutputStream fos = new FileOutputStream(destFile);

        int len;
        byte[] buffer = new byte[4096];
        while ((len = fis.read(buffer)) > 0) {
            fos.write(buffer, 0, len);
        }

        System.out.println("Complete Copy");
    }

    public static void main(String[] args) throws IOException {
        String srcPath = "src//copy_text_file//doc//src.txt";
        String destPath = "src//copy_text_file//doc//dest.txt";

        try {
            copyFile(srcPath,destPath);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
