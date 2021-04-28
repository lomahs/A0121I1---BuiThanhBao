package Array_Reverse;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size;

        do {
            System.out.print("Enter a size:");
            size = sc.nextInt();
            if (size > 20)
                System.out.println("Size does not exceed 20");
        } while (size > 20);

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Enter a[" + i + "]: ");
            array[i] = sc.nextInt();
        }

        System.out.print("Array: ");

        for (int i : array) {
            System.out.print(i + " ");
        }

        for (int j = 0; j < array.length / 2; j++) {
//            int temp = array[j];
//            array[j] = array[size - 1 - j];
//            array[size - 1 - j] = temp;

            array[j] = array[j] + (array[size - 1 - j] - (array[size - 1 - j] = array[j]));
        }

        System.out.print("\nReverse array: ");
        for (int i : array) {
            System.out.print(i + "\t");
        }
    }
}
