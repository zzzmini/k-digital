package com.ex.OXQuiz.controller;

import com.ex.OXQuiz.dto.MemberDTO;
import com.ex.OXQuiz.dto.QuizDTO;
import com.ex.OXQuiz.entity.Quiz;
import com.ex.OXQuiz.service.QuizService;
import com.ex.OXQuiz.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("quiz")
@Slf4j
public class QuizController {
    @Autowired
    QuizService quizService;
    @Autowired
    UserService userService;

    @GetMapping("")
    public String showQuiz() {
        return "showQuiz";
    }

    @GetMapping("insert")
    public String showInsertQuiz(Model model) {
        model.addAttribute("dto", new QuizDTO());
        model.addAttribute("list", quizService.findAll());
        log.info("quiz list : " + quizService.findAll());
        return "insertQuiz";
    }

    @PostMapping("insert")
    public String insertQuiz(@Valid @ModelAttribute("dto") QuizDTO dto, BindingResult bindingResult) {
        log.info("==== dto : " + dto.toString());

        //validation
        if (bindingResult.hasErrors()) return "insertQuiz";

        quizService.insertQuiz(dto);
        return "redirect:/quiz/insert";
    }

    @GetMapping("update")
    public String showUpdateQuiz(@RequestParam("id") Long id, Model model) {
        log.info("##### updateId=" + id);
        model.addAttribute("dto", quizService.findById(id));
        return "updateQuiz";
    }

    @PostMapping("update")
    public String updateQuiz(@Valid @ModelAttribute("dto") QuizDTO dto, BindingResult bindingResult) {
        log.info("#### dto : " + dto.toString());

        //validation
        if (bindingResult.hasErrors()) return "updateQuiz";

        quizService.updateQuiz(dto);
        return "redirect:/quiz/insert";
    }

    @GetMapping("delete")
    public String deleteQuiz(@RequestParam("id") Long id) {
        log.info("#### deleteId=" + id);
        quizService.deleteQuiz(id);
        return "redirect:/quiz/insert";
    }

    @GetMapping("play")
    public String playQuiz(Model model) {
        QuizDTO quiz = quizService.findRandom();
        log.info("##### random quiz : " + quiz.toString());
        model.addAttribute("dto", quiz);
        return "playQuiz";
    }

    @PostMapping("check")
    public String checkQuiz(@RequestParam("answer") String answer, @RequestParam("id") Long id, Model model, HttpSession session) {
        log.info("##### answer : " + answer);
        QuizDTO quiz = quizService.findById(id);
        String result = "오답입니다.";
        if(answer.equals(quiz.getAnswer())) result = "정답입니다.";
        model.addAttribute("result", result);

        // 세션 정보로 유저 아이디 가져오기
        String myId = (String) session.getAttribute("login");
        log.info("session user id: " + myId);

        //유저 아이디 찾아서 정답 정보 업데이트
        MemberDTO dto = userService.findByLoginId(myId);
        if (answer.equals(quiz.getAnswer())) {
            dto.setAnswerTrue(dto.getAnswerTrue() + 1);
        } else {
            dto.setAnswerFalse(dto.getAnswerFalse()+1);
        }
        userService.updateUser(dto);
        return "checkQuiz";
    }
}
