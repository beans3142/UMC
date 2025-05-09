package umc.spring.service.FoodCategoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.repository.FoodCategoryRepository.FoodCategoryRepository;

@Service
@RequiredArgsConstructor
public class FoodCategoryService {
    private final FoodCategoryRepository foodCategoryRepository;

    public boolean existsById(Long id) {
        return foodCategoryRepository.existsById(id);
    }
}
