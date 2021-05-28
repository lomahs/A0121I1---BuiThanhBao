package optional.palindrome_bracketscheck;

import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String str = sc.nextLine();

        Check checkStr = new Check(str);

        System.out.println("Palindrome string: " + checkStr.checkPalindrome());
        System.out.println("Check brackets: " + checkStr.checkBrackets());

    }
}
