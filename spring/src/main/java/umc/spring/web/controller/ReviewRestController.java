package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.repository.ReviewRepository.ReviewRepository;
import umc.spring.web.dto.Review.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mypage/reviews")
public class ReviewRestController {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;

    @GetMapping("/members/{memberId}")
    @Operation(summary = "내가 작성한 리뷰 목록 조회 API", description = "특정 회원이 작성한 리뷰 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함"),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "회원의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호, 1부터 시작")
    })
    public ApiResponse<ReviewResponseDTO.ReviewListDTO> getMyReviews(
            @PathVariable(name = "memberId") Long memberId,
            @RequestParam(name = "page") Integer page) {

        if (page == null || page < 1) {
            throw new IllegalArgumentException("page 파라미터는 1 이상이어야 합니다.");
        }

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));
        Page<Review> reviewPage = reviewRepository.findAllByMember(member, PageRequest.of(page - 1, 10));
        return ApiResponse.onSuccess(ReviewConverter.toReviewListDTO(reviewPage));
    }

}