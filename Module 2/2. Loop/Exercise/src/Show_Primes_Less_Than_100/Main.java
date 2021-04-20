package Show_Primes_Less_Than_100;


import java.util.Arrays;

public class Main {
    public boolean[] eratosthenes(int n) {
        boolean[] a = new boolean[n+1];

        Arrays.fill(a, true);

        a[0] = a[1] = false;

        for (int i = 2; i*i <= n; i++) {
            if (a[i]) {
                for (int j = i * i; j <= n; j += i) {
                    a[j] = false;
                }
            }
        }

        return a;
    }

    static int m(int...x) {
        int b = 0;
        for(int a:x){
            b+=a;
        }
        return b;
    }

    public static void main(String[] args) {
//        boolean[] eratosthenes = new Main().eratosthenes(100);
//
//        System.out.println("Prime numbers less than 100: ");
//        for (int i = 0; i <= 100; i++) {
//            if (eratosthenes[i])
//                System.out.print(i + " ");
//        }

        System.out.println(m(1,2,3));
    }
}
