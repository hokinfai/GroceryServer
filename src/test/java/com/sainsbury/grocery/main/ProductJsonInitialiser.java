package com.sainsbury.grocery.main;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.jsoup.nodes.Element;

import com.sainsbury.grocery.core.ProductDetailRetriever;
import com.sainsbury.grocery.data.DataRetriever;
import com.sainsbury.grocery.product.Product;
import com.sainsbury.grocery.service.FileReader;
import com.sainsbury.grocery.service.HtmlAnalyser;

public class ProductJsonInitialiser {

    public static void main(String[] args) throws IOException {
        DataRetriever.downloadPageHtml();
        String htmlFile = FileReader.readFileFrom("sainsburyGrocery.html");
        List<Element> products = HtmlAnalyser.extractHtmlElementsAsList(htmlFile, "div.productInfo");
        List<Element> productAnchor = HtmlAnalyser.getElementAttributesAsList(products, "a");
        List<String> productLink = HtmlAnalyser.getAttributeValueAsList(productAnchor, "href").stream()
                .filter(link -> link.startsWith("https://www.sainsburys.co.uk/")).collect(Collectors.toList());
        List<Product> productList = ProductDetailRetriever.getProductDetail(productLink);
        for (Product p : productList) {
            System.out.println(p.getTitle());
            System.out.println(p.getKcal_per_100g());
        }
        // String strNull = null;
        // Optional nullableOptional = Optional.ofNullable(strNull);
        // Object orElse = nullableOptional.orElse("abc");
        // System.out.println(orElse);
    }

}
