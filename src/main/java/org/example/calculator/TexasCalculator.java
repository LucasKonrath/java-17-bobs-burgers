package org.example.calculator;

public final class TexasCalculator implements PriceCalculator {
    @Override
    public Double getTaxMultiplier(){
        return 1.14;
    }
}
