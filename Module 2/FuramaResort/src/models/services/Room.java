package models.services;

import models.services.Services;

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
                int rentalCost,
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
        System.out.printf("\t\t%-10s %-13s %-6.2f %-10d %-7d %-7s %-20s\n",
                getIdService(),
                getNameService(),
                getUsableArea(),
                getRentalCost(),
                getMaxNumGuest(),
                getRentalType(),
                getFreeService());
    }
}
