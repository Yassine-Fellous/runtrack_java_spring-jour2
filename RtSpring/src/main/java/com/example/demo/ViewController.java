package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {

    public int age = 0;
    public String name = "";

    @GetMapping("/welcome")
    public String welcomeUserPage(Model model) {
        model.addAttribute("age", age);
        model.addAttribute("name", name);
        return "view";
    }

    @PostMapping("/user")
    public String welcomeUser(
            @RequestParam("name") String name,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            return "view";
        }

        String welcomeMessage = "Bienvenue, " + name + "! Vous avez " + 15 + " ans.";
        model.addAttribute("welcomeMessage", welcomeMessage);
        return "redirect:/view";
    }


 /*   @PostMapping("/user")
    public String welcomeUser(
            @RequestParam("name") String name,
            @RequestParam("age") int age,
            BindingResult bindingResult, Model model
    ) {
        if (bindingResult.hasErrors()) {
            return "view";
        }

        String welcomeMessage = "Bienvenue, " + name + "! Vous avez " + 15 + " ans.";
        model.addAttribute("welcomeMessage", welcomeMessage);
        return "redirect:/view";
    }*/
}

