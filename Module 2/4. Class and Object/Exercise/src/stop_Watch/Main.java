package stop_Watch;

import java.util.Random;
import java.util.Scanner;

public class Main {
    //Randomize number in range from min to max
    public static int randomize(int min, int max) {
        Random rd = new Random();
        return rd.nextInt((max - min) + 1) + min;
    }

    //Randomize numbers for array
    public static void generateArray(int[] a){
        for (int i = 0; i < a.length; i++) {
            a[i] = randomize(-1000, 1000);
        }
    }

    public static void selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {

            int min = a[i];
            int posMin = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < min) {
                    min = a[j];
                    posMin = j;
                }
            }
            int temp = a[i];
            a[i] = a[posMin];
            a[posMin] = temp;
        }
    }

    public static void displayArray(int[] a){
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of element: ");
        int n = sc.nextInt();

        int[] a = new int[n];

        generateArray(a);

        System.out.print("Array: ");
        displayArray(a);
        System.out.println();

        StopWatch watch = new StopWatch();

        watch.start();
        System.out.println("Start " + watch.startTime);

        selectionSort(a);

        watch.stop();

        System.out.print("Array after sort: ");
        displayArray(a);

        System.out.println("\nEnd " + watch.endTime);
        System.out.println("Time sort: "+ watch.getElapsedTime());

    }
}
