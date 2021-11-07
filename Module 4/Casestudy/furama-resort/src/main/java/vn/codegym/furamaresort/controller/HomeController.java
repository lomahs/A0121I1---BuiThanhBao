package vn.codegym.furamaresort.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vn.codegym.furamaresort.model.user.User;
import vn.codegym.furamaresort.service.IUserService;
import vn.codegym.furamaresort.service.impl.ContractDetailService;

@Controller
public class HomeController {

    @Autowired
    private ContractDetailService contractDetailService;

    @Autowired
    private IUserService userService;

    @GetMapping(value = {"/home", "/"})
    public String homepage(Model model, Pageable pageable) {

        model.addAttribute("listContractDetails", contractDetailService.getAllContractDetails(pageable));

        return "home";
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("user", new User());

        return "login";
    }

//    @GetMapping("/checklogin")
//    public String login(@Valid @ModelAttribute User user, BindingResult bindingResult, Model model) {
//        if (bindingResult.hasErrors()) {
//            return "login";
//        }
//        if (userService.checkLogin(user)) {
//
//            return "redirect:/";
//        } else {
//            model.addAttribute("loginFail", "Wrong username or password");
//            return "login";
//        }
//}
}