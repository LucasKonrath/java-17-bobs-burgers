package org.example.options;

import org.example.ingredients.Ingredient;

import java.util.List;

sealed public interface Option permits Burger, Fries {
    List<Ingredient> listIngredients();

    List<Ingredient> addIngredient(Ingredient ingredient);

    Double calculatePrice();

}
