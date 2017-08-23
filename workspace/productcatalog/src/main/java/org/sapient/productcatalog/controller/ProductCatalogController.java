package org.sapient.productcatalog.controller;

import java.util.List;
import org.sapient.productcatalog.model.Product;
import org.sapient.productcatalog.service.ProductCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "productCatalog")
public class ProductCatalogController {

  private ProductCatalogService productCatalogService;

  @Autowired
  public ProductCatalogController(ProductCatalogService productCatalogService) {
    this.productCatalogService = productCatalogService;
  }

  @PostMapping(value = "/addProduct")
  public ResponseEntity<Void> addProduct(@RequestBody Product product) {
    boolean flag = isExistingProduct(product);
    if (flag) {
      return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
    productCatalogService.addProduct(product);
    HttpHeaders headers = new HttpHeaders();
    return new ResponseEntity<>(headers, HttpStatus.CREATED);
  }

  @GetMapping(value = "/getProducts/{productType}")
  public ResponseEntity<List<Product>> findProductsByType(@PathVariable("productType") String productType) {
    return new ResponseEntity<>(productCatalogService.findProductsByType(productType), HttpStatus.OK);
  }

  @DeleteMapping(value = "/removeProduct/{id}")
  public ResponseEntity removeProductById(@PathVariable("id") Long productId) {
    productCatalogService.removeProduct(productId);
    return new ResponseEntity(HttpStatus.NO_CONTENT);
  }

  private boolean isExistingProduct(Product product) {
    return productCatalogService.findProduct(product) != null;
  }
}
