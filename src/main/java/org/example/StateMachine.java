package org.example;

import org.example.ingredients.*;

import java.lang.reflect.GenericDeclaration;

public class StateMachine {
    int currState = 0;
    boolean isFinalState = false;

    StateMachine(){

    }

    Class currentChoice(){
        return switch (currState){
            case 0 -> Bread.class;
            case 1 -> Cheese.class;
            case 2 -> Condiment.class;
            case 3 -> Meat.class;
            case 4 -> Salad.class;
            default -> null;
        };
    }

    void advance(){
        this.currState++;
        if(this.currState > 4) {
            this.isFinalState = true;
        }
    }

    void retreat(){
        this.currState--;
        if(this.currState < 5){
            this.isFinalState = false;
        }
    }

    public boolean isFinalState() {
        return this.isFinalState;
    }
}
