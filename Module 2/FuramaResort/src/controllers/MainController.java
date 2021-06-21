package controllers;

import models.House;
import models.Room;
import models.Services;
import models.Villa;
import models.io.csv.CSVReader;
import models.io.csv.CSVWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Project: FuramaResort
 * Package: controllers
 * User: lomahs
 * Date time: 19/06/2021 11:31
 * Created with IntelliJ IDEA
 */
public class MainController {
    private final Scanner sc = new Scanner(System.in);
    public CSVWriter writer = new CSVWriter();
    public CSVReader reader = new CSVReader();

    public void displayMainMenu(){
        while (true) {
            System.out.println("""
                    1. Add New Service
                    2. Show Service
                    3. Add New Customer
                    4. Show Information of Customer
                    5. Add New Booking
                    6. Show Information of Employee
                    7. Exit""");
            System.out.print("Your choice: ");
            int choice = sc.nextInt();
            sc.skip("\n");

            switch (choice){
                case 1:
                    addNewService();
                    break;
                case 2:
                    showServices();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    exit();
            }
        }
    }

    private void addNewService() {
        System.out.println("""
                \t1. Add New Villa
                \t2. Add New House
                \t3. Add New Room
                \t4. Back to menu
                \t5. Exit""");
        System.out.print("Your choice: ");
        int choice = sc.nextInt();
        sc.skip("\n");

        try {
            switch (choice) {
                case 1 -> {
                    Villa villa = (Villa) createNewService("villa");
                    writer.writeToVillaCSV(villa);
                }
                case 2 -> {
                    House house = (House) createNewService("house");
                    writer.writeToHouseCSV(house);
                }
                case 3 -> {
                    Room room = (Room) createNewService("room");
                    writer.writeToRoomCSV(room);
                }
                case 4 -> displayMainMenu();
                default -> exit();
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public Services createNewService(String service){
        System.out.printf("\t\t---ADD NEW %s---\n",service.toLowerCase());

        System.out.print("\t\tID: ");
        String id = sc.nextLine();

        System.out.print("\t\tName Service: ");
        String name = sc.nextLine();

        System.out.print("\t\tUsable Area: ");
        double area = sc.nextDouble();

        System.out.print("\t\tRental Cost: ");
        long cost = sc.nextLong();

        System.out.print("\t\tMaximum Number Of Guest: ");
        int numGuest = sc.nextInt();

        System.out.println("\t\tChoose Rental Type: ");
        System.out.println("""
                \t\t\t1. Year
                \t\t\t2. Month
                \t\t\t3. Day
                \t\t\t4. Hour""");
        System.out.print("\t\tChoice: ");
        int rentalType = sc.nextInt();
        sc.skip("\n");

        switch (service) {
            case "villa" -> {
                System.out.print("\t\tStandard: ");
                String standard = sc.nextLine();

                System.out.print("\t\tDescription of other amenities: ");
                String amenities = sc.nextLine();

                System.out.print("\t\tNumber Of Floor: ");
                int numFloor = sc.nextInt();

                System.out.print("\t\tPool's Area: ");
                double poolArea = sc.nextDouble();

                return new Villa(id, name, area, cost, numGuest, rentalType, standard, amenities, numFloor, poolArea);
            }
            case "house" -> {
                System.out.print("\t\tStandard: ");
                String standard = sc.nextLine();

                System.out.print("\t\tDescription of other amenities: ");
                String amenities = sc.nextLine();

                System.out.print("\t\tNumber Of Floor: ");
                int numFloor = sc.nextInt();

                return new House(id, name, area, cost, numGuest, rentalType, standard, amenities, numFloor);

            }
            case "room" -> {
                System.out.print("\t\tFree Services: ");
                String freeServices = sc.nextLine();

                return new Room(id, name, area, cost, numGuest, rentalType, freeServices);
            }
        }
        return null;
    }

    public void showServices(){
        System.out.println("""
                1.	Show all Villa
                2.	Show all House
                3.	Show all Room
                4.	Show All Name Villa Not Duplicate
                5.	Show All Name House Not Duplicate
                6.	Show All Name Name Not Duplicate
                7.	Back to menu
                8.	Exit
                """);

        System.out.print("Choice: ");
        int choice = sc.nextInt();
        sc.skip("\n");

        switch(choice){
            case 1 -> show("villa");
            case 2 -> show("house");
            case 3 -> show("room");
            case 7 -> displayMainMenu();
            default -> exit();
        }
    }

    public void show(String service){
        try {
            if (service.equals("villa")) {
                ArrayList<Villa> listVilla = reader.readVillaCSV();

                if (listVilla.isEmpty()){
                    throw new NoSuchElementException("List Villa is empty");
                }

                listVilla.forEach(Villa::showInfo);
            } else if (service.equals("house")) {
                ArrayList<House> listHouse = reader.readHouseCSV();

                if (listHouse.isEmpty()){
                    throw new NoSuchElementException("List House is empty");
                }

                listHouse.forEach(House::showInfo);
            } else {
                ArrayList<Room> listRooms = reader.readRoomCSV();

                if (listRooms.isEmpty()){
                    throw new NoSuchElementException("List Room is empty");
                }

                listRooms.forEach(Room::showInfo);
            }
        }catch (IOException | NoSuchElementException e){
            System.out.println(e.getMessage());
        }
    }

    public void exit(){
        System.out.println("Thanks for using!!");
        System.exit(0);
    }
}
