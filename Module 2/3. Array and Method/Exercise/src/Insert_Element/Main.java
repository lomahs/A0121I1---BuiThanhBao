package Insert_Element;

import java.util.Scanner;

public class Main {
    public static boolean insertElement(int[] a, int value, int index){
        for (int i = a.length-1; i > index; i--) {
            a[i] = a[i - 1];
        }
        a[index] = value;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of element: ");
        int n = sc.nextInt();

        int[] a = new int[n+1];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter a[" + i + "]: ");
            a[i] = sc.nextInt();
        }

        System.out.print("Enter number you want to insert: ");
        int value = sc.nextInt();

        System.out.print("Enter index you want to insert:");
        int index = sc.nextInt();

        if (insertElement(a,value,index)){
            System.out.println("Insert successfully");
        }else{
            System.out.println(value + " isn't exist");
        }

        System.out.print("Array after insert: ");
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
