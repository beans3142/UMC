package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MemberMissionService.MemberMissionCommandService;
import umc.spring.service.MemberMissionService.MemberMissionQueryService;
import umc.spring.validation.annotation.ValidPage;
import umc.spring.web.dto.MemberMission.MemberMissionRequestDTO;
import umc.spring.web.dto.MemberMission.MemberMissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mypage/missions/challenge")
public class MemberMissionRestController {

    private final MemberMissionCommandService MemberMissionService;
    private final MemberMissionQueryService memberMissionQueryService;

    @PostMapping
    public ApiResponse<MemberMissionResponseDTO.MemberMissionResultDTO> challengeMission(@RequestBody @Valid MemberMissionRequestDTO request) {
        Long userId = 1L; // 하드코딩
        MemberMission challenge = MemberMissionService.challengeMission(userId, request);
        return ApiResponse.onSuccess(MemberMissionConverter.toMemberMissionResultDTO(challenge));
    }

    @GetMapping
    @Operation(summary = "내가 진행중인 미션 목록 조회", description = "로그인한 사용자의 진행중 미션 목록을 페이징으로 조회합니다.")
    public ApiResponse<MemberMissionResponseDTO.MemberMissionListDTO> getMyOngoingMissions(
            @Valid @ValidPage @RequestParam(name = "page") Integer page
            //, @CurrentMember Member member (로그인 정보 추출 방식에 따라 추가)
    ) {
        Long memberId = 1L; // 실제로는 인증에서 추출
        Page<MemberMission> missionPage = memberMissionQueryService.getMyOngoingMissions(memberId, page);
        return ApiResponse.onSuccess(MemberMissionConverter.toMemberMissionListDTO(missionPage));
    }
}