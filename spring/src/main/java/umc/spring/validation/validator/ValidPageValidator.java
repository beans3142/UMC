package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.exception.handler.PageHandler;

@Component
public class ValidPageValidator implements ConstraintValidator<umc.spring.validation.annotation.ValidPage, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null) return false;
        if (value <= 0) {
            throw new PageHandler();
        }
        return true;
    }
}