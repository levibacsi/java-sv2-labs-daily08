package day02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recipe {
    private String name;
    private List<String> ingredients = new ArrayList<>();
    private String description;

    public Recipe(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Recipe(String name) {
        this.name = name;
    }

    public void addIngredient(String ingredient, String... ingreds){
        ingredients.add(ingredient);
        ingredients.addAll(Arrays.asList(ingreds));
    }

    public String getName() {
        return name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public String getDescription() {
        return description;
    }
}
