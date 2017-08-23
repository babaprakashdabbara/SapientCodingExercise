package org.sapient.productcatalog.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.sapient.productcatalog.model.Product;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ProductCatalogDaoImpl implements ProductCatalogDao {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public void addProduct(Product product) {
    entityManager.persist(product);
  }

  @Override
  public Product findProduct(Long productId) {
    return entityManager.find(Product.class, productId);
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Product> findAllProductsByType(String productType) {
    return (List<Product>) entityManager.createQuery("FROM Product as product WHERE product" +
        ".type ='" + productType +"'").getResultList();
  }

  @Override
  public void deleteProduct(Long productId) {
    entityManager.remove(findProduct(productId));
  }
}
