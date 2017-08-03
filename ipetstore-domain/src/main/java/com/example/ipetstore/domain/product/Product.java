package com.example.ipetstore.domain.product;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

public class Product implements Serializable {

  public static final String MISSING_PHOTO = "missing.png";

  private Long id;

  private String number;

  @NotNull
  private String name;

  private String description;

  private Attachment photo;

  public Product() {
  }

  public Product(String number, String name) {
    this.number = number;
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Product product = (Product) o;

    if (number != null ? !number.equals(product.number) : product.number != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return number != null ? number.hashCode() : 0;
  }

  @Override
  public String toString() {
    return number + " (" + name + ")";
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Attachment getPhoto() {
    return photo;
  }

  public void setPhoto(Attachment photo) {
    this.photo = photo;
  }
}
