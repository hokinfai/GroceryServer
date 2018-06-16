package com.sainsbury.grocery.service;

import static com.google.common.base.Charsets.UTF_8;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;

import com.google.common.io.Resources;

public class HtmlAnalyserTest {

    @Test
    public void assertProductInfoAreExtracted() throws IOException {
        List<Element> htmlElements = HtmlAnalyser.extractHtmlElementsAsList(Resources.toString(Resources.getResource("exampleProduct.html"), UTF_8),
                "div.productInfo");
        assertThatEachElementContainsString(htmlElements, "productInfo");
    }

    @Test
    public void assertProductDetailsAreExtracted() throws IOException {
        String htmlElements = HtmlAnalyser.extractSingleHtmlElement(
                Resources.toString(Resources.getResource("exampleProductDetails.html"), UTF_8),
                "div.productContent div.productTitleDescriptionContainer h1");
        assertThat(htmlElements, is("Sainsbury's Raspberries, Taste the Difference 150g"));
    }

    @Test
    public void assertProductLinkAttributesAreExtracted() throws IOException {
        Document doc = Jsoup.parse(Resources.toString(Resources.getResource("exampleProductInfo.html"), UTF_8));
        Element link = doc.select("div.productInfo").first();
        List<Element> attrbuite = HtmlAnalyser.getElementAttributesAsList(Arrays.asList(link), "a");
        assertThatEachElementContainsString(attrbuite, "a href");
    }

    @Test
    public void assertProductUrlsAreExtracted() throws IOException {
        Document doc = Jsoup.parse(Resources.toString(Resources.getResource("exampleProductLink.html"), UTF_8));
        Element link = doc.select("a").first();
        List<String> attrbuite = HtmlAnalyser.getAttributeValueAsList(Arrays.asList(link), "href");
        assertThat(attrbuite.get(0), containsString("www"));
    }

    private void assertThatEachElementContainsString(List<Element> htmlElements, String expectedString) {
        assertThat(htmlElements.stream().allMatch(htmlElement -> htmlElement.toString().contains(expectedString)), is(true));
    }

}
