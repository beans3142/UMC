package umc.spring.web.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class MissionRequestDTO {
    @NotNull
    private Long storeId;

    @NotNull
    @Min(0)
    private Integer reward;

    @NotNull
    @Future
    private LocalDateTime deadline;

    @NotBlank
    private String missionSpec;
}