package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MemberMissionService.MemberMissionCommandService;
import umc.spring.web.dto.MemberMission.MemberMissionRequestDTO;
import umc.spring.web.dto.MemberMission.MemberMissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mypage/missions/challenge")
public class MemberMissionRestController {

    private final MemberMissionCommandService MemberMissionService;

    @PostMapping
    public ApiResponse<MemberMissionResponseDTO.MemberMissionResultDTO> challengeMission(@RequestBody @Valid MemberMissionRequestDTO request) {
        Long userId = 1L; // 하드코딩
        MemberMission challenge = MemberMissionService.challengeMission(userId, request);
        return ApiResponse.onSuccess(MemberMissionConverter.toMemberMissionResultDTO(challenge));
    }
}