package productmanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

/**
 * Project: Exercise
 * Package: productmanager
 * User: lomahs
 * Date time: 28/05/2021 18:28
 * Created with IntelliJ IDEA
 */
public class ManageByArrayList {
    private List<Product> list = new ArrayList<>();

    public boolean add(Product product) {
        list.add(product);
        return true;
    }

    public void addProduct() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ID: ");
        String id = sc.nextLine();

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter price: ");
        double price = sc.nextDouble();

        Product newProduct = new Product(id, name, price);
        add(newProduct);
        System.out.println("Add successful");
    }

    public void editInfo(String id) {
        Scanner sc = new Scanner(System.in);


        Product product = getProductByID(id);

        System.out.println("-----EDIT INFORMATION-----");
        System.out.println(product.toString());
        System.out.println("Enter to skip!");

        System.out.println("ID: " + product.getId());
        System.out.print("Enter new name: ");
        String newName = sc.nextLine();

        System.out.print("Enter new price: ");
        double newPrice = sc.nextDouble();

        product.setName(newName);
        product.setPrice(newPrice);
    }

    public Product getProductByID(String id) {
        for (Product product : list) {
            if (product.getId().equals(id)) {
                return product;
            }
        }

        return null;
    }

    public Product getProductByName(String name){
        
    }

    public boolean checkID(String id){
        for (Product product : list) {
            if (product.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

}
