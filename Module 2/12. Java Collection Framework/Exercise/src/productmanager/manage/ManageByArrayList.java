package productmanager.manage;

import productmanager.entity.Product;

import java.util.*;

/**
 * Project: Exercise
 * Package: productmanager
 * User: lomahs
 * Date time: 28/05/2021 18:28
 * Created with IntelliJ IDEA
 */
public class ManageByArrayList {
    private final List<Product> list = new ArrayList<>();
    Validator validate = new Validator();

    public int menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\n\t\t***PRODUCT MANAGEMENT***");
        System.out.println("1. Add new product");
        System.out.println("2. Edit product");
        System.out.println("3. Remove product");
        System.out.println("4. Find product by Name");
        System.out.println("5. Display list products");
        System.out.println("6. Display products by price");
        System.out.print("Your choice: ");
        return sc.nextInt();
    }

    public void addProduct() throws Exception {

        System.out.println("\n\t-----ADD PRODUCT-----");
        System.out.print("Enter ID: ");
        String id = validate.inputString();

        if (isIDExist(id)){
            throw new Exception("ID: " + id + " already exist");
        }

        System.out.print("Enter name: ");
        String name = validate.inputString();

        System.out.print("Enter price: ");
        double price = validate.inputDouble();

        Product newProduct = new Product(id, name, price);
        add(newProduct);
        System.out.println("Add successful");
    }


    public void editInfo() {
        if (list.isEmpty()){
            throw new NullPointerException("Empty list");
        }

        System.out.println("\n\t-----EDIT PRODUCT-----");
        System.out.print("Enter ID: ");
        String id = validate.inputString();

        if (!isIDExist(id)){
            throw new NoSuchElementException("ID Product not exist");
        }

        edit(id);
        System.out.println("Edit successful");
    }

    public void removeProduct(){
        if (list.isEmpty()){
            throw new NullPointerException("Empty list");
        }

        System.out.println("\n\t-----REMOVE PRODUCT-----");
        System.out.print("Enter ID: ");
        String id = validate.inputString();

        if (!isIDExist(id)){
            throw new NoSuchElementException("ID Product not exist");
        }

        remove(id);

        System.out.println("Remove successful");
    }

    public void findProductByName(){
        if (list.isEmpty()){
            throw new NullPointerException("Empty list");
        }

        System.out.println("\n\t-----FIND PRODUCT-----");
        System.out.print("\nEnter name of product: ");
        String name = validate.inputString();

        Product product = getProductByName(name);

        if (product==null){
            throw new NoSuchElementException("Can find " + name);
        }

        System.out.println(product);
    }

    public void displayProducts(){
        if (list.isEmpty()){
            throw new NullPointerException("Empty list");
        }
        System.out.printf("\n\t\t%-7s %-15s %-10s\n","ID","Name","Price");
        list.forEach(System.out::println);
    }

    //True: Ascending order
    //False: Descending order
    public void displayProductByPrice(boolean order){

        Collections.sort(list);

        if (!order){
            Collections.reverse(list);
        }

        displayProducts();
    }

    public boolean add(Product product) {
        list.add(product);
        return true;
    }

    public boolean edit(String id){
        Scanner sc = new Scanner(System.in);
        Product product = getProductByID(id);

        System.out.println("-----EDIT INFORMATION-----");
        System.out.println("Press 0 to skip");
        System.out.println(product);

        System.out.println("ID: " + product.getId());
        System.out.print("Enter new name: ");
        String newName = validate.inputString();


        System.out.print("Enter new price: ");
        double newPrice = validate.inputDouble();
        if (newPrice!=0){
            product.setPrice(newPrice);
        }

        return true;
    }

    public boolean remove(String id){
        list.remove(getProductByID(id));

        return true;
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
        for (Product product : list) {
            if (product.getName().equals(name)){
                return product;
            }
        }
        return  null;
    }

    public boolean isIDExist(String id){
        for (Product product : list) {
            if (product.getId().equals(id)){
                return true;
            }
        }
        return false;
    }
}
