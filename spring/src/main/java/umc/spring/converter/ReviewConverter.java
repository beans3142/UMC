package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.Review.ReviewRequestDTO;
import umc.spring.web.dto.Review.ReviewResponseDTO;

import java.util.stream.Collectors;

public class ReviewConverter {
    public static Review toReview(ReviewRequestDTO dto, Member member, Store store) {
        return Review.builder()
                .member(member)
                .store(store)
                .score(dto.getScore())
                .content(dto.getContent())
                .build();
    }
    public static ReviewResponseDTO.ReviewResultDTO toReviewResultDTO(Review review) {
        return ReviewResponseDTO.ReviewResultDTO.builder()
                .reviewId(review.getId())
                .memberId(review.getMember().getId())
                .storeId(review.getStore().getId())
                .score(review.getScore())
                .content(review.getContent())
                .createdAt(review.getCreatedAt())
                .build();
    }

    public static ReviewResponseDTO.ReviewListDTO toReviewListDTO(Page<Review> reviewPage) {
        return ReviewResponseDTO.ReviewListDTO.builder()
                .reviewList(
                        reviewPage.stream()
                                .map(ReviewConverter::toReviewResultDTO)
                                .collect(Collectors.toList())
                )
                .totalPage(reviewPage.getTotalPages())
                .totalElements(reviewPage.getTotalElements())
                .isFirst(reviewPage.isFirst())
                .isLast(reviewPage.isLast())
                .listSize(reviewPage.getNumberOfElements())
                .build();
    }
}