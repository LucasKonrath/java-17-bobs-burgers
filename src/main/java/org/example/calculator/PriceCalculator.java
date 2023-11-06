package org.example.calculator;

sealed public interface PriceCalculator permits TexasCalculator {
    Double getTaxMultiplier();
}
