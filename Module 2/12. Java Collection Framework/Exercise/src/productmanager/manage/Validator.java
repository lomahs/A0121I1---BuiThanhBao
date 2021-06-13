package productmanager.manage;

import java.util.Scanner;

/**
 * Project: Exercise
 * Package: productmanager
 * User: lomahs
 * Date time: 31/05/2021 00:32
 * Created with IntelliJ IDEA
 */
public class Validator {

    public String inputString(){
        Scanner sc = new Scanner(System.in);

        while (true){
            String str = sc.nextLine().trim();
            if (str.isEmpty()){
                System.out.println("Not empty!");
                System.out.print("Enter again: ");
            }else {
                return str;
            }
        }
    }

    public double inputDouble(){
        Scanner sc = new Scanner(System.in);

        while (true){
            try {
                double num = Double.parseDouble(sc.nextLine().trim());
                if (num<0){
                    throw new NumberFormatException();
                }
                return num;
            }catch (NumberFormatException e){
                System.out.println("Input number (>0)!");
                System.out.print("Enter again: ");
            }
        }
    }
}
