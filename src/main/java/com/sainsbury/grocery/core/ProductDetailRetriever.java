package com.sainsbury.grocery.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;

import com.sainsbury.grocery.httpclient.HttpResponseBody;
import com.sainsbury.grocery.httpclient.HttpResponseStatus;
import com.sainsbury.grocery.httpclient.RequestFactory;
import com.sainsbury.grocery.product.Product;
import com.sainsbury.grocery.service.HtmlAnalyser;

public class ProductDetailRetriever {
    public static List<Product> getProductDetail(List<String> productUrls) throws IOException {
        List<Product> products = new ArrayList<>();
        HttpClient client = HttpClientBuilder.create().build();
        for (String url : productUrls) {
            String productDetail = getProductDetailPage(client, url);
            String title = getProductTitle(productDetail);
            String description = getProductDescription(productDetail);
            Double price = getProductPrice(productDetail);
            String calories = getProductCalories(productDetail);
            products.add(new Product(title, calories, price, description));
        }
        return products;
    }

    private static String getProductDetailPage(HttpClient client, String url) throws IOException, ClientProtocolException {
        HttpUriRequest request = RequestFactory.createGet(url);
        HttpResponse response = client.execute(request);
        HttpResponseStatus.assertOk(response);
        return HttpResponseBody.toString(response);
    }

    public static String getProductTitle(String productHtml) {
        String productTitle = HtmlAnalyser.extractSingleHtmlElement(productHtml,
                "div.productContent div.productTitleDescriptionContainer h1", 0);
        return productTitle;
    }

    public static String getProductDescription(String productHtml) {
        String productDescription = HtmlAnalyser.extractSingleHtmlElement(productHtml,
                "div.productContent div.productText p", 0);
        return productDescription;
    }

    public static Double getProductPrice(String productHtml) {
        String productPrice = HtmlAnalyser.extractSingleHtmlElement(productHtml,
                "div.pricing p.pricePerUnit", 0);
        Double price = Double.parseDouble(productPrice.replaceAll("£", "").replaceAll("/unit", ""));
        return price;
    }

    public static String getProductCalories(String productHtml) {
        String productCalories = HtmlAnalyser.extractSingleHtmlElement(productHtml,
                "table.nutritionTable tr td", 2);
        String kcal = productCalories.replaceAll("kcal", "");
        return kcal.trim();
    }
}
