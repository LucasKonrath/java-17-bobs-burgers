package org.example.ingredients.condiment;

import org.example.ingredients.Condiment;
import org.example.ingredients.Ingredient;

public final class ChipotleSauce implements Condiment {
    @Override
    public Double getPrice() {
        return 0.12;
    }

    @Override
    public String name() {
        return "Chipotle Sauce";
    }
}
