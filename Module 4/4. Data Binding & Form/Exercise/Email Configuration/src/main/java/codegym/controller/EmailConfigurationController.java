package codegym.controller;

import codegym.model.EmailConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class EmailConfigurationController {

    @RequestMapping("/")
    public String showSetting(@ModelAttribute("configuration") EmailConfiguration configuration, Model model){


        return "index";
    }

//    @PostMapping("/save")
//    public String saveSetting(@ModelAttribute("configuration") EmailConfiguration configuration){
//
//        return "show";
//    }

    @ModelAttribute("language")
    public ArrayList<String> languageSetting(){
        return new ArrayList<>(
                Arrays.asList("English","Vietnamese","Japanese","Chinese")
        );
    }

    @ModelAttribute("pageSize")
    public ArrayList<Integer> pageSizeSetting(){
        return new ArrayList<>(
                Arrays.asList(5,10,15,25,50,100)
        );
    }
}
