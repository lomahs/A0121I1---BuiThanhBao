package Convert_Number_To_Word;

import java.util.Scanner;

public class NumberToWord {
    public final String[] units = {
            "",
            "One",
            "Two",
            "Three",
            "Four",
            "Five",
            "Six",
            "Seven",
            "Eight",
            "Nine",
            "Ten",
            "Eleven",
            "Twelve",
            "Thirteen",
            "Fourteen",
            "Fifteen",
            "Sixteen",
            "Seventeen",
            "Eighteen",
            "Nineteen"
    };

    public final String[] tens = {
            "",
            "",
            "Twenty",
            "Thirty",
            "Forty",
            "Fifty",
            "Sixty",
            "Seventy",
            "Eighty",
            "Ninety"
    };

    public String convert(int num) {
        if (num < 20) {
            return units[num];
        }

        if (num < 100) {
            return tens[num / 10] + " " + units[num % 10];
        }

        if (num < 1000) {
            return units[num / 100] + " hundred " + ((num % 100 != 0) ? "and " + convert(num % 100) : "");
        }
        if (num < 1000000) {
            return convert(num / 1000) + " thousand " + ((num % 1000 != 0) ? convert(num % 1000) : "");
        }

        return convert(num / 1000000) + " million " + convert(num % 1000000);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int n = sc.nextInt();

        if (n == 0) {
            System.out.println("Zero");
        } else
            System.out.println(new NumberToWord().convert(n));
    }
}
