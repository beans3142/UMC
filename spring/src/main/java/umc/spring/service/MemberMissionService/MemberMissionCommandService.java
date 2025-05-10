package umc.spring.service.MemberMissionService;

import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberMission.MemberMissionRequestDTO;

public interface MemberMissionCommandService {
    MemberMission challengeMission(Long userId, MemberMissionRequestDTO request);
}