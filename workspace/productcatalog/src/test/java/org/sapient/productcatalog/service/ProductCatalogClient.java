package org.sapient.productcatalog.service;

import java.net.URI;
import org.sapient.productcatalog.model.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ProductCatalogClient {

  public void addProductTest() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    RestTemplate restTemplate = new RestTemplate();
    String url = "http://localhost:8080/productCatalog/addProduct";
    Product product = new Product(123L, "Test", "PROD");
    HttpEntity<Product> requestEntity = new HttpEntity<Product>(product, headers);
    System.out.println(requestEntity.getHeaders().getAccept());
  }

  public void getProductsByTypeTest() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    RestTemplate restTemplate = new RestTemplate();
    String url = "http://localhost:8080/productCatalog/getProducts/{productType}";
    HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
    ResponseEntity<Product[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET,
        requestEntity, Product[].class, "PROD");
    Product[] products = responseEntity.getBody();
    for (Product product : products) {
      System.out.println("Product Id:" + product.getId() + ", Name:" + product.getName() + ", Type: " +
          "" + product.getType());
    }
  }

  public void deleteProductType() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    RestTemplate restTemplate = new RestTemplate();
    String url = "http://localhost:8080/productCatalog/{id}";
    HttpEntity<Product> requestEntity = new HttpEntity<Product>(headers);
    restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 123);
  }

  public static void main(String args[]) {
    ProductCatalogClient productCatalogClient = new ProductCatalogClient();
    productCatalogClient.addProductTest();
    productCatalogClient.getProductsByTypeTest();
    productCatalogClient.deleteProductType();
  }
}
