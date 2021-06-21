package models.io.csv;

import models.House;
import models.Room;
import models.Villa;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Project: FuramaResort
 * Package: models.io.csv
 * User: lomahs
 * Date time: 20/06/2021 17:13
 * Created with IntelliJ IDEA
 */
public class CSVWriter {
    public final String VILLA_CSV_FILE = "src//data//Villa.csv";
    public final String HOUSE_CSV_FILE = "src//data//House.csv";
    public final String ROOM_CSV_FILE = "src//data//Room.csv";

    public void writeToVillaCSV(Villa villa) throws IOException {
        FileWriter fileWriter = new FileWriter(VILLA_CSV_FILE,true);
        BufferedWriter writer = new BufferedWriter(fileWriter);
        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(
                "ID",
                "Name Service",
                "Usable Area",
                "Rental Cost",
                "Max Number of Guest",
                "Rental Type",
                "Standard",
                "Amenities",
                "Number of Floor",
                "Pool Area"));

        csvPrinter.printRecord(
                villa.getIdService(),
                villa.getNameService(),
                villa.getUsableArea(),
                villa.getRentalCost(),
                villa.getMaxNumGuest(),
                villa.getRentalType(),
                villa.getStandard(),
                villa.getAmenities(),
                villa.getNumFloor(),
                villa.getPoolArea());

        csvPrinter.flush();
    }

    public void writeToHouseCSV(House house) throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(HOUSE_CSV_FILE));
        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(
                "ID",
                "Name Service",
                "Usable Area",
                "Rental Cost",
                "Max Number of Guest",
                "Rental Type",
                "Standard",
                "Amenities",
                "Number of Floor"));

        csvPrinter.printRecord(
                house.getIdService(),
                house.getNameService(),
                house.getUsableArea(),
                house.getRentalCost(),
                house.getMaxNumGuest(),
                house.getRentalType(),
                house.getStandard(),
                house.getAmenities(),
                house.getNumFloor());

        csvPrinter.flush();
    }

    public void writeToRoomCSV(Room room) throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(ROOM_CSV_FILE));
        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(
                "ID",
                "Name Service",
                "Usable Area",
                "Rental Cost",
                "Max Number of Guest",
                "Rental Type",
                "Free Services"));

        csvPrinter.printRecord(
                room.getIdService(),
                room.getNameService(),
                room.getUsableArea(),
                room.getRentalCost(),
                room.getMaxNumGuest(),
                room.getRentalType(),
                room.getFreeService());

        csvPrinter.flush();
    }
}
