package page.objects.day21_classwork;

import java.util.Objects;

public class Ingredient {
    private String itemdescription;
    private int quantity;

    public Ingredient() {

    }

    public Ingredient(String itemdescription, int quantity) {
        this.itemdescription = itemdescription;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return quantity == that.quantity && Objects.equals(getItemdescription(), that.getItemdescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getItemdescription(), quantity);
    }

    public String getItemdescription() {
        return itemdescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setItemdescription(String itemdescription) {
        this.itemdescription = itemdescription;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
