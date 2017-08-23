package org.sapient.productcatalog.service;

import java.util.List;
import org.sapient.productcatalog.model.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductCatalogService {

  void addProduct(Product product);

  Product findProduct(Product product);

  List<Product> findProductsByType(String type);

  void removeProduct(Long productId);
}
