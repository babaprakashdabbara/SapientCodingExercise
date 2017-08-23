package org.sapient.productcatalog.service;

import java.util.List;
import org.sapient.productcatalog.model.Product;
import org.sapient.productcatalog.repository.ProductCatalogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCatalogServiceImpl implements ProductCatalogService {

  private ProductCatalogDao productCatalogDao;

  @Autowired
  public ProductCatalogServiceImpl(ProductCatalogDao productCatalogDao) {
    this.productCatalogDao = productCatalogDao;
  }

  @Override
  public void addProduct(Product product) {
    productCatalogDao.addProduct(product);
  }

  @Override
  public Product findProduct(Product product) {
    return productCatalogDao.findProduct(product.getId());
  }

  @Override
  public List<Product> findProductsByType(String type) {
    return productCatalogDao.findAllProductsByType(type);
  }

  @Override
  public void removeProduct(Long productId) {
    productCatalogDao.deleteProduct(productId);
  }
}
