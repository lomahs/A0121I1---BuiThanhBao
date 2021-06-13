package bigO;

import java.util.Scanner;

/**
 * Project: Practice
 * Package: bigO
 * User: lomahs
 * Date time: 07/06/2021 11:06
 * Created with IntelliJ IDEA
 */
public class AlgorithmComplexityTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        int[] frequentChar = new int[255];

        for (int i = 0; i < str.length(); i++) {
            int ascii = (int) str.charAt(i);

            frequentChar[ascii] +=1;
        }

        int max = 0;
        char character = (char) 255;

        for (int i = 0; i < 255; i++) {
            if (frequentChar[i] > max){
                max = frequentChar[i];
                character = (char) i;
            }
        }

        System.out.println("Letter " + character + " with " + max + " time!");
    }
}
