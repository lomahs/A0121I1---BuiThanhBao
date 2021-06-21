package models.io.csv;

import models.House;
import models.Room;
import models.Villa;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Project: FuramaResort
 * Package: models.io.csv
 * User: lomahs
 * Date time: 20/06/2021 23:25
 * Created with IntelliJ IDEA
 */
public class CSVReader {
    public final String VILLA_CSV_FILE = "src//data//Villa.csv";
    public final String HOUSE_CSV_FILE = "src//data//House.csv";
    public final String ROOM_CSV_FILE = "src//data//Room.csv";

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
                "Pool Area").withIgnoreHeaderCase(true).withTrim());

        ArrayList<Villa> listVilla = new ArrayList<>();

        for (CSVRecord csvRecord : csvParser) {
            String idService = csvRecord.get(0);
            String nameService = csvRecord.get(1);
            double usableArea = Double.parseDouble(csvRecord.get(2));
            long rentalCost = Long.parseLong(csvRecord.get(3));
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
                "Number of Floor").withIgnoreHeaderCase(true).withTrim());

        ArrayList<House> listHouse = new ArrayList<>();

        for (CSVRecord csvRecord : csvParser) {
            String idService = csvRecord.get(0);
            String nameService = csvRecord.get(1);
            double usableArea = Double.parseDouble(csvRecord.get(2));
            long rentalCost = Long.parseLong(csvRecord.get(3));
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
                "Free Services").withIgnoreHeaderCase(true).withTrim());

        ArrayList<Room> listRoom = new ArrayList<>();

        for (CSVRecord csvRecord : csvParser) {
            String idService = csvRecord.get(0);
            String nameService = csvRecord.get(1);
            double usableArea = Double.parseDouble(csvRecord.get(2));
            long rentalCost = Long.parseLong(csvRecord.get(3));
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

}
