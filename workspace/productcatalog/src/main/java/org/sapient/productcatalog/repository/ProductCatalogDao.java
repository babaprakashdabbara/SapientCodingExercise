package org.sapient.productcatalog.repository;

import java.util.List;
import org.sapient.productcatalog.model.Product;

public interface ProductCatalogDao {

  void addProduct(Product product);

  List<Product> findAllProductsByType(String productType);

  Product findProduct(Long productId);

  void deleteProduct(Long productId);
}
