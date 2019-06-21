package com.yodel;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class InputValidatorTest {

    @Test
    public void willFind1IsValid() {
        final String input = "1";
        assertThat(InputValidator.validate(input), is (true));
    }

    @Test
    public void willFindBigNumberIsValid() {
        final String input = "999999999.9999999999";
        assertThat(InputValidator.validate(input), is (true));
    }
    @Test
    public void willFindNegative1IsInvalid() {
        final String input = "-1";
        assertThat(InputValidator.validate(input), is (false));
    }

    @Test
    public void willFindAlphaNumberIsInvalid() {
        final String input = "One Thousand";
        assertThat(InputValidator.validate(input), is (false));
    }

    @Test
    public void willFindMalformedNumberIsInvalid() {
        final String input = "1000,0000.4.2";
        assertThat(InputValidator.validate(input), is (false));
    }
}
