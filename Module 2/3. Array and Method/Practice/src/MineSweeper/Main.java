package MineSweeper;

import java.util.Scanner;

public class Main {
    private static void inputBomb(int[][] a) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1 to set bomb, 0 means no bomb");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.printf("Bomb at [%d][%d]",i,j);
                a[i][j] = sc.nextInt();
            }
        }
    }

    private static int[][] createMap(int[][] a) {
        int[][] matrix = new int[a.length + 2][a[0].length + 2];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == 1) {
                    //Duyet qua cac cell xung quanh
                    for (int k = -1; k <= 1; k++) {
                        for (int l = -1; l <= 1; l++) {
                            if (k == 0 && l == 0) {
                                matrix[i + 1][j + 1] = -1;
                            } else if (matrix[i+k+1][j+l+1]!=-1)
                                matrix[i + k + 1][j + l + 1] += 1;
                        }
                    }

                }
            }
        }

        int[][] map = new int[a.length][a[0].length];

        for (int i = 1; i < matrix.length-1; i++) {
            for (int j = 1; j < matrix[0].length-1; j++) {
                map[i-1][j-1] = matrix[i][j];
            }
        }

        return map;
    }

    private static void displayMap(int[][] a){
        for (int[] ints : a) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(ints[j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter row of matrix: ");
        int row = sc.nextInt();

        System.out.print("Enter column of matrix: ");
        int col = sc.nextInt();

        int[][] bomb = new int[row][col];
        inputBomb(bomb);

        System.out.println("Bomb: ");
        displayMap(bomb);

        int[][] map = createMap(bomb);
        System.out.println("Map (-1 means bomb): ");
        displayMap(map);
    }
}
