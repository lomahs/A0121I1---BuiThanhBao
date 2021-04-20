package Show_Primes;

import java.util.Scanner;

public class Main {
    public boolean isPrime(int n){
        if (n < 2)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of Primes you want to show: ");
        int n = sc.nextInt();
        int i = 2;
        while (n > 0){
            if (new Main().isPrime(i)){
                System.out.print(i + " ");
                n--;
            }
            i++;
        }
    }
}
