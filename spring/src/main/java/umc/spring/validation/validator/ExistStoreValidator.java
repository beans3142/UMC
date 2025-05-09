package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.validation.annotation.ExistStore;

@Component
@RequiredArgsConstructor
public class ExistStoreValidator implements ConstraintValidator<ExistStore, Long> {
    private final StoreRepository placeRepository;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        return value != null && placeRepository.existsById(value);
    }
}