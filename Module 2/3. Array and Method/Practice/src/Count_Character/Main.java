package Count_Character;

import java.util.Scanner;

public class Main {
    public static int countChar(String s, char c){
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)== c){
                sum++;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = sc.nextLine();

        System.out.print("Enter character you want to count: ");
        char c = sc.nextLine().charAt(0);

        System.out.print("Number of " + c + ": " + countChar(s,c));
    }
}
