package com.example.oxquizproject.controller;

import com.example.oxquizproject.dto.MemberDTO;
import com.example.oxquizproject.dto.QuizDTO;
import com.example.oxquizproject.service.MemberService;
import com.example.oxquizproject.service.QuizService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("quiz")
@Slf4j
public class QuizController {
    @Autowired
    QuizService quizService;
    @Autowired
    MemberService memberService;

    @GetMapping("")
    public String showQuiz(Model model) {
        model.addAttribute("lists", quizService.findAll());
        return "showQuiz";
    }

    @GetMapping("insert")
    public String insertFormView(Model model) {
        model.addAttribute("dto", new QuizDTO());
        return "insertQuiz";
    }

    @PostMapping("insert")
    public String insertQuiz(@Valid @ModelAttribute("dto") QuizDTO dto, BindingResult bindingResult) {
        log.info("################" + dto.toString());
        //오류가 있으면 insertMember로 다시 돌아가겠다
        if (bindingResult.hasErrors()) {
            log.info("====================Validation Error");
            return "insertQuiz";
        }
        quizService.saveQuiz(dto);
        return "redirect:/quiz";
    }

    @PostMapping("delete")
    public String deleteQuiz(@RequestParam("id") Long id) {
        log.info("################ deleteId = " + id);
        quizService.deleteQuiz(id);
        return "redirect:/quiz";
    }

    @GetMapping("update")
    public String updateFormView(@RequestParam("id") Long id, Model model) {
        log.info("################ updateId = " + id);
        QuizDTO dto = quizService.findById(id);
        log.info("################ dto = " + dto.toString());
        model.addAttribute("dto", dto);
        return "updateQuiz";
    }

    @PostMapping("update")
    public String updateQuiz(@Valid @ModelAttribute("dto") QuizDTO dto, BindingResult bindingResult) {
        log.info("################ dto = " + dto.toString());
        if (bindingResult.hasErrors()) {
            return "updateQuiz";
        }
        quizService.updateQuiz(dto);
        return "redirect:/quiz";
    }

    @GetMapping("play")
    public String playView(Model model) {
        List<QuizDTO> lists=quizService.randomQuiz();
        boolean listsEmpty = lists.isEmpty();
        model.addAttribute("lists", lists);
        model.addAttribute("listsEmpty", listsEmpty);
        return "playQuiz";
    }

    @PostMapping("check")
    public String checkQuiz(@RequestParam("id") Long id, @RequestParam("answer") String answer, Model model, HttpSession session) {
        QuizDTO dto = quizService.findById(id);
        //정답여부
        boolean isCorrect = dto.getAnswer().equals(answer);

        // 현재 로그인한 사용자의 ID 가져오기
        String loginId = (String) session.getAttribute("loginId");
        log.info("################ loginId = " + loginId);
        if (loginId == null) {
            return "redirect:/member/login";  // 로그인 상태가 아니면 로그인 페이지로 리다이렉트
        }

        // 로그인한 사용자의 Member 정보 가져오기
        MemberDTO memberDTO = memberService.findById(loginId);

        // 정답 여부에 따라 회원의 answerTrue, answerFalse 값을 업데이트
        if (isCorrect) {
            memberDTO.setAnswerTrue(memberDTO.getAnswerTrue() + 1);  // 정답일 경우 answerTrue 증가
        } else {
            memberDTO.setAnswerFalse(memberDTO.getAnswerFalse() + 1);  // 오답일 경우 answerFalse 증가
        }

        // 업데이트된 회원 정보 저장
        memberService.updateMember(memberDTO);

        model.addAttribute("isCorrect", isCorrect);
        model.addAttribute("quiz", dto);
        model.addAttribute("member", memberDTO);
        return "checkQuiz";
    }


}
