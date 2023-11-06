package org.example.ingredients.meat;

import org.example.ingredients.Meat;

public final class FishFillet implements Meat {
    @Override
    public Double getPrice() {
        return 3.50;
    }

    @Override
    public String name() {
        return "Fish Fillet";
    }
}
