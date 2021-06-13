package max_ordered_subsequence.noconsecutive;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Project: Exercise
 * Package: max_ordered_subsequence
 * User: lomahs
 * Date time: 07/06/2021 10:45
 * Created with IntelliJ IDEA
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        LinkedList<Character> max = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            LinkedList<Character> list = new LinkedList<>();

            list.add(str.charAt(i));

            for (int j = i+1; j < str.length(); j++) {
                if (str.charAt(j) > list.getLast()){
                    list.add(str.charAt(j));
                }
            }

            if (list.size() > max.size()){
                max.clear();
                max.addAll(list);
            }

            list.clear();
        }

        for (Character ch :max){
            System.out.print(ch);
        }
    }

}
