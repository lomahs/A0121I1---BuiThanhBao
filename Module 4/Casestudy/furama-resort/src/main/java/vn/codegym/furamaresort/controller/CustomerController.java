package vn.codegym.furamaresort.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.furamaresort.model.customer.Customer;
import vn.codegym.furamaresort.model.customer.CustomerType;
import vn.codegym.furamaresort.service.ICustomerService;
import vn.codegym.furamaresort.service.ICustomerTypeService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @ModelAttribute("customerTypes")
    public List<CustomerType> listCustomerTypes() {
        return customerTypeService.listAllCustomerTypes();
    }

    @GetMapping
    private String showAllCustomer(Model model, @PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("listCustomers", customerService.listAllCustomers(pageable));

        return "customer/customer-list";
    }

    @GetMapping("/search")
    private String showCustomerByName(
            Model model,
            @PageableDefault(size = 5) Pageable pageable,
            @RequestParam(value = "searchValue") Optional<String> searchValue) {
        if (searchValue.isPresent()) {
            model.addAttribute("listCustomers", customerService.listAllCustomerByCustomerName(searchValue.get(), pageable));
        } else {
            model.addAttribute("listCustomers", customerService.listAllCustomers(pageable));
        }

        return "customer/customer-list-table";
    }


    @GetMapping("/add")
    private String showAddForm(Model model) {
        model.addAttribute("customer", new Customer());

        return "customer/customer-add";
    }

    @PostMapping("/add")
    public String addCustomer(@Valid @ModelAttribute Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "customer/customer-add";
        }

        customerService.saveCustomer(customer);

        redirectAttributes.addFlashAttribute("message", "Add successful");

        return "redirect:/customer";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Customer customer, Model model) {
        model.addAttribute("customer", customer);

        return "customer/customer-edit";
    }

    @PostMapping("/edit")
    public String editCustomer(@Valid @ModelAttribute Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "customer/customer-edit";
        }

        customerService.saveCustomer(customer);

        redirectAttributes.addFlashAttribute("message", "Edit successful");

        return "redirect:/customer";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
        customerService.deleteCustomerById(id);
        
        redirectAttributes.addFlashAttribute("message", "Delete successful");

        return "redirect:/customer";
    }
}