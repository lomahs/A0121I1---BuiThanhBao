package validate_phoneNumber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Project: Exercise
 * Package: validate_phoneNumber
 * User: lomahs
 * Date time: 18/06/2021 18:46
 * Created with IntelliJ IDEA
 */
public class PhoneNumberValidate {
    private final String PHONE_REG = "^[(][\\d]{2}[)]-[(][0][\\d]{9}[)]";
    private final Pattern pattern = Pattern.compile(PHONE_REG);

    public void checkPhoneNumber(String phoneNumber){
        Matcher matcher = pattern.matcher(phoneNumber);

        if (matcher.matches()){
            System.out.println(phoneNumber+ " is valid");
        }else {
            System.out.println(phoneNumber+ " is invalid");
        }
    }

    public static void main(String[] args) {
        String[] phoneNumbers = {"(84)-(0123456789)","(31)-(1234567899)","(a2)-(123123)","(00)-(0111222333)","01234567"};

        for (String phoneNumber : phoneNumbers) {
            new PhoneNumberValidate().checkPhoneNumber(phoneNumber);
        }
    }
}
