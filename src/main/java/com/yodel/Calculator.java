package com.yodel;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Calculator {

    private static final BigDecimal THOUSAND = new BigDecimal(1000);
    private static final BigDecimal FIVE_THOUSAND = new BigDecimal(5000);
    private static final BigDecimal INTEREST_FIRST_THOUSAND = new BigDecimal(0.01);
    private static final BigDecimal INTEREST_BETWEEN_ONE_AND_FIVE_THOUSAND = new BigDecimal(0.02);
    private static final BigDecimal INTEREST_OVER_FIVE_THOUSAND = new BigDecimal(0.03);

    /**
     * Interest Calculation
     * <p>
     * Write a program that will output the total interest gained on a sum of money
     * <p>
     * 1) The first 1000 gains 1% interest
     * 2) Between 1000 and 5000 gains 2% interest
     * 3) Anything greater than 5000 gains 3% interest
     * <p>
     * Example
     * 6400 would gain an interest of 132
     * <p>
     * Please submit your solution and tests in a zipfile or provide a link to a repository such as github.
     */
    static BigDecimal calculateInterest(final BigDecimal sumOfMoney) {
        if (notValid(sumOfMoney))
            return inMoneyFormat(BigDecimal.ZERO);
        if (sumOfMoney.compareTo(FIVE_THOUSAND) > 0)
            return calculate(THOUSAND, FIVE_THOUSAND.subtract(THOUSAND), sumOfMoney.subtract(FIVE_THOUSAND));
        return calculate(sumOfMoney);
    }

    private static boolean notValid(final BigDecimal sumOfMoney) {
        return (Objects.equals(null, sumOfMoney) || sumOfMoney.compareTo(BigDecimal.ZERO) < 0);
    }

    private static BigDecimal calculate(final BigDecimal amount) {
        if (amount.compareTo(THOUSAND) > 0) {
            return calculate(THOUSAND, amount.subtract(THOUSAND), BigDecimal.ZERO);
        } else {
            return calculate(amount, BigDecimal.ZERO, BigDecimal.ZERO);
        }
    }

    private static BigDecimal calculate(BigDecimal firstOneThousand, final BigDecimal between0neAndFiveThousand) {
        return calculate(THOUSAND, between0neAndFiveThousand, BigDecimal.ZERO);
    }

    private static BigDecimal calculate(final BigDecimal firstOneThousand,
                                        final BigDecimal between0neAndFiveThousand,
                                        final BigDecimal greaterThanFiveThousand) {
        return firstOneThousand.multiply(INTEREST_FIRST_THOUSAND)
                .add(between0neAndFiveThousand.multiply(INTEREST_BETWEEN_ONE_AND_FIVE_THOUSAND))
                .add(greaterThanFiveThousand.multiply(INTEREST_OVER_FIVE_THOUSAND))
                .setScale(2, RoundingMode.HALF_UP);
    }

    private static BigDecimal inMoneyFormat(final BigDecimal bigDecimal) {
        return bigDecimal.setScale(2, RoundingMode.HALF_UP);
    }

}
