package com.example.ipetstore.domain.product;

/**
 * Created by qilei on 17/8/2.
 */
public class Attachment {

  private String fileName;

  public Attachment(String fileName) {
    this.fileName = fileName;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }
}
