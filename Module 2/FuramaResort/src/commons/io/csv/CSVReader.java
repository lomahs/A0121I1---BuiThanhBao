package commons.io.csv;

import models.entity.Customer;
import models.entity.Employee;
import models.services.House;
import models.services.Room;
import models.services.Villa;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Project: FuramaResort
 * Package: commons.io.csv
 * User: lomahs
 * Date time: 20/06/2021 23:25
 * Created with IntelliJ IDEA
 */
public class CSVReader {
    public final String VILLA_CSV_FILE = "src//data//Villa.csv";
    public final String HOUSE_CSV_FILE = "src//data//House.csv";
    public final String ROOM_CSV_FILE = "src//data//Room.csv";
    public final String CUSTOMER_CSV_FILE = "src//data//Customer.csv";
    public final String EMPLOYEE_CSV = "src//data//Employee.csv";

    public ArrayList<Villa> readVillaCSV() throws IOException {
        BufferedReader reader = Files.newBufferedReader(Paths.get(VILLA_CSV_FILE));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader(
                "ID",
                "Name Service",
                "Usable Area",
                "Rental Cost",
                "Max Number of Guest",
                "Rental Type",
                "Standard",
                "Amenities",
                "Number of Floor",
                "Pool Area").withSkipHeaderRecord());

        ArrayList<Villa> listVilla = new ArrayList<>();

        for (CSVRecord csvRecord : csvParser) {
            String idService = csvRecord.get(0);
            String nameService = csvRecord.get(1);
            double usableArea = Double.parseDouble(csvRecord.get(2));
            int rentalCost = Integer.parseInt(csvRecord.get(3));
            int maxNumGuest = Integer.parseInt(csvRecord.get(4));
            int rentalType = switch (csvRecord.get(5)) {
                case "year" -> 1;
                case "month" -> 2;
                case "day" -> 3;
                default -> 4;
            };
            String standard = csvRecord.get(6);
            String amenities = csvRecord.get(7);
            int numFloor = Integer.parseInt(csvRecord.get(8));
            double poolArea = Double.parseDouble(csvRecord.get(9));


            listVilla.add(new Villa(idService, nameService, usableArea, rentalCost, maxNumGuest, rentalType, standard, amenities, numFloor, poolArea));
        }

        return listVilla;
    }

    public ArrayList<House> readHouseCSV() throws IOException {
        BufferedReader reader = Files.newBufferedReader(Paths.get(HOUSE_CSV_FILE));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader(
                "ID",
                "Name Service",
                "Usable Area",
                "Rental Cost",
                "Max Number of Guest",
                "Rental Type",
                "Standard",
                "Amenities",
                "Number of Floor").withSkipHeaderRecord());

        ArrayList<House> listHouse = new ArrayList<>();

        for (CSVRecord csvRecord : csvParser) {
            String idService = csvRecord.get(0);
            String nameService = csvRecord.get(1);
            double usableArea = Double.parseDouble(csvRecord.get(2));
            int rentalCost = Integer.parseInt(csvRecord.get(3));
            int maxNumGuest = Integer.parseInt(csvRecord.get(4));
            int rentalType = switch (csvRecord.get(5)) {
                case "year" -> 1;
                case "month" -> 2;
                case "day" -> 3;
                default -> 4;
            };
            String standard = csvRecord.get(6);
            String amenities = csvRecord.get(7);
            int numFloor = Integer.parseInt(csvRecord.get(8));

            listHouse.add(new House(idService, nameService, usableArea, rentalCost, maxNumGuest, rentalType, standard, amenities, numFloor));
        }

        return listHouse;
    }

    public ArrayList<Room> readRoomCSV() throws IOException {
        BufferedReader reader = Files.newBufferedReader(Paths.get(ROOM_CSV_FILE));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader(
                "ID",
                "Name Service",
                "Usable Area",
                "Rental Cost",
                "Max Number of Guest",
                "Rental Type",
                "Free Services").withSkipHeaderRecord());

        ArrayList<Room> listRoom = new ArrayList<>();

        for (CSVRecord csvRecord : csvParser) {
            String idService = csvRecord.get(0);
            String nameService = csvRecord.get(1);
            double usableArea = Double.parseDouble(csvRecord.get(2));
            int rentalCost = Integer.parseInt(csvRecord.get(3));
            int maxNumGuest = Integer.parseInt(csvRecord.get(4));
            int rentalType = switch (csvRecord.get(5)) {
                case "year" -> 1;
                case "month" -> 2;
                case "day" -> 3;
                default -> 4;
            };
            String freeServices = csvRecord.get(6);

            listRoom.add(new Room(idService, nameService, usableArea, rentalCost, maxNumGuest, rentalType, freeServices));
        }

        return listRoom;
    }

    public ArrayList<Customer> readCustomerCSV() throws IOException {
        BufferedReader reader = Files.newBufferedReader(Paths.get(CUSTOMER_CSV_FILE));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader(
                "ID",
                "Name",
                "Birthday",
                "Gender",
                "Phone Number",
                "Email",
                "Type Customer",
                "Address").withSkipHeaderRecord());

        ArrayList<Customer> listCus = new ArrayList<>();

        for (CSVRecord csvRecord : csvParser) {
            String id = csvRecord.get(0);
            String name = csvRecord.get(1);
            LocalDate birthday = LocalDate.parse(csvRecord.get(2), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            String gender = csvRecord.get(3);
            String phoneNumber = csvRecord.get(4);
            String email = csvRecord.get(5);
            int typeCus = switch (csvRecord.get(6)) {
                case "Member" -> 1;
                case "Silver" -> 2;
                case "Gold" -> 3;
                case "Platinum" -> 4;
                default -> 5;
            };
            String address = csvRecord.get(7);

            listCus.add(new Customer(id, name, birthday, gender, phoneNumber, email, typeCus, address));
        }

        return listCus;
    }

    public HashMap<String, Employee> readEmployeeCSV() throws IOException {
        BufferedReader reader = Files.newBufferedReader(Paths.get(EMPLOYEE_CSV));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader(
                "ID",
                "Name",
                "Birthday",
                "Phone Number",
                "Email",
                "Level",
                "Position",
                "Salary",
                "Department").withSkipHeaderRecord());

        HashMap<String, Employee> list = new HashMap<>();

        for (CSVRecord csvRecord : csvParser) {
            String id = csvRecord.get(0);
            String name = csvRecord.get(1);
            LocalDate birthday = LocalDate.parse(csvRecord.get(2), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            String phone = csvRecord.get(3);
            String email = csvRecord.get(4);
            String level = csvRecord.get(5);
            String position = csvRecord.get(6);
            int salary = Integer.parseInt(csvRecord.get(7));
            String department = csvRecord.get(8);

            list.put(id, new Employee(id, name, birthday, phone, email, level, position, salary, department));
        }

        return list;
    }

}
