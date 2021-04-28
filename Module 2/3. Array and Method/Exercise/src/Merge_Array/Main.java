package Merge_Array;

import java.util.Scanner;

public class Main {
    public static void inputArray(int[] a){
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < a.length; i++) {
            System.out.printf("Enter a[%d]: ",i);
            a[i] = sc.nextInt();
        }
    }
    
    public static void displayArray(int[] a){
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    public static int[] mergeArray(int[] a, int[] b){
        int[] result = new int[a.length + b.length];
        int i = 0;

        for (int value : a) {
            result[i++] = value;
        }

        for (int value : b) {
            result[i++] = value;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of element of array 1: ");
        int size1 = sc.nextInt();
        int[] a1 = new int[size1];

        inputArray(a1);

        System.out.print("Enter number of element of array 2: ");
        int size2 = sc.nextInt();
        int[] a2 = new int[size2];

        inputArray(a2);

        int[] a3 = mergeArray(a1, a2);

        System.out.print("Array 1: ");
        displayArray(a1);
        System.out.println();

        System.out.print("Array 2: ");
        displayArray(a2);
        System.out.println();

        System.out.print("Merge two array: ");
        displayArray(a3);
    }
}
