package insertionsort;

/**
 * Project: Exercise
 * Package: insertionsort
 * User: lomahs
 * Date time: 09/06/2021 17:46
 * Created with IntelliJ IDEA
 */
public class InsertionSort {

    public static void sort(int[] a){

        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            while (j>=0 && a[j] > key){
                a[j+1] = a[j];
                j--;
            }

            a[j+1] = key;
            System.out.printf("\nTime %d: ",i);
            displayArray(a);
        }
    }

    public static void displayArray(int[] a){
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int[] a = {4,8,6,1,9,34,6,5};

        System.out.print("Array: ");
        displayArray(a);
        sort(a);

        System.out.print("\nAfter sort: ");
        displayArray(a);
    }
}
