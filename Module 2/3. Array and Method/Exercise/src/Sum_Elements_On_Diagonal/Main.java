package Sum_Elements_On_Diagonal;

import java.util.Scanner;

public class Main {
    public static void inputArray(int[][] a){
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.printf("Enter a[%d][%d]: ",i,j);
                a[i][j] = sc.nextInt();
            }
        }
    }

    public static void displayArray(int[][] a){
        for (int[] ints : a) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public static int sumDiagonal(int[][] a){
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum+= a[i][i];
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of square matrix: ");
        int size = sc.nextInt();

        int[][] a = new int[size][size];

        inputArray(a);

        System.out.println("Matrix:");
        displayArray(a);

        System.out.println("Sum elements of diagonal: " + sumDiagonal(a));
    }
}
