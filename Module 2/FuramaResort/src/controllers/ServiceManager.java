package controllers;

import commons.io.csv.CSVReader;
import commons.validate.Checker;
import commons.validate.ValidateInput;
import models.services.House;
import models.services.Room;
import models.services.Services;
import models.services.Villa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.TreeSet;

/**
 * Project: FuramaResort
 * Package: controllers
 * User: lomahs
 * Date time: 23/06/2021 12:13
 * Created with IntelliJ IDEA
 */
public class ServiceManager {
    CSVReader reader = new CSVReader();

    ValidateInput validate = new ValidateInput();
    Checker checker = new Checker();

    public Services getServiceByID(String id) throws Exception {
        try {
            ArrayList<Villa> villa = reader.readVillaCSV();
            ArrayList<House> house = reader.readHouseCSV();
            ArrayList<Room> room = reader.readRoomCSV();

            for (Villa service : villa) {
                if (service.getIdService().equals(id)){
                    return service;
                }
            }

            for (House service : house) {
                if (service.getIdService().equals(id)){
                    return service;
                }
            }

            for (Room service : room) {
                if (service.getIdService().equals(id)){
                    return service;
                }
            }

            throw new Exception("Id is not exist");

        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        return null;
    }

    public Services createNewService(String service) {
        System.out.printf("\t\t---ADD NEW %s---\n", service.toUpperCase());


        System.out.print("\t\tID: ");
        String id;
        while (true) {
            try {
                id = validate.inputIDService();
                if (checker.isIDServiceExist(id, service)) {
                    throw new Exception("ID is exits!");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
                System.out.print("Enter again: ");
            }
        }

        System.out.print("\t\tName Service: ");
        String name = validate.inputString();

        System.out.print("\t\tUsable Area: ");
        double area = validate.inputArea();

        System.out.print("\t\tRental Cost: ");
        int cost = validate.inputIntegerInRange(0, Integer.MAX_VALUE);

        System.out.print("\t\tMaximum Number Of Guest: ");
        int numGuest = validate.inputIntegerInRange(1, 20);

        System.out.println("\t\tChoose Rental Type: ");
        System.out.println("""
                \t\t\t1. Year
                \t\t\t2. Month
                \t\t\t3. Day
                \t\t\t4. Hour""");
        System.out.print("\t\tChoice: ");
        int rentalType = validate.inputIntegerInRange(1, 4);

        switch (service) {
            case "villa" -> {
                System.out.print("\t\tStandard: ");
                String standard = validate.inputString();

                System.out.print("\t\tDescription of other amenities: ");
                String amenities = validate.inputString();

                System.out.print("\t\tNumber Of Floor: ");
                int numFloor = validate.inputIntegerInRange(1, Integer.MAX_VALUE);

                System.out.print("\t\tPool's Area: ");
                double poolArea = validate.inputArea();

                return new Villa(id, name, area, cost, numGuest, rentalType, standard, amenities, numFloor, poolArea);
            }
            case "house" -> {
                System.out.print("\t\tStandard: ");
                String standard = validate.inputString();

                System.out.print("\t\tDescription of other amenities: ");
                String amenities = validate.inputString();

                System.out.print("\t\tNumber Of Floor: ");
                int numFloor = validate.inputIntegerInRange(1,Integer.MAX_VALUE);

                return new House(id, name, area, cost, numGuest, rentalType, standard, amenities, numFloor);

            }
            case "room" -> {
                System.out.print("\t\tFree Services: ");
                String freeServices = validate.inputString();

                return new Room(id, name, area, cost, numGuest, rentalType, freeServices);
            }
        }
        return null;
    }

    public void showService(String service) {
        try {
            if (service.equals("villa")) {
                ArrayList<Villa> listVilla = reader.readVillaCSV();

                if (listVilla.isEmpty()) {
                    throw new NoSuchElementException("List Villa is empty");
                }

                System.out.printf("\t\t%-10s %-13s %-6s %-10s %-7s %-7s %-20s %-15s %-10s %-10s \n",
                        "ID",
                        "Name Service",
                        "Area",
                        "Cost",
                        "Amount",
                        "Type",
                        "Standard",
                        "Amenities",
                        "N.O.Floor",
                        "Pool Area");

                    listVilla.forEach(Villa::showInfo);
            } else if (service.equals("house")) {
                ArrayList<House> listHouse = reader.readHouseCSV();

                if (listHouse.isEmpty()) {
                    throw new NoSuchElementException("List House is empty");
                }

                System.out.printf("\t\t%-10s %-13s %-6s %-10s %-7s %-7s %-20s %-15s %-10s\n",
                        "ID",
                        "Name Service",
                        "Area",
                        "Cost",
                        "Amount",
                        "Type",
                        "Standard",
                        "Amenities",
                        "N.O.Floor");

                    listHouse.forEach(House::showInfo);
            } else {
                ArrayList<Room> listRooms = reader.readRoomCSV();

                if (listRooms.isEmpty()) {
                    throw new NoSuchElementException("List Room is empty");
                }

                System.out.printf("\t\t%-10s %-13s %-6s %-10s %-7s %-7s %-20s\n",
                        "ID",
                        "Name Service",
                        "Area",
                        "Cost",
                        "Amount",
                        "Type",
                        "Free Service");

                    listRooms.forEach(Room::showInfo);
            }
        } catch (IOException | NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    public void showNameService(String service){
        TreeSet<String> listNameService = new TreeSet<>();
        try{
            if (service.equals("villa")){
                for (Villa villa : reader.readVillaCSV()) {
                    listNameService.add(villa.getNameService());
                }
            }else if (service.equals("house")){
                for (House house : reader.readHouseCSV()) {
                    listNameService.add(house.getNameService());
                }
            }else {
                for (Room room : reader.readRoomCSV()) {
                    listNameService.add(room.getNameService());
                }
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        System.out.println("\t\tService");
        int i = 0;
        for (String nameService : listNameService) {
            System.out.println(++i + ". " + nameService);
        }
    }

    public Services chooseService(String service){
        try {
            if (service.equals("villa")) {
                ArrayList<Villa> listVilla = reader.readVillaCSV();

                listVilla.forEach(Villa::showInfo);
                System.out.print("\tChoose ID Service: ");

                String id = validate.inputIDService();
                while (!checker.isIDServiceExist(id,"villa")){
                    System.out.println("\t" + id + " is not exist!");
                    System.out.print("\tEnter again: ");
                    id = validate.inputIDService();

                }

                return getServiceByID(id);

            }else if (service.equals("house")) {
                ArrayList<House> listHouse = reader.readHouseCSV();

                listHouse.forEach(House::showInfo);
                System.out.print("Choose ID Service: ");

                String id = validate.inputIDService();
                while (!checker.isIDServiceExist(id,"house")){
                    System.out.println("\t" + id + " is not exist!");
                    System.out.print("\tEnter again: ");
                    id = validate.inputIDService();
                }

                return getServiceByID(id);
            }else {
                ArrayList<Room> listRoom = reader.readRoomCSV();

                listRoom.forEach(Room::showInfo);
                System.out.print("Choose ID Service: ");

                String id = validate.inputIDService();
                while (!checker.isIDServiceExist(id,"room")){
                    System.out.println("\t" + id + " is not exist!");
                    System.out.print("\tEnter again: ");
                    id = validate.inputIDService();
                }

                return getServiceByID(id);
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

        return null;
    }
}
