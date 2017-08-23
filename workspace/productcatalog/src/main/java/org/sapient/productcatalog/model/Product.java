package org.sapient.productcatalog.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "product_id")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "type")
  private String type;

  public Product() {
  }

  public Product(Long id, String name, String type) {
    this.id = id;
    this.name = name;
    this.type = type;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getType() {
    return type;
  }
}
