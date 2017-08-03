package test.support.com.example.ipetstore.validation;

import javax.validation.ConstraintViolation;
import org.assertj.core.api.Condition;
import org.assertj.core.condition.AllOf;

public class ViolationConditions {

  public static Condition<ConstraintViolation> on(String path){
    return new Condition<ConstraintViolation>() {
      @Override
      public boolean matches(ConstraintViolation violation) {
        return violation.getPropertyPath().toString().equalsIgnoreCase(path);
      }
    };
  }

  public static Condition<ConstraintViolation> withError(String msg) {
    return new Condition<ConstraintViolation>() {
      @Override
      public boolean matches(ConstraintViolation violation) {
        return violation.getMessageTemplate().equalsIgnoreCase(msg);
      }
    };
  }

}
