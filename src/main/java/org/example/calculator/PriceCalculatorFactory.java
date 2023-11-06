package org.example.calculator;

public class PriceCalculatorFactory {
    public static PriceCalculator from(String state){
        return switch (state){
            case "TX" -> new TexasCalculator();
            default -> throw new IllegalStateException("Invalid state: " + state);
        };
    }
}
