package org.example.util;

import org.example.ingredients.Ingredient;

public class StockItem {
    private Integer first;
    private Ingredient second;
    public StockItem(Integer first, Ingredient second){
        this.first = first;
        this.second = second;
    }

    public Integer listQuantity(){
        return this.first;
    }
    public Ingredient getIngredient(){
        return this.second;
    }

    public void decreaseStock(){
        this.first--;
    }

}
