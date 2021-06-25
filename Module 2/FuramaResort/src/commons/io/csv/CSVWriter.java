package commons.io.csv;

import commons.io.manage.FileChecker;
import models.entity.Customer;
import models.services.Booking;
import models.services.House;
import models.services.Room;
import models.services.Villa;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.format.DateTimeFormatter;

/**
 * Project: FuramaResort
 * Package: commons.io.csv
 * User: lomahs
 * Date time: 20/06/2021 17:13
 * Created with IntelliJ IDEA
 */
public class CSVWriter {
    public final String VILLA_CSV_FILE = "src//data//Villa.csv";
    public final String HOUSE_CSV_FILE = "src//data//House.csv";
    public final String ROOM_CSV_FILE = "src//data//Room.csv";
    public final String CUSTOMER_CSV_FILE = "src//data//Customer.csv";
    public final String BOOKING_CSV_FILE = "src//data//Booking.csv";

    public void writeVila(Villa villa) throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(VILLA_CSV_FILE),StandardOpenOption.APPEND);

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
                "Pool Area").withSkipHeaderRecord(!new FileChecker().isFileEmpty(VILLA_CSV_FILE)));

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

    public void writeHouse(House house) throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(HOUSE_CSV_FILE), StandardOpenOption.APPEND);
        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(
                "ID",
                "Name Service",
                "Usable Area",
                "Rental Cost",
                "Max Number of Guest",
                "Rental Type",
                "Standard",
                "Amenities",
                "Number of Floor").withSkipHeaderRecord(!new FileChecker().isFileEmpty(HOUSE_CSV_FILE)));

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

    public void writeRoom(Room room) throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(ROOM_CSV_FILE),StandardOpenOption.APPEND);
        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(
                "ID",
                "Name Service",
                "Usable Area",
                "Rental Cost",
                "Max Number of Guest",
                "Rental Type",
                "Free Services").withSkipHeaderRecord(!new FileChecker().isFileEmpty(ROOM_CSV_FILE)));

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

    public void writeCustomer(Customer cus) throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(CUSTOMER_CSV_FILE),StandardOpenOption.APPEND);
        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(
                "ID",
                "Name",
                "Birthday",
                "Gender",
                "Phone Number",
                "Email",
                "Type Customer",
                "Address").withSkipHeaderRecord(!new FileChecker().isFileEmpty(CUSTOMER_CSV_FILE)));

        csvPrinter.printRecord(
                cus.getId(),
                cus.getNameCus(),
                cus.getBirthday().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                cus.getGender(),
                cus.getPhoneNumber(),
                cus.getEmail(),
                cus.getTypeCus(),
                cus.getAddress());

        csvPrinter.flush();
    }

    public void writeBooking(Booking booking) throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(BOOKING_CSV_FILE),StandardOpenOption.APPEND);
        CSVPrinter csvPrinter = new CSVPrinter(writer,CSVFormat.DEFAULT.withHeader(
                "ID Customer",
                "Name Customer",
                "ID Service",
                "Name Service").withSkipHeaderRecord(!new FileChecker().isFileEmpty(BOOKING_CSV_FILE)));

        csvPrinter.printRecord(
                booking.getCustomer().getId(),
                booking.getCustomer().getNameCus(),
                booking.getService().getIdService(),
                booking.getService().getNameService());

        csvPrinter.flush();
    }
}
