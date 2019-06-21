package com.yodel;

import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.util.Arrays;

public class Main {

    public static void main (String[] args){
        long start = DateTime.now().getMillis();
        Arrays.stream(args).forEach(arg -> {
            System.out.println(TranslateIfPossible(arg));
        });
        long end = DateTime.now().getMillis() - start;
        System.out.println("Completed in " + end + "ms");
    }

    private static String TranslateIfPossible(final String inputArgument) {
        BigDecimal input = InputTranslator.translate(inputArgument);
        if(input.compareTo(BigDecimal.ZERO) > 0)
            return inputArgument + " yields " + Calculator.calculateInterest(input).toString();
        return "Input of " + inputArgument + " could not be processed.";
    }
}
