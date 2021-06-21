package models;

import java.util.ArrayList;

/**
 * Project: FuramaResort
 * Package: models
 * User: lomahs
 * Date time: 19/06/2021 10:32
 * Created with IntelliJ IDEA
 */
public class Room extends Services {
    //    private ArrayList<String> freeService;
    private String freeService;

    public Room() {
//        freeService = new ArrayList<>();
    }

    public Room(String idService,
                String nameService,
                double usableArea,
                long rentalCost,
                int maxNumGuest,
                int rentalType,
                String freeService) {
        super(idService, nameService, usableArea, rentalCost, maxNumGuest, rentalType);
        this.freeService = freeService;
    }

//    public ArrayList<String> getFreeService() {
//        return freeService;
//    }
//
//    public void setFreeService(ArrayList<String> freeService) {
//        this.freeService = new ArrayList<>(freeService);
//    }


    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public void showInfo() {
        System.out.println("ID Service: " + getIdService() + "\n" +
                "Name Service: " + getNameService() + "\n" +
                "Usable Area: " + getUsableArea() + "\n" +
                "Rental Cost: " + getRentalCost() + "\n" +
                "Maximum number of guest: " + getMaxNumGuest() +"\n" +
                "Rental Type: " + getRentalType());
        System.out.println("Free Service: " + getFreeService());
//        for (String s : freeService) {
//            System.out.println("\t" + s);
//        }
    }
}
