package optional.convertbase;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Convert().convertDecToBin(10));

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter decimal number: ");
        int decNum = sc.nextInt();

        System.out.println("Convert to base Bin: " + new Convert().convertDecToBin(decNum));
    }
}
