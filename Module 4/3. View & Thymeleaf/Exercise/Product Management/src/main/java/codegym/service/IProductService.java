package codegym.service;

import codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> showProducts();

    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(int idProduct);

    Product findProductById(int idProduct);
}
