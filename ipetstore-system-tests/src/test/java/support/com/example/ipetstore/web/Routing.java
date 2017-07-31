package support.com.example.ipetstore.web;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by qilei on 17/7/31.
 */
public class Routing {

//  private String baseUrl;
//
//  public Routing(String baseUrl) {
//    this.baseUrl = baseUrl;
//  }

  public URI toProducts() throws MalformedURLException {
    return urlFor("/products");
  }

  public URI urlFor(String path) throws MalformedURLException {
    try {
      return new URI(path);
    } catch (URISyntaxException e) {
      e.printStackTrace();
      return null;
    }
  }

}
