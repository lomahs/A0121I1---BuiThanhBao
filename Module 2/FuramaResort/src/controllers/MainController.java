package controllers;

import commons.io.csv.*;
import commons.validate.*;
import models.entity.Customer;
import models.entity.Employee;
import models.services.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * Project: FuramaResort
 * Package: controllers
 * User: lomahs
 * Date time: 19/06/2021 11:31
 * Created with IntelliJ IDEA
 */
public class MainController {
    CSVReader reader = new CSVReader();
    CSVWriter writer = new CSVWriter();

    ValidateInput validate = new ValidateInput();
    Checker checker = new Checker();

    ServiceManager serviceManager = new ServiceManager();
    CustomerManager customerManager = new CustomerManager();

    public void displayMainMenu() {
        while (true) {
            System.out.println("""
                    -*-*-FURAMA RESORT MANAGEMENT-*-*-
                    1. Add New Service
                    2. Show Service
                    3. Add New Customer
                    4. Show Information of Customer
                    5. Add New Booking
                    6. Show Information of Employee
                    7. Exit""");
            System.out.print("Your choice: ");
            int choice = validate.inputIntegerInRange(1, 7);

            switch (choice) {
                case 1 -> addNewService();
                case 2 -> showListService();
                case 3 -> addNewCustomer();
                case 4 -> showInformationCustomers();
                case 5 -> addNewBooking();
                case 6 -> showEmployee();
                default -> {
                    return;
                }
            }
        }
    }

    public void addNewService() {
        System.out.println("""
                                
                \t1. Add New Villa
                \t2. Add New House
                \t3. Add New Room
                \t4. Back to menu
                \t5. Exit""");
        System.out.print("Your choice: ");
        int choice = validate.inputIntegerInRange(1, 5);

        try {
            switch (choice) {
                case 1 -> {
                    Villa villa = (Villa) serviceManager.createNewService("villa");
                    writer.writeVila(villa);
                }
                case 2 -> {
                    House house = (House) serviceManager.createNewService("house");
                    writer.writeHouse(house);
                }
                case 3 -> {
                    Room room = (Room) serviceManager.createNewService("room");
                    writer.writeRoom(room);
                }
                case 4 -> displayMainMenu();
                default -> exit();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addNewCustomer() {
        Customer newCustomer = customerManager.createNewCustomer();

        if (newCustomer != null) {
            try {
                writer.writeCustomer(newCustomer);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void showInformationCustomers() {
        try {
            ArrayList<Customer> listCustomer = reader.readCustomerCSV();
            if (listCustomer.isEmpty()) {
                throw new NoSuchElementException("List Customer is empty");
            }

            System.out.printf("\t\t%-10s %-15s %-11s %-7s %-11s %-20s %-10s %-15s",
                    "ID",
                    "Name",
                    "Birthday",
                    "Gender",
                    "Phone",
                    "Email",
                    "Type Cus",
                    "Address\n");
            Collections.sort(listCustomer);
            listCustomer.forEach(Customer::showInfo);
            System.out.println();
        } catch (IOException | NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

    }

    public void showListService() {
        System.out.println("""
                                
                1.	Show all Villa
                2.	Show all House
                3.	Show all Room
                4.	Show All Name Villa Not Duplicate
                5.	Show All Name House Not Duplicate
                6.	Show All Name Name Not Duplicate
                7.	Back to menu
                8.	Exit""");

        System.out.print("Choice: ");
        int choice = validate.inputIntegerInRange(1, 8);

        switch (choice) {
            case 1 -> serviceManager.showService("villa");
            case 2 -> serviceManager.showService("house");
            case 3 -> serviceManager.showService("room");
            case 4 -> serviceManager.showNameService("villa");
            case 5 -> serviceManager.showNameService("house");
            case 6 -> serviceManager.showNameService("room");
            case 7 -> displayMainMenu();
            default -> exit();
        }
    }

    public void showEmployee(){
        try {
            HashMap<String, Employee> list = reader.readEmployeeCSV();

            System.out.printf("%-10s %-15s %-11s %-11s %-20s %-13s %-13s %-10s %-20s\n",
                "Id",
                "Name",
                "Birthday",
                "PhoneNumber",
                "Email",
                "Level",
                "Position",
                "Salary",
                "Department");

            list.values().forEach(Employee::showInfo);
            System.out.println();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }

    public void addNewBooking(){
        try {
            ArrayList<Customer> listCustomer = reader.readCustomerCSV();

            System.out.printf("\t\t%-13s %-15s %-11s %-7s %-11s %-20s %-10s %-15s %-10s\n",
                    "ID",
                    "Name",
                    "Birthday",
                    "Gender",
                    "Phone",
                    "Email",
                    "Type Cus",
                    "Address",
                    "Service");
            listCustomer.forEach(Customer::showInfo);

            System.out.print("\tEnter ID Customer booking: ");
            String id = validate.inputIDCustomer();

            while (!checker.isIDCustomerExist(id)){
                System.out.println("\t" + id + " is not exits!");
                id = validate.inputIDCustomer();
            }

            System.out.println("""
                    \t\t---BOOKING---
                    \t\t1. Booking Villa
                    \t\t2. Booking House
                    \t\t3. Booking Room
                    """);
            System.out.print("\t\tChoice: ");

            Services service;
            switch (validate.inputIntegerInRange(1,3)){
                case 1 -> service = serviceManager.chooseService("villa");
                case 2 -> service = serviceManager.chooseService("house");
                default -> service = serviceManager.chooseService("room");
            }

            Customer customer = customerManager.getCustomerByID(id);

            writer.writeBooking(new Booking(customer,service));
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void exit() {
        System.out.println("Thanks for using!!");
        System.exit(0);
    }
}
