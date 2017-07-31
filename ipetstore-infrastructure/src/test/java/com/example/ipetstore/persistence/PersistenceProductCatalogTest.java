package com.example.ipetstore.persistence;

import static org.assertj.core.api.Assertions.assertThat;
import static test.support.com.example.ipetstore.builders.ProductBuilder.aProduct;

import com.example.ipetstore.domain.Product;
import com.example.ipetstore.domain.ProductCatalog;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@MybatisTest
@AutoConfigureTestDatabase(replace= Replace.NONE)
@Import(PersistenceProductCatalog.class)
public class PersistenceProductCatalogTest {

  @Autowired
  private ProductCatalog productCatalog;

  @Before
  public void setUp() throws Exception {

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void findByNumber() throws Exception {
    productCatalog.add(aProduct().withNumber("PRD-0001").build());
    Optional<Product> product = productCatalog.findByNumber("PRD-0001");

    assertThat(product.isPresent()).isTrue();
    assertThat(product.get().getNumber()).isEqualTo("PRD-0001");
  }

  @Test
  public void findNothingWhenNameAndDescDoNotMatch() throws Exception {
    productCatalog.add(aProduct().named("Dalmatian").describedAs("A big dog").build());

    Collection<Product> matchingProducts = productCatalog.findByKeyword("bulldog");

    assertThat(matchingProducts.size()).isEqualTo(0);
  }

  @Test
  public void findProductsByMatchingName(){
    Product product1 = aProduct().named("English Bulldog").build();
    productCatalog.add(product1);
    Product product2 = aProduct().named("French Bulldog").build();
    productCatalog.add(product2);
    Product product3 = aProduct().named("Labrador Retriever").build();
    productCatalog.add(product3);

    Collection<Product> matches = productCatalog.findByKeyword("bull");

    assertThat(matches.size()).isEqualTo(2);
    assertThat(matches).containsExactlyInAnyOrder(product1, product2);
  }

  @Test
  public void findProductsByMatchingDesc(){
    Product product1 = aProduct().named("Labrador").describedAs("Friendly").build();
    productCatalog.add(product1);
    Product product2 = aProduct().named("Golden").describedAs("Kids best friend").build();
    productCatalog.add(product2);
    Product product3 = aProduct().named("Poodle").describedAs("Annoying").build();
    productCatalog.add(product3);

    List<Product> matches = productCatalog.findByKeyword("friend");

    assertThat(matches.size()).isEqualTo(2);
    assertThat(matches).containsExactlyInAnyOrder(product1, product2);
  }

}