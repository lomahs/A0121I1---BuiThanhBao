package Array_Reverse;

public class Find_Smallest {
    public static int minValue(int[] array){
        int min = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[min] > array[i])
                min = i;
        }
        return min;
    }

    public static void main(String[] args) {
        int []arr = {4, 12, 7, 8, 1, 6, 9};
        int index = minValue(arr);
        System.out.println("The smallest element in the array is: " + arr[index]);
    }
}
