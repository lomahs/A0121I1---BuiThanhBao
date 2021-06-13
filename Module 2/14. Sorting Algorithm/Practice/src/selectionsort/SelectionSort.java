package selectionsort;

import java.util.Arrays;

/**
 * Project: Practice
 * Package: selectionsort
 * User: lomahs
 * Date time: 07/06/2021 19:03
 * Created with IntelliJ IDEA
 */
public class SelectionSort {
    static int[] arr = {3,6,8,1,3,2,0,4};

    public static void selectionSort(int[] lists){
        for (int i = 0; i < lists.length-1; i++) {

            int minIndex = i;

            for (int j = i+1; j < lists.length; j++) {
                if (lists[minIndex] > lists[j]){
                    minIndex = j;
                }
            }

            if (minIndex != i){
                lists[i] = lists[i] + lists[minIndex] - (lists[minIndex] = lists[i]);
            }
        }
    }

    public static void main(String[] args) {
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
