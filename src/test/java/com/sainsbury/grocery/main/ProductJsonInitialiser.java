package com.sainsbury.grocery.main;

import java.io.IOException;
import java.util.List;

import org.jsoup.nodes.Element;

import com.sainsbury.grocery.data.DataRetriever;
import com.sainsbury.grocery.service.FileReader;
import com.sainsbury.grocery.service.HtmlAnalyser;

public class ProductJsonInitialiser {

    public static void main(String[] args) throws IOException {
        DataRetriever.downloadPageHtml();
        String htmlFile = FileReader.readFileFrom("sainsburyGrocery.html");
        List<Element> products = HtmlAnalyser.extractHtmlElementsAsList(htmlFile, "div.productInfo");
        List<Element> productAnchor = HtmlAnalyser.getElementAttributesAsList(products, "a");
        List<String> productLink = HtmlAnalyser.getAttributeValueAsList(productAnchor, "href");
        System.out.println(productLink);
    }

}
