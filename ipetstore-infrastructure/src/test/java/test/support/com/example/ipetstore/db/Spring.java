package test.support.com.example.ipetstore.db;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.ApplicationContext;

/**
 * Created by qilei on 17/7/31.
 */
public class Spring {

  private ApplicationContext applicationContext;
  private TestRestTemplate restTemplate;

  public Spring(ApplicationContext applicationContext,
      TestRestTemplate restTemplate) {
    this.applicationContext = applicationContext;
    this.restTemplate = restTemplate;
  }

  public <T> T getBean(Class<T> type){
    return applicationContext.getBean(type);
  }

  public TestRestTemplate getRestTemplate() {
    return restTemplate;
  }
}
