package day02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {
    @Test
    void createByNameTest(){
        Recipe recipe = new Recipe("Stuffed cabbage");
        assertEquals("Stuffed cabbage", recipe.getName());
        assertNull(recipe.getDescription());
        assertEquals(0, recipe.getIngredients().size());
    }

    @Test
    void createByNameAndDescTest(){
        Recipe recipe = new Recipe("Stuffed cabbage", "Very nice, I like");
        assertEquals("Stuffed cabbage", recipe.getName());
        assertEquals("Very nice, I like", recipe.getDescription());
        assertEquals(0, recipe.getIngredients().size());
    }

    @Test
    void addMoreIngredsTest(){
        Recipe recipe = new Recipe("Stuffed cabbage", "Very nice, I like");

        recipe.addIngredient("cabbage");
        recipe.addIngredient("salt", "water", "meat");

        assertEquals(4, recipe.getIngredients().size());
        assertArrayEquals(new String[]{"cabbage", "salt", "water", "meat"}, recipe.getIngredients().toArray());
    }

}