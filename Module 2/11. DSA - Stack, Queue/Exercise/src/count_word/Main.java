package count_word;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.print("Enter long string: ");
        String str = new Scanner(System.in).nextLine();

        CountWord countWord = new CountWord(str);
        countWord.displayMap();
    }
}
