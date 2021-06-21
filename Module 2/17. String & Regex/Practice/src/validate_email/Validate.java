package validate_email;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Project: Practice
 * Package: validate_email
 * User: lomahs
 * Date time: 17/06/2021 11:02
 * Created with IntelliJ IDEA
 */
public class Validate {
    private final String EMAIL_REG = "^[a-zA-Z][\\w]+@[\\w]+.[\\w]+";
    private final Pattern pattern = Pattern.compile(EMAIL_REG);

    public void validateEmail(String email) throws Exception {
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches()){
            System.out.println("Valid email");
        }else {
            throw new Exception("Invalid email");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your email: ");
        String str = sc.nextLine();

        try {
            new Validate().validateEmail(str);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
