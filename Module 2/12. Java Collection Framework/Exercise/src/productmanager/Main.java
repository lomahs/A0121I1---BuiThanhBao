package productmanager;

import productmanager.manage.ManageByArrayList;
import productmanager.manage.Validator;

/**
 * Project: Exercise
 * Package: productmanager
 * User: lomahs
 * Date time: 31/05/2021 00:25
 * Created with IntelliJ IDEA
 */
public class Main {
    public static void main(String[] args) {
        ManageByArrayList list = new ManageByArrayList();

        while (true){
            int choice = list.menu();

            switch (choice){
                case 1:
                    try {
                        list.addProduct();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        list.editInfo();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        list.removeProduct();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        list.findProductByName();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        list.displayProducts();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("a. Ascending order");
                    System.out.println("b. Descending order");
                    System.out.print("Your choice: ");
                    char order = new Validator().inputString().charAt(0);

                    try {
                        list.displayProductByPrice(order == 'a');
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    return;
            }
        }

    }
}
