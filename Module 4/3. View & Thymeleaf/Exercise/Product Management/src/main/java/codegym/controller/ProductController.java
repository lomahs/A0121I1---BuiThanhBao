package codegym.controller;

import codegym.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import codegym.service.IProductService;
import codegym.service.ProductService;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {
    private final IProductService productService = new ProductService();

    @GetMapping("/")
    public String showProducts(Model model){
        List<Product> listProducts = productService.showProducts();
        model.addAttribute(listProducts);

        return "index";
    }

    @GetMapping("/product/create")
    public String createProductForm(Model model){
        model.addAttribute("product",new Product());
        model.addAttribute("action","create");

        return "create";
    }

    @PostMapping("/product/create")
    public String addProduct(Product product){
        productService.addProduct(product);

        return "redirect:/";
    }

    @GetMapping("/product/{id}/edit")
    public String editProductForm(Model model, @PathVariable int id){
        model.addAttribute("product",productService.findProductById(id));
        model.addAttribute("action","edit");

        return "create";
    }

    @PostMapping("/product/edit")
    public String editProduct(Product product){
        productService.updateProduct(product);

        return "redirect:/";
    }

    @GetMapping("/product/{id}/delete")
    public String deleteProductForm(Model model, @PathVariable int id){
        model.addAttribute("product",productService.findProductById(id));

        return "delete";
    }

    @PostMapping("/product/delete")
    public String deleteProduct(Product product){
        productService.deleteProduct(product.getId());

        return "redirect:/";
    }

    @GetMapping("/product/{id}/view")
    public String viewProductForm(Model model, @PathVariable int id){
        model.addAttribute("product",productService.findProductById(id));

        return "view";
    }
}
