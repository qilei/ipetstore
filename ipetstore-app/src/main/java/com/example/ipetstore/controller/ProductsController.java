package com.example.ipetstore.controller;

import com.example.ipetstore.domain.product.Product;
import com.example.ipetstore.domain.product.ProductCatalog;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsController {

  @Autowired
  private ProductCatalog productCatalog;

  @RequestMapping(value = "/search", method = RequestMethod.GET)
  public List<Product> index(String keyword){
    return productCatalog.findByKeyword(keyword);
  }

  @RequestMapping(value = "/products", method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.CREATED)
  public Product create(@RequestBody @Valid Product product, HttpServletResponse response) {
    productCatalog.add(product);
    return product;
  }
}
