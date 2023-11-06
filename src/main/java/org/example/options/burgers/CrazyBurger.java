package org.example.options.burgers;

import org.example.ingredients.*;
import org.example.ingredients.bread.BananaBread;
import org.example.ingredients.cheese.CheddarCheese;
import org.example.ingredients.condiment.ChipotleSauce;
import org.example.ingredients.condiment.GreenMayo;
import org.example.ingredients.meat.FishFillet;
import org.example.ingredients.salad.Pickles;
import org.example.options.Burger;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class CrazyBurger extends Burger {

    List<Ingredient> ingredients = new ArrayList<>();
    public CrazyBurger(){
        super();
    }

    @Override
    public String getName() {
        return "Crazy Burger";
    }

    @Override
    protected Bread getBread() {
        return new BananaBread();
    }

    @Override
    protected Meat getMeat() {
        return new FishFillet();
    }

    @Override
    protected Salad getSalad() {
        return new Pickles();
    }

    @Override
    protected Cheese getCheese() {
        return new CheddarCheese();
    }

    @Override
    protected List<Condiment> getCondiments() {
        return asList(new ChipotleSauce(), new GreenMayo());
    }
}
