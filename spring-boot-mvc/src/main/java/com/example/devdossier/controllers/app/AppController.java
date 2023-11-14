package com.example.devdossier.controllers.app;

import com.example.devdossier.models.app.App;
import com.example.devdossier.services.app.AppService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/app")
public class AppController {

    private final AppService appService;

    @GetMapping
    public String listApps(@ModelAttribute @Valid AppsRequestDTO appsRequestDTO, Model model) {
        Page<App> appsPage = appService.getAllApps(appsRequestDTO);
        model.addAttribute("appsPage", appsPage);
        return "/app/apps";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("app", new App());
        return "app-form";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<App> app = appService.getAppById(id);
        app.ifPresent(a -> model.addAttribute("app", a));
        return app.isPresent() ? "app-form" : "redirect:/apps";
    }

    @PostMapping("/save")
    public String saveApp(@ModelAttribute App app, RedirectAttributes redirectAttributes) {
        appService.saveApp(app);
        redirectAttributes.addFlashAttribute("message", "App saved successfully!");
        return "redirect:/apps";
    }

    @GetMapping("/details/{id}")
    public String viewAppDetails(@PathVariable Long id, Model model) {
        Optional<App> app = appService.getAppById(id);
        if (app.isPresent()) {
            model.addAttribute("app", app.get());
            return "app-details";
        } else {
            return "redirect:/apps";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteApp(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        appService.deleteApp(id);
        redirectAttributes.addFlashAttribute("message", "App deleted successfully!");
        return "redirect:/apps";
    }
}
