package umc.spring.web.dto.Mission;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class MissionResponseDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionResultDTO {
        private Long missionId;
        private Long storeId;
        private Integer reward;
        private LocalDateTime deadline;
        private String missionSpec;
    }
}