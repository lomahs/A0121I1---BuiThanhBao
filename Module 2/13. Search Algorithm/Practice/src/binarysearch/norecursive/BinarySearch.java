package binarysearch.norecursive;

/**
 * Project: Practice
 * Package: binarysearch.binarysearch.norecursive
 * User: lomahs
 * Date time: 07/06/2021 10:16
 * Created with IntelliJ IDEA
 */
public class BinarySearch {
    static int[] list = {2,4,7,10,11,25,40,55,58,69,70,79,95,101};

    static int binarySearch(int[] list, int key){
        int low = 0;
        int high = list.length - 1;

        while (high>=low){
            int middle = (low + high)/2;

            if (list[middle] == key){
                return middle;
            }else if (list[middle] < key){
                low = middle +1;
            }else {
                high = middle -1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(list,11));
        System.out.println(binarySearch(list,69));
        System.out.println(binarySearch(list,101));
        System.out.println(binarySearch(list,5));
    }
}
