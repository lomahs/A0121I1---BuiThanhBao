package models;

/**
 * Project: FuramaResort
 * Package: models
 * User: lomahs
 * Date time: 19/06/2021 11:26
 * Created with IntelliJ IDEA
 */
public class Villa extends Services{

    private String standard;
    private String amenities;
    private int numFloor;
    private double poolArea;

    public Villa() {
    }

    public Villa(String idService,
                 String nameService,
                 double usableArea,
                 long rentalCost,
                 int maxNumGuest,
                 int rentalType,
                 String standard,
                 String amenities,
                 int numFloor,
                 double poolArea) {
        super(idService, nameService, usableArea, rentalCost, maxNumGuest, rentalType);
        this.standard = standard;
        this.amenities = amenities;
        this.numFloor = numFloor;
        this.poolArea = poolArea;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public int getNumFloor() {
        return numFloor;
    }

    public void setNumFloor(int numFloor) {
        this.numFloor = numFloor;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    @Override
    public void showInfo() {
        System.out.println("ID Service: " + getIdService() +"\n" +
                "Name Service: " + getNameService() +"\n" +
                "Usable Area: " + getUsableArea() +"\n" +
                "Rental Cost: " + getRentalCost() +"\n" +
                "Maximum number of guest: " + getMaxNumGuest() +"\n" +
                "Rental Type: " + getRentalType() +"\n" +
                "Standard: " + getStandard() +"\n" +
                "Amenities: " + getAmenities() +"\n" +
                "Floor number: " + getNumFloor() +"\n" +
                "Area of pool: " + getPoolArea());
    }
}
