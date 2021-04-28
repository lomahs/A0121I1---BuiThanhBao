package Sum_Elements_At_Specific_Column;

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

    public static int sumCol(int[][] a, int col){
        int sum =0;
        for (int i = 0; i < a.length; i++) {
            sum+=a[i][col];
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter row of matrix: ");
        int row = sc.nextInt();

        System.out.print("Enter column of matrix: ");
        int column = sc.nextInt();

        int[][] a = new int[row][column];

        inputArray(a);

        System.out.println("Matrix:");
        displayArray(a);

        System.out.print("Enter column: ");
        int col = sc.nextInt();

        System.out.printf("Sum of elements at column %d: %d", col,sumCol(a,col));
    }
}
