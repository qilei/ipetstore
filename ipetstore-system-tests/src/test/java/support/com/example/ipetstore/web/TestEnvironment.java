package support.com.example.ipetstore.web;

import com.example.ipetstore.domain.product.ProductCatalog;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.ApplicationContext;
import test.support.com.example.ipetstore.db.Database;
import test.support.com.example.ipetstore.db.Spring;

public class TestEnvironment {

  private final Spring spring;
  private final Routing adminRoutes;

  public TestEnvironment(ApplicationContext applicationContext, TestRestTemplate restTemplate) {
    spring = new Spring(applicationContext, restTemplate);
    adminRoutes = new Routing();
  }

  public static TestEnvironment load(ApplicationContext applicationContext, TestRestTemplate restTemplate) {
    return new TestEnvironment(applicationContext, restTemplate);
  }

  public void wipe() {
    Database database = Database.connect(spring.getBean(ProductCatalog.class));
    database.clean();
  }

  public Routing adminRoutes() {
    return adminRoutes;
  }

  public TestRestTemplate restTemplate(){
    return spring.getRestTemplate();
  }

}
