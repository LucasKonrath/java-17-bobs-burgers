package org.example.ingredients.condiment;

import org.example.ingredients.Condiment;

public final class GreenMayo implements Condiment {
    @Override
    public Double getPrice() {
        return 0.17;
    }

    @Override
    public String name() {
        return "Green Mayo";
    }
}
