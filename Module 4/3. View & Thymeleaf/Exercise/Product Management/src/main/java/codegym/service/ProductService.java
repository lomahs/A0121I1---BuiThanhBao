package codegym.service;

import codegym.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {
    static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Iphone 7 plus", 5, 10000));
        products.add(new Product(2, "Macbook Pro", 2, 99999));
        products.add(new Product(3, "Samsung Galaxy", 3, 5000));
        products.add(new Product(4, "Dell inspriron", 1, 60000));
        products.add(new Product(5, "Nokia", 20, 500));
    }

    @Override
    public List<Product> showProducts() {
        return products;
    }

    @Override
    public void addProduct(Product product) {
        product.setId(products.size() + 1);
        products.add(product);
    }

    @Override
    public void updateProduct(Product product) {
        products.stream()
                .filter(pro -> pro.getId() == product.getId())
                .forEach(pro -> {
                    pro.setName(product.getName());
                    pro.setPrice(product.getPrice());
                    pro.setQuantity(product.getQuantity());
                });
    }

    @Override
    public void deleteProduct(int idProduct) {
        products.removeIf(product -> product.getId() == idProduct);
    }

    @Override
    public Product findProductById(int idProduct) {
        return products.stream()
                .filter(product -> product.getId() == idProduct)
                .findFirst()
                .orElse(null);

    }
}
