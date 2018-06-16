package com.sainsbury.grocery.service;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sainsbury.grocery.data.DataRetriever;

public class HtmlAnalyser {
    private static final String BASE_URI = DataRetriever.URL_HOST + DataRetriever.URL_PATH;

    public static List<Element> extractHtmlElements(String html, String cssQuery) {
        List<Element> htmlElements = new ArrayList<Element>();
        Document doc = Jsoup.parse(html, BASE_URI);
        Elements elements = doc.select(cssQuery);
        elements.stream().forEach(element -> htmlElements.add(element));
        return htmlElements;
    }

    public static List<Element> getElementAttributes(List<Element> elements, String attribute) {
        List<Element> productAttributes = new ArrayList<>();
        elements.stream().forEach(ele -> productAttributes.add(ele.select(attribute).first()));
        return productAttributes;
    }

    public static List<String> getAttributeValue(List<Element> productAttributes, String cssQuery) {
        List<String> attributes = new ArrayList<>();
        productAttributes.stream().forEach(ele -> attributes.add(ele.attr(cssQuery).toString()));
        return attributes;
    }
}
