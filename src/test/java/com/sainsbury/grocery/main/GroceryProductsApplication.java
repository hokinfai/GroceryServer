package com.sainsbury.grocery.main;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.jsoup.nodes.Element;

import com.sainsbury.grocery.core.GrossCalculator;
import com.sainsbury.grocery.core.InvalidCaloriesFieldRemover;
import com.sainsbury.grocery.core.ProductDetailRetriever;
import com.sainsbury.grocery.data.DataRetriever;
import com.sainsbury.grocery.pojo.GroceryProducts;
import com.sainsbury.grocery.pojo.Product;
import com.sainsbury.grocery.pojo.ProductGross;
import com.sainsbury.grocery.service.FileController;
import com.sainsbury.grocery.service.HtmlAnalyser;

public class GroceryProductsApplication {

    public static void main(String[] args) throws IOException {
        boolean isPageUpdated = false;
        DataRetriever.downloadPageHtml(isPageUpdated, "sainsburyGrocery.html");
        String htmlFile = FileController.readFileFrom("sainsburyGrocery.html");
        List<Element> products = HtmlAnalyser.extractHtmlElementsAsList(htmlFile, "div.productInfo");
        List<Element> productAnchor = HtmlAnalyser.getElementAttributesAsList(products, "a");
        List<String> productLink = HtmlAnalyser.getAttributeValueAsList(productAnchor, "href").stream()
                .map(link -> link.replace("../../../../../..",
                        "https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk"))
                .collect(Collectors.toList());
        List<Product> productList = ProductDetailRetriever.getProductDetail(productLink);
        GrossCalculator grossCalculator = new GrossCalculator(productList);
        ProductGross fields = new ProductGross(grossCalculator.getGross(), grossCalculator.getVat());
        String result = InvalidCaloriesFieldRemover.removeInvalidCaloriesField(FileController.writeAsJson(new GroceryProducts(productList, fields)));
        System.out.println(result);
        FileController.saveFileAsResources(result, "result.json");
    }
}
