package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/converter")
public class ConverterController {

    @PostMapping
    public String convert(@RequestParam("rate") String rate, @RequestParam("usd") String usd, Model model) {
        double rateDouble = Double.parseDouble(rate);
        double usdDouble = Double.parseDouble(usd);

        double vnd = rateDouble * usdDouble;

        model.addAttribute("vnd", vnd);

        return "result";
    }
}
