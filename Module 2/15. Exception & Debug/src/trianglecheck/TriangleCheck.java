package trianglecheck;

import java.util.Scanner;

/**
 * Project: 15. Exception & Debug
 * Package: trianglecheck
 * User: lomahs
 * Date time: 11/06/2021 18:11
 * Created with IntelliJ IDEA
 */
public class TriangleCheck {

    public static void checkTriangle(int a, int b, int c) throws IllegalTriangleException {
        if (a <= 0 || b <= 0 || c <= 0 || a + b <= c || b + c <= a || a + c <= b) {
            throw new IllegalTriangleException("Illegal Triangle");
        }

        System.out.println("Legal Triangle");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter side a, b, c: ");
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            checkTriangle(a, b, c);
        } catch (IllegalTriangleException e) {
            System.out.println(e.getMessage());
        }
    }
}
