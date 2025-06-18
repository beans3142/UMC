package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import umc.spring.service.MemberService.MemberCommandService;
import umc.spring.web.dto.Member.MemberRequestDTO;


@Controller
@RequiredArgsConstructor
public class MemberViewController {
    
    private final MemberCommandService memberCommandService;

    // 홈 페이지
    @GetMapping("/home")
    public String home() {
        return "home";
    }

    // 로그인 페이지
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // 루트 경로 - 홈으로 리디렉션
    @GetMapping("/")
    public String root() {
        return "redirect:/home";
    }

    // 회원가입 페이지
    @GetMapping("/signup")
    public String signupForm(Model model) {
        model.addAttribute("memberJoinDto", new MemberRequestDTO.CreateMemberDTO());
        return "signup";
    }

    // thymeleaf 사용을 위해 일부가 변경되었습니다.
    // 실제로는 8주차에서 작성한 컨트롤러와 동일하게 작성하시면 됩니다!!
    @PostMapping("/members/signup")
    public String joinMember(@ModelAttribute("memberJoinDto") MemberRequestDTO.CreateMemberDTO request, // 협업시에는 기존 RequestBody 어노테이션을 붙여주시면 됩니다!
                             BindingResult bindingResult,
                             Model model) {
        System.out.println("회원가입 요청: " + request.getEmail());
        if (bindingResult.hasErrors()) {
            System.out.println("BindingResult 에러: " + bindingResult);
            return "signup";
        }

        try {
            memberCommandService.joinMember(request);
            System.out.println("회원가입 성공!");
            return "redirect:/login";
        } catch (Exception e) {
            System.out.println("회원가입 실패: " + e.getMessage());
            model.addAttribute("error", e.getMessage());
            return "signup";
        }
    }
    
    // ... 기존 메소드들 ...
}