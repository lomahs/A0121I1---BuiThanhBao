package Check_Prime_Number;

import java.util.Scanner;

public class Main {
    public boolean isPrime(int n){
        if(n<2)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        if (new Main().isPrime(n))
            System.out.println(n + " is Prime!");
        else System.out.println(n + " is not Prime");


    }
}
