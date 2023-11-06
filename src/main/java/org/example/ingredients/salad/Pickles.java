package org.example.ingredients.salad;

import org.example.ingredients.Salad;

public final class Pickles implements Salad {

    @Override
    public Double getPrice() {
        return 0.37;
    }

    @Override
    public String name() {
        return "Pickles";
    }
}
