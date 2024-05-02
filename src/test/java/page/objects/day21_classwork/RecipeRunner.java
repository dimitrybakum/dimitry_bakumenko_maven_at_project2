package page.objects.day21_classwork;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class RecipeRunner {

    static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        toJson();
        fromJson();
    }

    public static void toJson() throws IOException {
        Recipe recipe = new Recipe(
                "Salad", Arrays.asList(
                        new Ingredient("beef", 150),
                        new Ingredient("beetroots", 4),
                        new Ingredient("potatoes", 33),
                        new Ingredient("Tomato", 5),
                        new Ingredient("Cucumber", 4)), 3);
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/test/resources/new_recipe.json"), recipe);

    }

    public static void fromJson() throws IOException {
        Recipe recipe = objectMapper
                .readValue(new File("src/test/resources/new_recipe.json"), Recipe.class);
        System.out.println(recipe);
    }
}
