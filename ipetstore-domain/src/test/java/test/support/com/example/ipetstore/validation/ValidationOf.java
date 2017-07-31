package test.support.com.example.ipetstore.validation;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import test.support.com.example.ipetstore.builders.Builder;

public class ValidationOf {

    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    public static Set<ConstraintViolation<Object>> validationOf(Builder<?> builder) {
        return validationOf(builder.build());
    }

    public static Set<ConstraintViolation<Object>> validationOf(Object bean) {
        return validator().validate(bean);
    }

    private static Validator validator() {
        return factory.getValidator();
    }
}
