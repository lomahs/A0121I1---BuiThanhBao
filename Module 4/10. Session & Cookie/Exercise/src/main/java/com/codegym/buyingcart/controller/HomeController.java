package com.codegym.buyingcart.controller;

import com.codegym.buyingcart.model.Card;
import com.codegym.buyingcart.model.Product;
import com.codegym.buyingcart.service.impl.ProductService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("card")
public class HomeController {

    @Autowired
    private ProductService productService;

    @ModelAttribute("card")
    public Card buyingCard(){
        return new Card();
    }

    @GetMapping("/")
    public String listProduct(Model model){
        List<Product> listProducts = productService.getListProducts();

        model.addAttribute("listProducts", listProducts);

        return "home";
    }

    @GetMapping("/cardview")
    public String showCard(@ModelAttribute("card") Card card, Model model){
        long sum = 0;
        for (Map.Entry<Product, Integer> product : card.getProducts().entrySet()) {
            sum += (long) product.getKey().getPrice() * product.getValue();
        }

        model.addAttribute("total", sum);
        return "cardview";
    }

    @GetMapping("/view/{id}")
    public String viewProduct(@PathVariable("id") Product product, Model model){

        model.addAttribute("product", product);
        return "view";
    }

    @GetMapping("/addtocard/{id}")
    public String addToCard(@PathVariable("id") Product product, @SessionAttribute("card") Card card, RedirectAttributes redirectAttributes){
        boolean exists = false;
        for (Map.Entry<Product, Integer> p : card.getProducts().entrySet()) {
            if (p.getKey().getId() == product.getId()){
                p.setValue(p.getValue() +1);

                exists = true;
            }
        }

        if (!exists){
            card.getProducts().put(product,1);
        }


        redirectAttributes.addFlashAttribute("message","Add to card Successful");

        return "redirect:/";
    }
}