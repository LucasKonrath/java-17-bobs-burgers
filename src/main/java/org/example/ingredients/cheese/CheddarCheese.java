package org.example.ingredients.cheese;

import org.example.ingredients.Cheese;

public final class CheddarCheese implements Cheese {
    @Override
    public Double getPrice() {
        return 4.20;
    }

    @Override
    public String name() {
        return "Cheddar Cheese";
    }
}
