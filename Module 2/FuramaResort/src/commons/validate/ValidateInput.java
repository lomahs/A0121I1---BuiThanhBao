package commons.validate;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * Project: FuramaResort
 * Package: commons.validate
 * User: lomahs
 * Date time: 21/06/2021 20:49
 * Created with IntelliJ IDEA
 */

public class ValidateInput {

    final String ID_SERVICE_REGEX = "^SV(VL|HD|RO)-[0-9]{4}$";
    final String STRING_REGEX = "^[A-Z][a-z\\s]*";
    final double MIN_AREA = 30;
    final int MIN_AGE = 18;
    final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    final String EMAIL_REGEX = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
    final String NAME_REGEX = "([A-Z][a-z]*\\s)*([A-Z][a-z]*)";
    final String ID_CUSTOMER_REGEX = "([\\d]{3}\\s){2}[\\d]{3}";
    final String PHONE_NUMBER_REGEX = "^0[\\d]{9}$";

    private final Scanner sc = new Scanner(System.in);

    public String inputIDService() {

        while (true) {
            try {
                String id = sc.nextLine();

                if (!id.matches(ID_SERVICE_REGEX)) {
                    throw new Exception("ID must match SVXX-YYYY");
                } else {
                    return id;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.print("\t\tEnter again: ");
            }
        }
    }

    public String inputString() {

        while (true) {
            try {
                String str = sc.nextLine();

                if (!str.matches(STRING_REGEX)) {
                    throw new Exception("First character must be capitalized and not a number");
                } else {
                    return str;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.print("\t\tEnter again: ");
            }
        }
    }

    public double inputArea() {

        while (true) {
            try {
                double area = Double.parseDouble(sc.nextLine());

                if (area > MIN_AREA) {
                    return area;
                } else {
                    throw new Exception("Area must be a number bigger than 30");
                }
            } catch (NumberFormatException e){
                System.out.println("Please enter a number!");
                System.out.print("\t\tEnter again: ");
            }catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.print("\t\tEnter again: ");
            }
        }
    }

    public int inputIntegerInRange(int min, int max) {

        while (true) {
            try {
                int num = Integer.parseInt(sc.nextLine());

                if (num >= min && num <= max) {
                    return num;
                } else {
                    throw new Exception("Number must be in range " + min + " - " + max);
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number! ");
                System.out.print("Enter again: ");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.print("\t\tEnter again: ");
            }
        }
    }

    public LocalDate inputBirthday() throws Exception {
        while (true) {
            try {
                LocalDate birthday = LocalDate.parse(sc.nextLine(), dateFormatter);

                if (Period.between(birthday, LocalDate.now()).getYears() >= MIN_AGE
                        && birthday.getYear() > 1900) {
                    return birthday;
                } else {
                    throw new Exception("Requires over 18 years old and year after 1900!");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Please enter date with format dd/MM/yyyy");
                System.out.print("\t\tEnter again: ");
            }
        }
    }

    public String inputEmail() {
        while (true) {
            try {
                String email = sc.nextLine();

                if (email.matches(EMAIL_REGEX)) {
                    return email;
                } else {
                    throw new Exception("Email must match the format abc@abc.abc");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.print("\t\tEnter again: ");
            }
        }
    }

    public String inputName() {
        while (true) {
            try {
                String name = sc.nextLine();

                if (name.matches(NAME_REGEX)) {
                    return name;
                } else {
                    throw new Exception("Name must be capitalize the first character in each word!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.print("\t\tEnter again: ");
            }
        }
    }

    public String inputIDCustomer() {
        while (true) {
            try {
                String id = sc.nextLine();

                if (id.matches(ID_CUSTOMER_REGEX)) {
                    return id;
                } else {
                    throw new Exception("ID Card must have 9 digits and match XXX XXX XXX");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.print("\t\tEnter again: ");
            }
        }
    }

    public String inputPhoneNumber() {
        while (true) {
            try {
                String id = sc.nextLine();

                if (id.matches(PHONE_NUMBER_REGEX)) {
                    return id;
                } else {
                    throw new Exception("Phone number must match 0XXXXXXXXX");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.print("\t\tEnter again: ");
            }
        }
    }
}
