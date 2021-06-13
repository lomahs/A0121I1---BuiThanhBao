package productmanager.entity;

/**
 * Project: Exercise
 * Package: productmanager
 * User: lomahs
 * Date time: 28/05/2021 09:53
 * Created with IntelliJ IDEA
 */

public class Product implements Comparable<Product> {
    private String id;
    private String name;
    private double price;

    public Product() {
    }

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Product %-7s %-15s %-10.2f",id,name,price);
    }

    @Override
    public int compareTo(Product o) {
        return Double.compare(this.getPrice(), o.getPrice());
    }
}
