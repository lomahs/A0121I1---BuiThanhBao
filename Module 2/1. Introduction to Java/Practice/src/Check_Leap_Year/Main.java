package Check_Leap_Year;

import java.util.Scanner;

public class Main {
    public boolean isLeapYear(int year){
        return (year % 4 ==0 && year % 100 !=0) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter year: " );
        int year = sc.nextInt();

        if (new Main().isLeapYear(year))
            System.out.println(year + " is leap year!");
        else System.out.println(year + " is not leap year!");
    }
}
