package com.sainsbury.grocery.product;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class ProductTest {
    private Product strawberry;

    @Before
    public void setup() {
        strawberry = new Product("Sainsbury's Strawberries 400g", 1, 1.75, "by Sainsbury's strawberries");
    }

    @Test
    public void assertCorrectProductTitle() {
        assertThat(strawberry.getTitle(), is("Sainsbury's Strawberries 400g"));
    }

    @Test
    public void assertCorrectProductDescription() {
        assertThat(strawberry.getDescription(), is("by Sainsbury's strawberries"));
    }

    @Test
    public void assertCorrectProductPrice() {
        assertThat(strawberry.getUnit_price(), is(1.75));
    }

    @Test
    public void assertCorrectProductCalories() {
        assertThat(strawberry.getKcal_per_100g(), is(1));
    }

}
