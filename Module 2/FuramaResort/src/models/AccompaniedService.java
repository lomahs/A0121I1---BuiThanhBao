package models;

/**
 * Project: FuramaResort
 * Package: models
 * User: lomahs
 * Date time: 19/06/2021 11:30
 * Created with IntelliJ IDEA
 */
public class AccompaniedService {

    private String nameService;
    private String unit;
    private long cost;

    public AccompaniedService() {
    }

    public AccompaniedService(String nameService, String unit, long cost) {
        this.nameService = nameService;
        this.unit = unit;
        this.cost = cost;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }
}
