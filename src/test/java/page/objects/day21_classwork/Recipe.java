package page.objects.day21_classwork;

import java.util.List;
import java.util.Objects;

public class Recipe {

    private String recipename;
    private List<Ingredient> ingredlist;
    private int preptime;

    public Recipe(String recipename, List<Ingredient> ingredlist, int preptime) {
        this.recipename = recipename;
        this.ingredlist = ingredlist;
        this.preptime = preptime;
    }

    public Recipe() {
    }

    public String getRecipename() {
        return recipename;
    }

    public List<Ingredient> getIngredlist() {
        return ingredlist;
    }

    public int getPreptime() {
        return preptime;
    }

    public void setRecipename(String recipename) {
        this.recipename = recipename;
    }

    public void setIngredlist(List<Ingredient> ingredlist) {
        this.ingredlist = ingredlist;
    }

    public void setPreptime(int preptime) {
        this.preptime = preptime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return getPreptime() == recipe.getPreptime() && Objects.equals(getRecipename(), recipe.getRecipename()) && Objects.equals(getIngredlist(), recipe.getIngredlist());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRecipename(), getIngredlist(), getPreptime());
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipename='" + recipename + '\'' +
                ", ingredlist=" + ingredlist +
                '}';
    }


}
