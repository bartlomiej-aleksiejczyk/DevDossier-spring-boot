package com.example.devdossier.controllers.general;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class GeneralController {
    @GetMapping("/")
    public String showWelcomePage() {
        return "general/mainPage";
    }
}
