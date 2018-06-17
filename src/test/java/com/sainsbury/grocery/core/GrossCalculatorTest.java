package com.sainsbury.grocery.core;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.sainsbury.grocery.pojo.Product;

public class GrossCalculatorTest {
    private final static Product[] product = { new Product("", 1, 12.3, ""), new Product("", 1, 12.3, "") };
    private GrossCalculator grossCalculator;

    @Before
    public void setup() {
        grossCalculator = new GrossCalculator(Arrays.asList(product));
    }

    @Test
    public void assertCorrectGrossValue() {
        Double gross = grossCalculator.getGross();
        assertThat(gross, is(24.6));
    }

    @Test
    public void assertCorrectVatValue() {
        Double gross = grossCalculator.getVat();
        assertThat(gross, is(4.92));
    }

}
