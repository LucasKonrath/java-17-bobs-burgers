package org.example.ingredients;

sealed public interface Ingredient permits Bread, Meat, Cheese, Salad, Condiment {

    Double getPrice();
    String name();
}
