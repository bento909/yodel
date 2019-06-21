package com.yodel;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

    @Test
    public void willFindThat100GainsInInterestOf1() {
        final BigDecimal expected = new BigDecimal(1).setScale(2, RoundingMode.HALF_UP);
        final BigDecimal actual = Calculator.calculateInterest(new BigDecimal(100));
        assertThat(actual, is(expected));
    }

    @Test
    public void willFindThat4500GainsInInterestOf80() {
        final BigDecimal expected = new BigDecimal(80).setScale(2, RoundingMode.HALF_UP);
        final BigDecimal actual = Calculator.calculateInterest(new BigDecimal(4500));
        assertThat(actual, is(expected));
    }

    @Test
    public void willFindThat6400GainsAnInterestOf132() {
        final BigDecimal expected = new BigDecimal(132).setScale(2, RoundingMode.HALF_UP);
        final BigDecimal actual = Calculator.calculateInterest(new BigDecimal(6400));
        assertThat(actual, is(expected));
    }

    @Test
    public void willFindThatZeroGainsInterestOfZero() {
        final BigDecimal expected = new BigDecimal(0).setScale(2, RoundingMode.HALF_UP);
        final BigDecimal actual = Calculator.calculateInterest(BigDecimal.ZERO);
        assertThat(actual, is(expected));
    }

    @Test
    public void willFindThatNegativeGainsInterestOfZero() {
        final BigDecimal expected = new BigDecimal(0).setScale(2, RoundingMode.HALF_UP);
        final BigDecimal actual = Calculator.calculateInterest(BigDecimal.ONE.negate());
        assertThat(actual, is(expected));
    }

    @Test
    public void willFindThatNullReturnsInterestOfZero() {
        final BigDecimal expected = new BigDecimal(0).setScale(2, RoundingMode.HALF_UP);
        final BigDecimal actual = Calculator.calculateInterest(null);
        assertThat(actual, is(expected));
    }

}
