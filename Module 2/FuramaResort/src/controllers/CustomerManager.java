package controllers;

import commons.io.csv.CSVReader;
import commons.validate.Checker;
import commons.validate.ValidateInput;
import models.entity.Customer;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Project: FuramaResort
 * Package: controllers
 * User: lomahs
 * Date time: 23/06/2021 10:39
 * Created with IntelliJ IDEA
 */
public class CustomerManager {
    ValidateInput validate = new ValidateInput();
    Checker checker = new Checker();

    CSVReader reader = new CSVReader();

    public Customer createNewCustomer(){
        System.out.println("\t\t---ADD NEW CUSTOMER---");

        System.out.print("\t\tID: ");
        String id = validate.inputIDCustomer();
        while (checker.isIDCustomerExist(id)){
            System.out.println("\tID " + id + " is exist!!");
            System.out.print("\t\tEnter again: ");
            id = validate.inputIDCustomer();
        }

        System.out.print("\t\tName: ");
        String name = validate.inputName();

        System.out.print("\t\tBirthday: ");
        LocalDate birthday;
        try {
            birthday = validate.inputBirthday();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

        System.out.println("\t\tGender: ");
        System.out.println("\t\t\t1. Male");
        System.out.println("\t\t\t2. Female");
        System.out.println("\t\t\t3. Other");
        System.out.print("\t\tChoice: ");
        String gender;
        switch (validate.inputIntegerInRange(1,3)){
            case 1 -> gender ="Male";
            case 2 -> gender = "Female";
            default -> gender = "Other";
        }

        System.out.print("\t\tPhone number: ");
        String phoneNumber = validate.inputPhoneNumber();

        System.out.print("\t\tEmail: ");
        String email = validate.inputEmail();

        System.out.println("\t\tType Customer: ");
        System.out.println("\t\t\t1. Member");
        System.out.println("\t\t\t2. Silver");
        System.out.println("\t\t\t3. Gold");
        System.out.println("\t\t\t4. Platinum");
        System.out.println("\t\t\t5. Diamond");
        System.out.print("\t\tChoice: ");
        int typeCus = validate.inputIntegerInRange(1,5);

        System.out.print("\t\tAddress: ");
        String address = validate.inputName();

        return new Customer(id,name,birthday,gender,phoneNumber,email,typeCus,address);
    }

    public Customer getCustomerByID(String id){
        try {
            ArrayList<Customer> listCustomer = reader.readCustomerCSV();

            for (Customer customer : listCustomer) {
                if (customer.getId().equals(id)){
                    return customer;
                }
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        return null;
    }
}
