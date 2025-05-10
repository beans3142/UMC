package umc.spring.web.dto.MemberMission;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.validation.annotation.ExistMission;

@Getter
public class MemberMissionRequestDTO {
    @NotNull
    @ExistMission
    private Long missionId;
}