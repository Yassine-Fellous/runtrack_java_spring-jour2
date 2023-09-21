package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ViewController extends Personne {

    @GetMapping("/welcome")
    public String welcomeUserPage(Model model) {
        model.addAttribute("age", age);
        model.addAttribute("name", name);
        return "view";
    }

    @PostMapping("/user")
    public String welcomeUser(
            @ModelAttribute("name") String name,
            @ModelAttribute("age") int age,
            Model model, BindingResult result
    ) {
        if (result.hasErrors()) {
            return "view";
        }
        else {
            String welcomeMessage = "Bienvenue, " + name + "! Vous avez " + age + " ans.";
            model.addAttribute("welcomeMessage", welcomeMessage);
            return "view";
        }
    }
}

