package Remove_Element;

import java.util.Scanner;

public class Main {
    public static boolean removeElement(int[] a, int value){
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == value){
                for (int j = i; j < a.length - 1; j++) {
                    a[j] = a[j + 1];
                }
                a[a.length-1-count] = 0;
                count++;
            }
        }

        return count != 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of element: ");
        int n = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter a[" + i + "]: ");
            a[i] = sc.nextInt();
        }

        System.out.print("Enter number you want to remove: ");
        int value = sc.nextInt();

        if (removeElement(a,value)){
            System.out.println("Remove successfully");
        }else{
            System.out.println(value + " isn't exist");
        }

        System.out.print("Array after remove: ");
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
