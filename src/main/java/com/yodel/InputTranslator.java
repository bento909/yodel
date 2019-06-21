package com.yodel;

import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;

class InputTranslator {

    static BigDecimal translate(final String input) {
        if (isValid(input)){
            System.out.println("input of "+ input +" is valid");
                try {
                    return translateValidInput(input);
                } catch (NumberFormatException nfe) {
                    System.out.println("Input of " + input + " caused a NumberFormatException!");
                }
        }
        else {
            System.out.println("input of " + input + " is not valid");
        }
        return BigDecimal.ZERO;
    }

    private static boolean isValid(String input) {
        return NumberUtils.isNumber(input);
    }

    private static BigDecimal translateValidInput(String input) throws NumberFormatException{
        return new BigDecimal(input);
    }
}
