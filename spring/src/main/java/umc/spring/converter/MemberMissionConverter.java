package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberMission.MemberMissionResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class MemberMissionConverter {
    public static MemberMissionResponseDTO.MemberMissionResultDTO toMemberMissionResultDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.MemberMissionResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .userId(memberMission.getMember().getId())
                .missionId(memberMission.getMission().getId())
                .status(memberMission.getStatus().name())
                .build();
    }

    public static MemberMissionResponseDTO.MemberMissionListDTO toMemberMissionListDTO(Page<MemberMission> memberMissionPage) {
        List<MemberMissionResponseDTO.MemberMissionResultDTO> missionList = memberMissionPage.stream()
                .map(MemberMissionConverter::toMemberMissionResultDTO)
                .collect(Collectors.toList());

        return MemberMissionResponseDTO.MemberMissionListDTO.builder()
                .missionList(missionList)
                .listSize(missionList.size())
                .totalPage(memberMissionPage.getTotalPages())
                .totalElements(memberMissionPage.getTotalElements())
                .isFirst(memberMissionPage.isFirst())
                .isLast(memberMissionPage.isLast())
                .build();
    }
}