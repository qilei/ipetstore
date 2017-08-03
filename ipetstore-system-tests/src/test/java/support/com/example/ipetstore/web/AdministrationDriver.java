package support.com.example.ipetstore.web;

import static org.assertj.core.api.Assertions.assertThat;
import static test.support.com.example.ipetstore.builders.ProductBuilder.aProduct;

import com.example.ipetstore.domain.product.Product;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Created by qilei on 17/7/31.
 */
public class AdministrationDriver {

  private TestRestTemplate restTemplate;
  private Routing routing;

  public AdministrationDriver(TestRestTemplate restTemplate,
      Routing routing) {
    this.restTemplate = restTemplate;
    this.routing = routing;
  }

  public void addProduct(String number, String name, String description)
      throws MalformedURLException {
    ResponseEntity<Product> responseEntity = restTemplate.postForEntity(routing.toProducts().getPath(),
        aProduct(number).named(name).describedAs(description).build(), Product.class);
    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
  }

  public List<Product> searchFor(String keyword) {
    ResponseEntity<Product[]> responseEntity = restTemplate
        .getForEntity("/search?keyword=" + keyword, Product[].class);
    Product[] products = responseEntity.getBody();
    return Arrays.asList(products);
  }
}
