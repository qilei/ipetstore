package test.system.com.example.ipetstore;


import static org.assertj.core.api.Assertions.assertThat;
import static test.support.com.example.ipetstore.builders.ProductBuilder.aProduct;

import com.example.ipetstore.IpetstoreApp;
import com.example.ipetstore.domain.Product;
import java.io.IOException;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import support.com.example.ipetstore.web.ApplicationDriver;
import support.com.example.ipetstore.web.TestEnvironment;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = IpetstoreApp.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class SearchFeature {

  ApplicationDriver application;

  @Autowired
  private TestRestTemplate restTemplate;

  @Autowired
  private ApplicationContext applicationContext;

  @Before public void
  startApplication() throws Exception {
    application = new ApplicationDriver(TestEnvironment.load(applicationContext, restTemplate));
    application.start();
  }

  @After
  public void
  stopApplication() {
    application.stop();
  }

  @Test public void
  searchesForAProductNotAvailableInStore() throws Exception {
    application.addProduct("DOG-0001", "Labrador Retriever");
    List<Product> products = application.searchFor("Dalmatian");
    assertThat(products.size()).isEqualTo(0);
  }

  @Test public void
  searchesAndFindsProductsInCatalog() throws IOException {
    application.addProduct("DOG-0001", "Labrador Retriever");
    application.addProduct("DOG-0002", "Chesapeake", "Chesapeake bay retriever");
    application.addProduct("DOG-0003", "Dalmatian");

    List<Product> products = application.searchFor("retriever");
    assertThat(products.size()).isEqualTo(2);
    assertThat(products).containsExactlyInAnyOrder(
        aProduct("DOG-0001").named("Labrador Retriever").build()
        ,aProduct("DOG-0002").named("Chesapeake").describedAs("Chesapeake bay retriever").build()
    );
  }
}
