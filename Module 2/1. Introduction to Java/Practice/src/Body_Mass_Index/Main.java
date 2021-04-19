package Body_Mass_Index;

import java.util.Scanner;

public class Main {
    public void checkBMI(float weight, float height){
        float bmi = weight/(height*height);

        System.out.printf("%-20s%s", "bmi", "Interpretation\n");

        if (bmi < 18)
            System.out.printf("%-20.2f%s", bmi, "Underweight");
        else if (bmi < 25.0)
            System.out.printf("%-20.2f%s", bmi, "Normal");
        else if (bmi < 30.0)
            System.out.printf("%-20.2f%s", bmi, "Overweight");
        else
            System.out.printf("%-20.2f%s", bmi, "Obese");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Your weight (in kilogram):");
        float weight = sc.nextFloat();

        System.out.print("Your height (in meter):");
        float height = sc.nextFloat();

        new Main().checkBMI(weight,height);
    }
}
