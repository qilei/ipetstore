package com.example.ipetstore.domain.product;

import java.util.List;
import java.util.Optional;

public interface ProductCatalog {

	Optional<Product> findByNumber(String number);

	List<Product> findByKeyword(String keyword);

	void add(Product product);

	void clean();
}
