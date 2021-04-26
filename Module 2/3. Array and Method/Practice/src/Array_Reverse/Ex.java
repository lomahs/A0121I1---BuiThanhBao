package Array_Reverse;

import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap x: ");
        int x = sc.nextInt();

        System.out.print("Nhap y: ");
        int y = sc.nextInt();

        if (x > 300 || y > 300){
            System.out.println("Duong Le Duan khong co qua 300 ngoi nha");
        } else {
            int count = 0;

            for (int i = x; i <= y; i++) {
                if (i % 5 ==0){
                    count++;
                }
            }

            if (count >= 10){
                System.out.println("Anh xin loi...");
            } else{
                for (int i = x; i <= y; i++) {
                    if (i % 5 ==0){
                        System.out.print(i + " ");
                    }
                }
            }
        }

    }
}
