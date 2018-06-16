package com.sainsbury.grocery.core;

import static com.google.common.base.Charsets.UTF_8;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.Test;

import com.google.common.io.Resources;

public class ProductDetailRetrieverTest {

    @Test
    public void assertCorrectProductTitle() throws IOException {
        String title = ProductDetailRetriever.getProductTitle(Resources.toString(Resources.getResource("exampleProductDetails.html"), UTF_8));
        assertThat(title, is("Sainsbury's Raspberries, Taste the Difference 150g"));
    }

    @Test
    public void assertCorrectProductDescription() throws IOException {
        String description = ProductDetailRetriever
                .getProductDescription(Resources.toString(Resources.getResource("exampleProductDetails.html"), UTF_8));
        assertThat(description, is("Ttd raspberries"));
    }

    @Test
    public void assertCorrectProductPrice() throws IOException {
        Double price = ProductDetailRetriever.getProductPrice(Resources.toString(Resources.getResource("exampleProductDetails.html"), UTF_8));
        assertThat(price, is(2.50));
    }

    @Test
    public void assertCorrectProductCalories() throws IOException {
        String price = ProductDetailRetriever
                .getProductCalories(Resources.toString(Resources.getResource("exampleProductDetails.html"), UTF_8));
        assertThat(price, is("32"));
    }

}
