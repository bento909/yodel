package com.yodel;

import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class InputTranslatorTest {

    @Test
    public void shouldConvertStringToBigDecimal() {
        final String input = "123.45";
        final BigDecimal expected = new BigDecimal(input);
        assertThat(InputTranslator.translate(input), is(expected));
    }

    @Test
    public void shouldConvertStringWithHighPrecisionToBigDecimal() {
        final String input = "123.4567890";
        final BigDecimal expected = new BigDecimal(input);
        assertThat(InputTranslator.translate(input), is(expected));
    }

    @Test
    public void shouldGetZeroFromAlphaString() {
        final String input = "abcd";
        assertThat(InputTranslator.translate(input), is(BigDecimal.ZERO));
    }

    @Test
    public void shouldGetZeroFromBadNumericString() {
        final String input = "123.456.567";
        assertThat(InputTranslator.translate(input), is(BigDecimal.ZERO));
    }
}