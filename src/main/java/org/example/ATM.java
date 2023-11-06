package org.example;

import org.example.calculator.PriceCalculatorFactory;
import org.example.ingredients.*;
import org.example.options.Burger;
import org.example.stock.IngredientsStock;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ATM {

    Scanner scanner = new Scanner(System.in);
    List<Burger> burgers = new ArrayList<>();

    public void run(){
        boolean running = true;
        StateMachine stateMachine = new StateMachine();
        IngredientsStock stock = new IngredientsStock();
        List<Ingredient> chosenIngredients = new ArrayList<>();
        final String state = "TX";

        while (running){


            System.out.println("Do you want to choose a pre-existing burger? Type YES or NO");
            String choice = prompt();
            String burgerName;
            switch (choice){
                case "YES" -> {
                    System.out.println("Choose the existing burger: ");
                    printExistingBurgers();
                    burgerName = prompt();
                    if(burgers.stream().anyMatch(burger -> burger.getName().equals(burgerName))){

                    }
                }
            }


            if(stateMachine.isFinalState()){
                System.out.println("Final Order: ");
                printChosenIngredients(chosenIngredients);
                printTotalPrice(chosenIngredients, state);
                System.out.println("How do you want to name this monstruosity?");
                String burgername = scanner.nextLine();
                System.out.println("Adding burger: " + burgername);
                addBurger(chosenIngredients, burgername);
                return;
            }

            List<Ingredient> availableIngredients = stock.listAvailableIngredients(stateMachine.currentChoice());
            printChosenIngredients(chosenIngredients);
            System.out.println("Choose number to add ingredient. BACK to go back, NEXT to choose next ingredient.");
            present(availableIngredients);
            choice = prompt();
            switch (choice){
                case "BACK" -> stateMachine.retreat();
                case "NEXT" -> stateMachine.advance();
                default -> {
                    int chosen = Integer.valueOf(choice);
                    Ingredient ing = availableIngredients.get(chosen - 1);
                    stock.removeIngredient(ing);
                    chosenIngredients.add(ing);
                }
            };
        }
    }

    private static void printChosenIngredients(List<Ingredient> chosenIngredients) {
        System.out.println("Chosen Ingredients: ");
        for(Ingredient ing : chosenIngredients){
            System.out.println(ing.name());
        }
    }

    void present(List<Ingredient> ingredients){
        int i = 1;
        for(Ingredient ing : ingredients){
            System.out.println(String.format("%d - %s%n", i, ing.name()));
            i++;
        }
    }

    String prompt() {
        return scanner.nextLine();
    }

    void printTotalPrice(List<Ingredient> ingredients, String state){
        System.out.println("Total price: " + ingredients.stream().mapToDouble(Ingredient::getPrice).sum()
         * PriceCalculatorFactory.from(state).getTaxMultiplier());
    }

    void addBurger(List<Ingredient> ingredients, String name){
        burgers.add(
                new Burger() {
                    @Override
                    public String getName(){
                        return name;
                    }

                    @Override
                    protected Bread getBread() {
                        return (Bread) ingredients.stream()
                                .filter(obj -> obj.getClass().isAssignableFrom(Bread.class))
                                .toList()
                                .get(0);
                    }

                    @Override
                    protected Meat getMeat() {
                        return (Meat) ingredients.stream()
                                .filter(obj -> obj.getClass().isAssignableFrom(Meat.class))
                                .toList()
                                .get(0);
                    }

                    @Override
                    protected Salad getSalad() {
                        return (Salad) ingredients.stream()
                                .filter(obj -> obj.getClass().isAssignableFrom(Salad.class))
                                .toList()
                                .get(0);
                    }

                    @Override
                    protected Cheese getCheese() {
                        return (Cheese) ingredients.stream()
                                .filter(obj -> obj.getClass().isAssignableFrom(Cheese.class))
                                .toList()
                                .get(0);
                    }

                    @Override
                    protected List<Condiment> getCondiments() {
                        return ingredients.stream()
                                .filter(obj -> obj.getClass().isAssignableFrom(Condiment.class))
                                .map(ing -> (Condiment) ing)
                                .collect(Collectors.toList());
                    }
                }
        );
    }

    void printExistingBurgers(){
        burgers.forEach(burger -> System.out.println(burger.getName()));
    }
}
