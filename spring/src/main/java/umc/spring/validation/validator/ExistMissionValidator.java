package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.repository.MemberMissionRepository.MemberMissionRepository;
import umc.spring.validation.annotation.ExistMission;

@Component
@RequiredArgsConstructor
public class ExistMissionValidator implements ConstraintValidator<ExistMission, Long> {
    private final MemberMissionRepository missionMemberRepository;

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        Long memberId = 1L; // 실제로는 SecurityContext 등에서 가져와야 함
        return !missionMemberRepository.existsByMemberIdAndMissionId(memberId, missionId);
    }
}
