package umc.spring.web.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import umc.spring.validation.annotation.ExistStore;

@Getter
public class ReviewRequestDTO {
    @ExistStore
    private Long storeId;

    @Min(1) @Max(5)
    private float score;

    @NotBlank
    private String content;
}