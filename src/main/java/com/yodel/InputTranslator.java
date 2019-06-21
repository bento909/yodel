package com.yodel;

import java.math.BigDecimal;

class InputTranslator {

    /**
     * Translates a String into a BigDecimal, to be passed into the Calculator
     *
     * @param input         A validated String input from the command line
     * @return              A BigDecimal which will be passed to the Calculator
     */
    static BigDecimal translate(final String input) {
        try {
            return translateValidInput(input);
        } catch (NumberFormatException nfe) {
            System.out.println("Input of " + input + " caused a NumberFormatException!");
            return BigDecimal.ZERO;
        }
    }

    private static BigDecimal translateValidInput(String input) throws NumberFormatException {
        return new BigDecimal(input);
    }

}
