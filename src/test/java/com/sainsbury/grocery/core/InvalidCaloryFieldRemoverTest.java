package com.sainsbury.grocery.core;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class InvalidCaloryFieldRemoverTest {

    @Test
    public void assertNegativeCaloriesAreStripedOff() {
        String singleProductJsonWithInvalidCalonies = "{\"title\":\"Sainsbury\u0027s British Cherry \u0026 Strawberry Pack 600g\",\"kcal_per_100g\":-1,\"unit_price\":4.0,\"description\":\"British Cherry \u0026 Strawberry Mixed Pack\"}";
        String expectProductJson = "{\"title\":\"Sainsbury\u0027s British Cherry \u0026 Strawberry Pack 600g\",\"unit_price\":4.0,\"description\":\"British Cherry \u0026 Strawberry Mixed Pack\"}";
        String result = InvalidCaloriesFieldRemover.removeInvalidCaloriesField(singleProductJsonWithInvalidCalonies);
        assertThat(result, is(expectProductJson));

    }

}
