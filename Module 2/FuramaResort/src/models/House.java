package models;

/**
 * Project: FuramaResort
 * Package: models
 * User: lomahs
 * Date time: 19/06/2021 11:15
 * Created with IntelliJ IDEA
 */
public class House extends Services {
    private String standard;
    private String amenities;
    private int numFloor;

    public House() {
    }

    public House(String idService,
                 String nameService,
                 double usableArea,
                 long rentalCost,
                 int maxNumGuest,
                 int rentalType,
                 String standard,
                 String amenities,
                 int numFloor) {
        super(idService, nameService, usableArea, rentalCost, maxNumGuest, rentalType);
        this.standard = standard;
        this.amenities = amenities;
        this.numFloor = numFloor;
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
                "Floor number: " + getNumFloor());
    }
}
