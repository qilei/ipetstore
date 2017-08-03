package test.support.com.example.ipetstore.db;

import com.example.ipetstore.domain.product.ProductCatalog;

/**
 * Created by qilei on 17/7/30.
 */
public class Database {

  private ProductCatalog productCatalog;

  public Database(ProductCatalog productCatalog) {
    this.productCatalog = productCatalog;
  }

  public void clean(){
    productCatalog.clean();
  }

  public static Database connect(ProductCatalog productCatalog) {
    return new Database(productCatalog);
  }
}
