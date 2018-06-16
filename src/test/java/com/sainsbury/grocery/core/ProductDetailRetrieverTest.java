package com.sainsbury.grocery.core;

import static com.google.common.base.Charsets.UTF_8;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.google.common.io.Resources;
import com.sainsbury.grocery.product.Product;

public class ProductDetailRetrieverTest {

    @Test
    public void assertProductObjectIsGeneratedFromUrl() throws IOException {
        String[] productUrls = {
                "https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk/shop/gb/groceries/berries-cherries-currants/sainsburys-strawberries--taste-the-difference-300g.html" };
        List<Product> products = ProductDetailRetriever.getProductDetail(Arrays.asList(productUrls));
        assertThat(products.get(0).getTitle(), is("Sainsbury's Strawberries, Taste the Difference 300g"));
        assertThat(products.get(0).getDescription(), is("Ttd strawberries"));
        assertThat(products.get(0).getUnit_price(), is(2.50));
        assertThat(products.get(0).getKcal_per_100g(), is(33));
    }

    @Test
    public void assertCorrectProductTitle() throws IOException {
        String title = ProductDetailRetriever
                .getProductTitle(Resources.toString(Resources.getResource("exampleProductDetails.html"), UTF_8));
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
        int price = ProductDetailRetriever
                .getProductCalories(Resources.toString(Resources.getResource("exampleProductDetails.html"), UTF_8));
        assertThat(price, is(32));
    }

    @Test
    public void assertZeroIsReturnWhenProductCaloriesIsNotAvailable() throws IOException {
        int price = ProductDetailRetriever
                .getProductCalories(Resources.toString(Resources.getResource("exampleProductDetailsWithoutCalories.html"), UTF_8));
        assertThat(price, is(0));
    }

}
