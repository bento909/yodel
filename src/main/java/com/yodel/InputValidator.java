package com.yodel;

import org.apache.commons.lang3.math.NumberUtils;

public class InputValidator {

    /**
     * Checks to ensure that the input String is a number and does not begin with negative.
     * @param input         The string input from the command line args
     * @return              a boolean, true if a valid input
     */
    public static boolean validate(final String input) {
        boolean isNumber = NumberUtils.isNumber(input);
        boolean isNegative = input.startsWith("-");
        return isNumber && !isNegative;
    }

}
