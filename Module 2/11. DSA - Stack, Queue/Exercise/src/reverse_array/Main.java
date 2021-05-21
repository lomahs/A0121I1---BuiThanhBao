package reverse_array;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of element: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Nhap a[" + i + "]: ");
            arr[i] = sc.nextInt();
            stack.push(arr[i]);
        }

        System.out.print("Array is reverse order: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + "  ");
        }

        sc.nextLine();
        System.out.print("\nEnter string: ");
        String str = sc.nextLine();

        Stack<Character> stack2 = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack2.push(str.charAt(i));
        }

        System.out.print("String is reverse order: ");
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop());
        }
    }
}
