package hclee.springframework.spring5recipeapp.controllers;

import hclee.springframework.spring5recipeapp.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.CompletableFuture;

@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }


    /*@GetMapping({"", "/", "/index"})
    public CompletableFuture<String> getIndexPage(Model model) {
        model.addAttribute("recipes", recipeService.getRecipes());
        return CompletableFuture.supplyAsync(() -> "index");
    }*/
    @GetMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}
