package umc.spring.service.MemberService;

import umc.spring.domain.Member;
import umc.spring.web.dto.Member.MemberRequestDTO;
import umc.spring.web.dto.Member.MemberResponseDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.CreateMemberDTO request);
    MemberResponseDTO.LoginResultDTO loginMember(MemberRequestDTO.LoginRequestDTO request);
}