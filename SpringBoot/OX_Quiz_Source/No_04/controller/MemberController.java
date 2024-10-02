package com.ex.quizCRUD.controller;

import com.ex.quizCRUD.dto.MemberDTO;
import com.ex.quizCRUD.service.MemberService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequestMapping("member")
public class MemberController {
    @Autowired
    MemberService memberService;

    @GetMapping("")
    public String showMain() {
        return "main";
    }

    @GetMapping("insert")
    public String insertFormView(Model model) {
        model.addAttribute("dto", new MemberDTO());
        return "member/insertMember";
    }

    // 회원가입
    @PostMapping("insert")
    public String insertMember(MemberDTO dto, RedirectAttributes redirectAttributes) {
        log.info("controller: " + dto.toString());
        // Long result = memberService.saveMember(dto);
        if(memberService.saveMember(dto) > 0){  // 회원가입 성공
            return "main";
        }else {  // 회원가입 실패, 계정 사용 유무 체크
            redirectAttributes.addFlashAttribute("msg", "이미 존재하는 회원입니다.");
            return "redirect:/member/insert";
        }
    }

    // 회원 전체 조회
    @GetMapping("list")
    public String showMember(Model model){
        model.addAttribute("members", memberService.findAll());
        return "member/showMember";
    }

    // 회원 인증, 인증 삭제
    @GetMapping("certify")
    public String memberCertify(@RequestParam("no")Long no, @RequestParam("status")Boolean status){
        memberService.updateStatus(no, status);
        return "redirect:/member/list";
    }

    // 회원 정보 조회
    @GetMapping("myPage/{id}")
    public String myPage(Model model, @PathVariable("id")String id){
        log.info("memberController_mypage: " + id);
        MemberDTO dto = memberService.userInfo(id);
        model.addAttribute("dto", dto);
        return "member/myPage";
    }

    // 회원 정보 업데이트
    @PostMapping("update")
    public String updateMember(Model model, MemberDTO dto, HttpSession session){
        log.info("memberController_update: " + dto.toString());
        memberService.updateMember(dto);
        session.setAttribute("userId", dto.getId());
        session.setMaxInactiveInterval(60*30);
        return "main";
    }

    // 퀴즈 정답/오답 횟수 업데이트
    @PostMapping("check")
    public String checkQuiz(@RequestParam("id")String id, @RequestParam("answer")String answer, @RequestParam("choice")String choice){
        log.info("=======answer: " + answer + ", choice: " + choice + ", id: " + id);
        // 정답이면 true, 오답이면 false 전달
        Boolean bl;

        if(answer.equals(choice)){
            bl = true;
            memberService.answerCount(id, bl);
            return "quiz/rightQuiz";
        }else{
            bl = false;
            memberService.answerCount(id, bl);
            return "quiz/wrongQuiz";
        }
    }
}
