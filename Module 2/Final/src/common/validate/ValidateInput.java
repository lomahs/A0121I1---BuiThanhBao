package common.validate;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * Project: FuramaResort
 * Package: commons.validate
 * User: lomahs
 * Date time: 21/06/2021 20:49
 * Created with IntelliJ IDEA
 */

public class ValidateInput {

    final String MASP_REGEX = "^SP[\\d]{5}$";
    final String STRING_REGEX = "[\\w\\s]+";

    private final Scanner sc = new Scanner(System.in);

    public String inputYesNo(){

        while (true) {
            try {
                String str = sc.nextLine();

                if (str.equalsIgnoreCase("yes")){
                    return str;
                }else if (str.equalsIgnoreCase("no")){
                    return str;
                }else {
                    throw new Exception("Please input Yes or No!!");
                }
            }catch (Exception e ){
                System.out.println(e.getMessage());
                System.out.print("\t\tEnter again: ");
            }
        }
    }

    public int inputPrice(){

        while (true) {
            try {
                int num = Integer.parseInt(sc.nextLine());

                if (num >= 0) {
                    return num;
                } else {
                    throw new Exception("Price must be bigger than 0");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number! ");
                System.out.print("Enter again: ");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.print("\t\tEnter again: ");
            }
        }
    }

    public String inputMaSP() {

        while (true) {
            try {
                String id = sc.nextLine();

                if (!id.matches(MASP_REGEX)) {
                    throw new Exception("Ma san pham phai theo mau SPXXXXX (X la 1 so)!!");
                } else {
                    return id;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.print("\tEnter again: ");
            }
        }
    }

    public String inputString() {

        while (true) {
            try {
                String str = sc.nextLine();

                if (!str.matches(STRING_REGEX)) {
                    throw new Exception("Khong nen de trong");
                } else {
                    return str;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.print("\tEnter again: ");
            }
        }
    }

    public int inputIntegerInRange(int min, int max) {

        while (true) {
            try {
                int num = Integer.parseInt(sc.nextLine());

                if (num >= min && num <= max) {
                    return num;
                } else {
                    throw new Exception("Number must be in range " + min + " - " + max);
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number! ");
                System.out.print("Enter again: ");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.print("\tEnter again: ");
            }
        }
    }
}
