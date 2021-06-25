package models.services;

/**
 * Project: FuramaResort
 * Package: models
 * User: lomahs
 * Date time: 19/06/2021 10:23
 * Created with IntelliJ IDEA
 */
public abstract class Services {

    private String idService;
    private String nameService;
    private double usableArea;
    private int rentalCost;
    private int maxNumGuest;
    private int rentalType;

    private final String[] RENTAL_TYPE = {"","year", "month", "day", "hour"};

    public Services() {
    }

    public Services(String idService, String nameService, double usableArea, int rentalCost, int maxNumGuest, int rentalType) {
        this.idService = idService;
        this.nameService = nameService;
        this.usableArea = usableArea;
        this.rentalCost = rentalCost;
        this.maxNumGuest = maxNumGuest;
        this.rentalType = rentalType;
    }

    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public double getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(double usableArea) {
        this.usableArea = usableArea;
    }

    public int getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(int rentalCost) {
        this.rentalCost = rentalCost;
    }

    public int getMaxNumGuest() {
        return maxNumGuest;
    }

    public void setMaxNumGuest(int maxNumGuest) {
        this.maxNumGuest = maxNumGuest;
    }

    public String getRentalType() {
        return RENTAL_TYPE[rentalType];
    }

    public void setRentalType(int rentalType) {
        this.rentalType = rentalType;
    }

    public abstract void showInfo();
}
