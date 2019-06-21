package com.yodel;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Calculator {

    /**
     * These values represent the interest thresholds and rates.
     */
    private static final BigDecimal THOUSAND = new BigDecimal(1000);
    private static final BigDecimal FIVE_THOUSAND = new BigDecimal(5000);
    private static final BigDecimal FOUR_THOUSAND = FIVE_THOUSAND.subtract(THOUSAND);
    private static final BigDecimal INTEREST_FIRST_THOUSAND = new BigDecimal(0.01);
    private static final BigDecimal INTEREST_BETWEEN_ONE_AND_FIVE_THOUSAND = new BigDecimal(0.02);
    private static final BigDecimal INTEREST_OVER_FIVE_THOUSAND = new BigDecimal(0.03);

    /**
     * @param sumOfMoney How much money to calculate interest for.
     * @return How much interest will be accrued.
     */
    static BigDecimal calculateInterest(final BigDecimal sumOfMoney) {
        if (notValid(sumOfMoney))
            return inMoneyFormat(BigDecimal.ZERO);
        return inMoneyFormat(workOutInterest(sumOfMoney));
    }

    private static boolean notValid(final BigDecimal sumOfMoney) {
        return (Objects.equals(null, sumOfMoney) || sumOfMoney.compareTo(BigDecimal.ZERO) < 0);
    }

    private static BigDecimal workOutInterest(final BigDecimal sumOfMoney) {
        if (sumOfMoney.compareTo(FIVE_THOUSAND) <= 0)
            return calculateUpToFiveThousand(sumOfMoney);
        return calculate(THOUSAND, FOUR_THOUSAND, sumOfMoney.subtract(FIVE_THOUSAND));
    }

    private static BigDecimal calculateUpToFiveThousand(final BigDecimal amount) {
        if (amount.compareTo(THOUSAND) <= 0)
            return calculate(amount, BigDecimal.ZERO, BigDecimal.ZERO);
        return calculate(THOUSAND, amount.subtract(THOUSAND), BigDecimal.ZERO);
    }

    private static BigDecimal calculate(final BigDecimal firstOneThousand,
                                        final BigDecimal between0neAndFiveThousand,
                                        final BigDecimal greaterThanFiveThousand) {
        return firstOneThousand.multiply(INTEREST_FIRST_THOUSAND)
                .add(between0neAndFiveThousand.multiply(INTEREST_BETWEEN_ONE_AND_FIVE_THOUSAND))
                .add(greaterThanFiveThousand.multiply(INTEREST_OVER_FIVE_THOUSAND));
    }

    private static BigDecimal inMoneyFormat(final BigDecimal bigDecimal) {
        return bigDecimal.setScale(2, RoundingMode.HALF_UP);
    }

}
