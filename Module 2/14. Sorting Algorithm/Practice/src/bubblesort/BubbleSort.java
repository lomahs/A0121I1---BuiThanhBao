package bubblesort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Project: Practice
 * Package: bubblesort
 * User: lomahs
 * Date time: 07/06/2021 18:35
 * Created with IntelliJ IDEA
 */
public class BubbleSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter list size: ");
        int size = sc.nextInt();
        int[] list = new int[size];

        for (int i = 0; i < list.length; i++) {
            list[i] = sc.nextInt();
        }

        System.out.print("Your list: ");
        for (int i : list) {
            System.out.print(i + " ");
        }

        bubbleSort(list);

        System.out.print("\nList after sort: ");
        Arrays.stream(list).forEach(value -> System.out.print(value + " "));
    }

    public static void bubbleSort(int[] list){
        boolean needNextPass = true;

        for (int i = 1; i < list.length; i++) {
            needNextPass = false;

            for (int j = 0; j < list.length - i; j++) {
                if (list[j] > list[j+1]){
                    list[j] = (list[j] + list[j+1]) - (list[j+1] = list[j]);

                    needNextPass = true;
                }
            }

            if (!needNextPass){
                break;
            }
        }
    }
}
