package support.com.example.ipetstore.web;

import com.example.ipetstore.domain.product.Product;
import java.io.IOException;
import java.util.List;

public class ApplicationDriver {

  private TestEnvironment environment;
  private AdministrationDriver admin;

  public ApplicationDriver(TestEnvironment testEnvironment) {
    this.environment = testEnvironment;
  }

  public void start() {
    cleanupEnvironment();
    makeDrivers();
  }

  private void makeDrivers() {
    admin = new AdministrationDriver(environment.restTemplate(), environment.adminRoutes());
  }

  private void cleanupEnvironment() {
    environment.wipe();
  }

  public void stop() {

  }

  public void addProduct(String number, String name) throws IOException {
    addProduct(number, name, "");
  }

  public void addProduct(String number, String name, String description) throws IOException {
    admin.addProduct(number, name, description);
  }

  public List<Product> searchFor(String keyword) {
    return admin.searchFor(keyword);
  }

  public void showsNoResult() {

  }
}
