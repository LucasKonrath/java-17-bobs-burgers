package org.example.stock;

import org.example.ingredients.*;
import org.example.ingredients.bread.BananaBread;
import org.example.ingredients.cheese.CheddarCheese;
import org.example.ingredients.condiment.ChipotleSauce;
import org.example.ingredients.condiment.GreenMayo;
import org.example.ingredients.meat.FishFillet;
import org.example.ingredients.salad.Pickles;
import org.example.util.StockItem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IngredientsStock {
    List<StockItem> stock = new ArrayList<>(List.of(
            new StockItem(10, new BananaBread()),
            new StockItem(10, new CheddarCheese()),
            new StockItem(5, new ChipotleSauce()),
            new StockItem(5, new GreenMayo()),
            new StockItem(10, new FishFillet()),
            new StockItem(10, new Pickles())
    ));

    public List<Ingredient> listAvailableIngredients(Object ingredient){

        if(ingredient == null){
            return stock.stream().filter(stockItem -> stockItem.listQuantity() > 0).map(StockItem::getIngredient).collect(Collectors.toList());
        } else if (ingredient == Bread.class){
            return stock.stream().filter(el -> Bread.class.isAssignableFrom(el.getIngredient().getClass())).filter(stockItem -> stockItem.listQuantity() > 0).map(StockItem::getIngredient).collect(Collectors.toList());
        } else if (ingredient == Cheese.class){
            return stock.stream().filter(el -> Cheese.class.isAssignableFrom(el.getIngredient().getClass())).filter(stockItem -> stockItem.listQuantity() > 0).map(StockItem::getIngredient).collect(Collectors.toList());
        } else if (ingredient == Condiment.class){
            return stock.stream().filter(el -> Condiment.class.isAssignableFrom(el.getIngredient().getClass())).filter(stockItem -> stockItem.listQuantity() > 0).map(StockItem::getIngredient).collect(Collectors.toList());
        } else if (ingredient == Meat.class){
            return stock.stream().filter(el -> Meat.class.isAssignableFrom(el.getIngredient().getClass())).filter(stockItem -> stockItem.listQuantity() > 0).map(StockItem::getIngredient).collect(Collectors.toList());
        } else if (ingredient ==  Salad.class){
            return stock.stream().filter(el -> Salad.class.isAssignableFrom(el.getIngredient().getClass())).filter(stockItem -> stockItem.listQuantity() > 0).map(StockItem::getIngredient).collect(Collectors.toList());
        }

        throw new IllegalStateException("Unexpected value: " + ingredient);
    }

    public void removeIngredient(Object ingredient){
        stock.stream()
            .filter(obj -> obj.getIngredient().getClass().equals(ingredient.getClass()))
                .findFirst()
                .get().decreaseStock();

    }
}
