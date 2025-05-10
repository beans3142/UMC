package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.code.exception.handler.FoodCategoryHandler;
import umc.spring.service.FoodCategoryService.FoodCategoryService;
import umc.spring.validation.annotation.ExistFoodCategory;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ExistFoodCategoryValidator implements ConstraintValidator<ExistFoodCategory, List<Long>> {

    private final FoodCategoryService foodCategoryService;

    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
        boolean isValid = values.stream()
                .allMatch(foodCategoryService::existsById);

        if (!isValid) {
            throw new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND);
        }

        return true;
    }
}