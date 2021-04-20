package Greatest_Common_Divisor;

import java.util.Scanner;

public class Main {
    public int GCD(int a, int b){
        a = Math.abs(a);
        b = Math.abs(b);

        if (a == b)
            return a;

        if (a == 0 || b == 0){
            return 0;
        }
        else return (a > b)? GCD(a-b, b):GCD(a,b-a);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a: ");
        int a = sc.nextInt();

        System.out.print("Enter b: ");
        int b = sc.nextInt();

        if (new Main().GCD(a,b)== 0)
            System.out.println("No greatest common divisor!");
        else System.out.println("Greatest common divisor: " + new Main().GCD(a,b));
    }
}
