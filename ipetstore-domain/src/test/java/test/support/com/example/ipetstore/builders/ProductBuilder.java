package test.support.com.example.ipetstore.builders;


import static test.support.com.example.ipetstore.builders.ProductNumberFaker.aProductNumber;

import com.example.ipetstore.domain.product.Attachment;
import com.example.ipetstore.domain.product.Product;

public class ProductBuilder implements Builder<Product> {

    private static final String DEFAULT_NAME = "a product";
    private String number = aProductNumber();
    private String name = DEFAULT_NAME;
    private String description;
    private Attachment photo;

    public static ProductBuilder aProduct() {
        return new ProductBuilder();
    }

    public static ProductBuilder aProduct(String productNumber) {
        return aProduct().withNumber(productNumber);
    }

    public ProductBuilder named(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder withoutAName() {
        return named(null);
    }

    public ProductBuilder describedAs(String description) {
		this.description = description;
		return this;
	}

    public ProductBuilder withNoDescription() {
        return describedAs(null);
    }

    public ProductBuilder withPhoto(String name) {
		this.photo = new Attachment(name);
		return this;
	}

    public ProductBuilder withoutAPhoto() {
        this.photo = null;
        return this;
    }

    public ProductBuilder withNumber(String number) {
    	this.number = number;
    	return this;
    }

    public ProductBuilder withoutANumber() {
        return withNumber(null);
    }


    public Product build() {
        Product product = new Product(number, name);
        product.setDescription(description);
        product.setPhoto(photo);
        return product;
    }
}
