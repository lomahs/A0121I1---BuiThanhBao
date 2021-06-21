package validate_account;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Project: Practice
 * Package: validate_account
 * User: lomahs
 * Date time: 18/06/2021 17:27
 * Created with IntelliJ IDEA
 */
public class Validate {
    private final String ACCOUNT_REG = "^[_a-z0-9]{6,}$";
    private final Pattern pattern = Pattern.compile(ACCOUNT_REG);

    public void checkAccount(String account) throws Exception {
        Matcher matcher = pattern.matcher(account);

        if (matcher.matches()){
            System.out.println("Valid account");
        }else {
            throw new Exception("Invalid account");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your account: ");
        String str = sc.nextLine();

        try {
            new Validate().checkAccount(str);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
