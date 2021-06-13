package binarysearch;

import java.util.Scanner;

/**
 * Project: Exercise
 * Package: binarysearch
 * User: lomahs
 * Date time: 04/06/2021 20:19
 * Created with IntelliJ IDEA
 */
public class BinarySearch {

    public int binarySearch(int[] array, int left, int right, int value) {

        if (left > right) {
            return -1;
        } else {

            int mid = (left + right) / 2;
            if (array[mid] == value) {
                return mid;
            } else if (array[mid] > value) {
                return binarySearch(array, left, mid - 1, value);
            } else {
                return binarySearch(array, mid + 1, right, value);
            }
        }
    }

    public void sortArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        int[] arr = new int[n];


        for (int i = 0; i < n; i++) {
            System.out.print("Enter a[" + i + "]: ");
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter value to find: ");
        int value = sc.nextInt();

        new BinarySearch().sortArray(arr);
        System.out.print("Array:" );
        for (int i : arr) {
            System.out.print(i + " ");
        }

        int index = new BinarySearch().binarySearch(arr, 0, n - 1, value);

        if (index == -1) {
            System.out.println("\nCannot find " + value);
        } else {
            System.out.println("\n" + value + " is in index " + index);
        }


    }


}
