package umc.spring.handler;

import umc.spring.apiPayload.code.status.ErrorStatus;

public class FoodCategoryHandler extends RuntimeException {
    public FoodCategoryHandler(ErrorStatus status) {
        super(status.getMessage());
    }
}