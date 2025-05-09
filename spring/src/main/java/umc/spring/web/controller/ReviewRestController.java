package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.service.ReviewService.ReviewCommandService;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mypage/reviews")
public class ReviewRestController {

    private final ReviewCommandService reviewService;

    @PostMapping
    public ApiResponse<ReviewResponseDTO.ReviewResultDTO> addReview(@RequestBody @Valid ReviewRequestDTO request) {
        Long userId = 1L; // 하드코딩
        Review review = reviewService.addReview(userId, request);
        return ApiResponse.onSuccess(ReviewConverter.toReviewResultDTO(review));
    }
}