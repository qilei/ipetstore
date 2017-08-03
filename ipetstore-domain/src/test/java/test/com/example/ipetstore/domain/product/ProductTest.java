package test.com.example.ipetstore.domain.product;

import static org.assertj.core.api.Assertions.allOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Sets.newLinkedHashSet;
import static org.testinfected.hamcrest.validation.ViolationMatchers.succeeds;
import static test.support.com.example.ipetstore.builders.ProductBuilder.aProduct;
import static test.support.com.example.ipetstore.validation.ValidationOf.validationOf;
import static test.support.com.example.ipetstore.validation.ViolationConditions.on;
import static test.support.com.example.ipetstore.validation.ViolationConditions.withError;

import java.util.Set;
import javax.validation.ConstraintViolation;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

/**
 * Created by qilei on 17/7/29.
 */
public class ProductTest {

  String SHOULD_NOT_BE_NULL = "{javax.validation.constraints.NotNull.message}";

  @Test
  public void isInvalidWithoutAName(){
    Set<ConstraintViolation<Object>> violations = validationOf(aProduct().named(null));

    assertThat(violations).have(allOf(on("name"), withError(SHOULD_NOT_BE_NULL)));
  }

  @Test public void
  isValidWithANameAndANumber() {
    Set<ConstraintViolation<Object>> violations = validationOf(aProduct());

    assertThat(violations).isEmpty();
  }
}