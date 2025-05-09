package umc.spring.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Store;
import umc.spring.domain.Review;
import umc.spring.handler.ReviewHandler;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.repository.ReviewRepository.ReviewRepository;
import umc.spring.web.dto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public Review addReview(Long userId, ReviewRequestDTO request) {
        Member member = memberRepository.findById(userId)
                .orElseThrow(() -> new ReviewHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new ReviewHandler(ErrorStatus.STORE_NOT_FOUND));
        Review review = ReviewConverter.toReview(request, member, store);

        return reviewRepository.save(review);
    }
}