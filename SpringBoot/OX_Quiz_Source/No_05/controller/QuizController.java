package com.me.oxQuiz.controller;

import com.me.oxQuiz.constant.Answer;
import com.me.oxQuiz.dto.QuizDTO;
import com.me.oxQuiz.repository.QuizRepository;
import com.me.oxQuiz.service.MemberService;
import com.me.oxQuiz.service.QuizService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("quiz")
@Slf4j
@RequiredArgsConstructor
public class QuizController {
    private final QuizService quizService;
    private final MemberService memberService;

    @PostMapping("check")
    public String checkAnswer(@RequestParam("answer") Answer selectedAnswer,
                              @RequestParam("id") Long id,
                              HttpSession session,
                              Model model){
//        log.info("========== selectedAnswer = " + selectedAnswer);
//        log.info("========== presentId = " + id);
        // 퀴즈 ID 통해 퀴즈 정보 가져옴
        QuizDTO dto = quizService.findById(id);
        // 결과 메시지 초기화
        String resultMessage;

        // 정답과 비교하여 결과 설정
        if (selectedAnswer.equals(dto.getAnswer())){
            resultMessage = "정답입니다.";
            // 로그인한 사용자 ID 가져오기
            String myId = (String) session.getAttribute("loginId");
            memberService.incrementAnswerTrue(myId);
        } else {
            resultMessage = "틀렸습니다.";
            String myId = (String) session.getAttribute("loginId");
            memberService.incrementAnswerFalse(myId);
        }
        model.addAttribute("resultMessage",resultMessage);
        return "checkQuiz";
    }

    @GetMapping("check")
    public String checkView(){
        return "checkQuiz";
    }

    @GetMapping("play")
    public String playView(Model model, HttpSession session){
        // 로그인 상태 확인 후 세션 만료되었다면 로그인 페이지로 이동
        String myId = (String) session.getAttribute("loginId");
        if(ObjectUtils.isEmpty(myId)) {
            return "redirect:/member/login";
        }

        model.addAttribute("list", quizService.findRandomOne());
        model.addAttribute("answer", Answer.values());
        return "playQuiz";
    }

    @PostMapping("update")
    public String updateQuiz(@Valid @ModelAttribute("dto") QuizDTO dto,
                             BindingResult bindingResult,
                             Model model){
//        log.info("========= update_dto = " + dto.toString());

        if(bindingResult.hasErrors()){
            // answer 값 다시 설정
            model.addAttribute("answer", Answer.values());
            return "insertQuiz";
        }

        quizService.updateQuiz(dto);
        return "redirect:/quiz/view";
    }

    @GetMapping("update")
    public String updateFormView(@RequestParam("id")Long id, Model model){
        QuizDTO dto = quizService.findById(id);
//        log.info("========== dto = " + dto.toString());
        model.addAttribute("dto", dto);
        model.addAttribute("answer", Answer.values());
        return "updateQuiz";
    }

    @PostMapping("delete")
    public String deleteQuiz(@RequestParam("id")Long id){
        quizService.deleteQuiz(id);
        return "redirect:/quiz/view";
    }

    @PostMapping("insert")
    public String insertQuiz(@Valid @ModelAttribute("dto") QuizDTO dto,
                             BindingResult bindingResult,
                             Model model){
//        log.info("==========" + dto.toString());

        // validation
        if(bindingResult.hasErrors()){
            // answer 값 다시 설정
            model.addAttribute("answer", Answer.values());
            return "insertQuiz";
        }

        quizService.saveQuiz(dto);
        return "redirect:/quiz/view";
    }

    @GetMapping("insert")
    public String insertFormView(Model model){
        model.addAttribute("dto", new QuizDTO());
        model.addAttribute("answer", Answer.values());
        return "insertQuiz";
    }

    @GetMapping("")
    public String showMain(){
        return "main";
    }

    @GetMapping("view")
    public String showQuizList(Model model, HttpSession session){
        // 사용자가 로그인했는지 확인
        String myId = (String) session.getAttribute("loginId");
        if (ObjectUtils.isEmpty(myId)){
            return "redirect:/member/login";
        }
        // 사용자가 관리자인지 확인
        boolean isAdmin = (boolean) session.getAttribute("isAdmin");
        if (Boolean.TRUE.equals(isAdmin)){
            model.addAttribute("lists", quizService.findAll());
            return "showQuiz";
        } else {
            return "redirect:/member/login";
        }
    }
}
