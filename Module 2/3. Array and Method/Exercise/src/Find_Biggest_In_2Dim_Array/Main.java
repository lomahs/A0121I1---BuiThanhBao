package Find_Biggest_In_2Dim_Array;

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

    public static int[] findBiggest(int[][] a){
        int rowMax = 0;
        int colMax = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[rowMax][colMax] < a[i][j]){
                    rowMax = i;
                    colMax = j;
                }
            }
        }

        return new int[]{rowMax, colMax, a[rowMax][colMax]};
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

        int rowMax = findBiggest(a)[0];
        int colMax = findBiggest(a)[1];
        int max = findBiggest(a)[2];
        System.out.printf("Biggest value: %d in row %d and column %d", max, rowMax, colMax);
    }
}
