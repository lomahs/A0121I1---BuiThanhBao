package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
@RequestMapping("translate")
public class DictionaryController {

    @PostMapping
    public String translateWord(@RequestParam String eng, Model model) {
        HashMap<String, String> dict = new HashMap<>();
        dict.put("dog", "chó");
        dict.put("cat", "mèo");
        dict.put("book", "sách");
        dict.put("notebook", "vở");
        dict.put("pen", "bút");
        dict.put("door", "cửa sổ");

        model.addAttribute("eng",eng);
        model.addAttribute("vie", dict.getOrDefault(eng, "Not exist in dictionary"));
        return "dictionary";
    }


}
