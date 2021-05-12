package triangledesign;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter side 1: ");
        double side1 = sc.nextDouble();

        System.out.print("Enter side 2: ");
        double side2 = sc.nextDouble();

        System.out.print("Enter side 3: ");
        double side3 = sc.nextDouble();

        sc.nextLine();

        System.out.print("Enter color of Triangle: ");
        String color = sc.nextLine();

        Triangle a = new Triangle(side1, side2, side3);
        a.setColor(color);

        System.out.println(a.toString());
    }
}
