package com.yodel;

import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.util.Arrays;

public class Main {

    public static void main (String[] args){
        DateTime start = DateTime.now();
        Arrays.stream(args).forEach(arg -> {
            System.out.println(TranslateIfPossible(arg));

        });


        BigDecimal input = InputTranslator.translate();
    }

    private static String TranslateIfPossible(final String inputArgument) {
        BigDecimal input = InputTranslator.translate(inputArgument);
        BigDecimal interest = Calculator.calculateInterest(input);
        return
    };


}
