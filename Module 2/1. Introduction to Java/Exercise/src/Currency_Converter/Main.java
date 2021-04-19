package Currency_Converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rate = 23000;

        System.out.print("Enter USD: ");
        float usd = sc.nextFloat();

        System.out.println("Vietnam dong: " + usd*rate + "đ");
    }
}
