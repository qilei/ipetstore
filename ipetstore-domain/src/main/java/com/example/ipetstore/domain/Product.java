package com.example.ipetstore.domain;

import java.io.Serializable;

public class Product implements Serializable {

  public static final String MISSING_PHOTO = "missing.png";

  private Long id;

  private String number;

  private String name;

  private String description;

  private String photoFileName;

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

  public String getPhotoFileName() {
    return photoFileName;
  }

  public void setPhotoFileName(String photoFileName) {
    this.photoFileName = photoFileName;
  }
}
