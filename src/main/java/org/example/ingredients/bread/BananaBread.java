package org.example.ingredients.bread;

import org.example.ingredients.Bread;

public final class BananaBread implements Bread {
    @Override
    public Double getPrice() {
        return 3.50;
    }

    @Override
    public String name() {
        return "Banana Bread";
    }
}
