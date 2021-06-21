package validate_classname;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Project: Exercise
 * Package: validate_classname
 * User: lomahs
 * Date time: 18/06/2021 18:30
 * Created with IntelliJ IDEA
 */
public class ClassNameValidate {
    private final String CLASS_NAME_REG = "^[CAP][\\d]{4}[GHIKLM]";
    private final Pattern pattern = Pattern.compile(CLASS_NAME_REG);

    public void checkClassName(String className) {
        Matcher matcher = pattern.matcher(className);

        if (!matcher.matches()) {
            System.out.println(className + " is invalid");
        } else
            System.out.println(className + " is valid");
    }

    public static void main(String[] args) {
        String[] invalidClassName = {"A001G", "D0123G", "P0123A", "12345"};
        String[] validClassName = {"A1111G", "C0000H", "P1212M", "A0987L"};

        for (String s : validClassName) {
            new ClassNameValidate().checkClassName(s);
        }

        for (String s : invalidClassName) {
            new ClassNameValidate().checkClassName(s);
        }

    }
}
