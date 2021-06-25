package commons.validate;

import commons.io.csv.CSVReader;
import models.entity.Customer;
import models.services.House;
import models.services.Room;
import models.services.Services;
import models.services.Villa;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Project: FuramaResort
 * Package: commons.validate
 * User: lomahs
 * Date time: 22/06/2021 10:49
 * Created with IntelliJ IDEA
 */
public class Checker {
    CSVReader reader = new CSVReader();

    public boolean isIDServiceExist(String id, String service){
        try {
            if (service.equals("villa")) {
                ArrayList<Villa> listVilla = reader.readVillaCSV();

                for (Services services : listVilla) {
                    if (services.getIdService().equals(id)) {
                        return true;
                    }
                }
            }if (service.equals("house")){
                ArrayList<House> listHouse = reader.readHouseCSV();

                for (House house : listHouse) {
                    if (house.getIdService().equals(id)){
                        return true;
                    }
                }
            }if (service.equals("room")){
                ArrayList<Room> listRoom = reader.readRoomCSV();

                for (Room room : listRoom) {
                    if (room.getIdService().equals(id)){
                        return true;
                    }
                }
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        return false;
    }

    public boolean isIDCustomerExist(String id){
        try {
            ArrayList<Customer> listCustomer = reader.readCustomerCSV();

            for (Customer customer : listCustomer) {
                if (customer.getId().equals(id)){
                    return true;
                }
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

}
