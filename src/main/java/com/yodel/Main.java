package com.yodel;

import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Written by Ben Thomas  21/06/2019          https://github.com/bento909
 *
 */
public class Main {

    /**
     * Defined in build.gradle : jar > manifest > attributes
     *
     * @param args          Command line arguments
     */
    public static void main (String[] args){
        long start = DateTime.now().getMillis();
        Arrays.stream(args).forEach(inputArg -> {
            if (InputValidator.validate(inputArg))
                System.out.println(calculateInterestOn(inputArg));
            else
                System.out.println( "Input of " + inputArg + " is not valid.");
        });
        long end = DateTime.now().getMillis() - start;
        System.out.println("Completed in " + end + "ms");
    }

    private static String calculateInterestOn(final String inputArgument) {
        final BigDecimal amount = InputTranslator.translate(inputArgument);
        if(amount.compareTo(BigDecimal.ZERO) > 0)
            return inputArgument + " yields " + Calculator.calculateInterest(amount).toString();
        return ("Input of " + inputArgument + " could not be processed.");
    }

}
