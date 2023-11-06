package org.example.options;

import org.example.ingredients.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public non-sealed abstract class Burger implements Option {

    List<Ingredient> ingredients = new ArrayList<>();

    protected Burger(){
        ingredients.add(getBread());
        ingredients.add(getMeat());
        ingredients.add(getSalad());
        ingredients.add(getCheese());
        ingredients.addAll(getCondiments());
    }

    public abstract String getName();

    protected abstract Bread getBread();
    protected abstract Meat getMeat();

    protected abstract Salad getSalad();

    protected abstract Cheese getCheese();

    protected abstract List<Condiment> getCondiments();

    @Override
    public List<Ingredient> listIngredients() {
        return ingredients;
    }

    @Override
    public List<Ingredient> addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
        return this.ingredients;
    }

    @Override
    public Double calculatePrice() {
        return ingredients.stream().mapToDouble(Ingredient::getPrice).sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Burger burger = (Burger) o;
        return Objects.equals(getName(), burger.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
