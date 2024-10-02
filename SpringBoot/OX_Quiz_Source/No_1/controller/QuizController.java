package com.my.QuizApplication.controller;

import com.my.QuizApplication.constant.Answer;
import com.my.QuizApplication.dto.MemberDTO;
import com.my.QuizApplication.dto.QuizDTO;
import com.my.QuizApplication.entity.Quiz;
import com.my.QuizApplication.service.MemberService;
import com.my.QuizApplication.service.QuizService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("quiz")
@RequiredArgsConstructor
public class QuizController {
    private final QuizService quizService;
    private final MemberService memberService;

    @ModelAttribute("answers")
    private Answer[] answers() {
        return Answer.values();
    }

    @GetMapping("")
    public String quizMainView(Model model) {
        model.addAttribute("quizList", quizService.quizList());
        return "/quiz/quizList";
    }

    @GetMapping("c_asc")
    public String quizListByContentAsc(RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("quizList", quizService.quizListByContentAsc());
        return "redirect:/";
    }

    @GetMapping("c_desc")
    public String quizListByContentDesc(RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("quizList", quizService.quizListByContentDesc());
        return "redirect:/";
    }

    @GetMapping("n_asc")
    public String quizListByAsc(RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("quizList", quizService.quizListByNameAsc());
        return "redirect:/";
    }

    @GetMapping("n_desc")
    public String quizListByDesc(RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("quizList", quizService.quizListByNameDesc());
        return "redirect:/";
    }

    @GetMapping("insert")
    public String insertQuizView(Model model) {
        model.addAttribute("newQuiz", new Quiz());
        return "insertQuiz";
    }

    @PostMapping("insert")
    public String insertQuiz(@Valid @ModelAttribute("newQuiz") QuizDTO dto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) return "insertQuiz";
        quizService.insertQuiz(dto);
        return "redirect:/quiz";
    }

    @GetMapping("/update/{id}")
    public String updateQuizView(@PathVariable("id")Long id, Model model) {
        model.addAttribute("quiz", quizService.findById(id));
        return "/quiz/updateQuiz";
    }

    @PostMapping("update")
    public String updateQuiz(@Valid @ModelAttribute("quiz")QuizDTO dto, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "updateQuiz";
        quizService.updateQuiz(dto);
        return "redirect:/quiz/";
    }

    @PostMapping("delete")
    public String deleteQuiz(@RequestParam("id")Long id) {
        quizService.deleteQuiz(id);
        return "redirect:/quiz/";
    }

    @GetMapping("play")
    public String playQuiz(Model model) {
        if (quizService.randomQuiz()!= null) {
            model.addAttribute("quiz", quizService.randomQuiz());
        } else {
            model.addAttribute("quiz", null);
        }
        return "/quiz/playQuiz";
    }

    @PostMapping("check")
    public String checkAnswer(@RequestParam("answer") boolean answer, @RequestParam("choice") String choice, Model model, HttpSession session) {
        MemberDTO memberDto = (MemberDTO) session.getAttribute("memberDto");
        Boolean choiceBoolean = true;
        if (choice.equals("X")) choiceBoolean = false;
        if (choiceBoolean.equals(answer)) {
            model.addAttribute("msg", "정답입니다.");
            memberDto.setAnswerTrue(memberDto.getAnswerTrue()+1);
            memberService.updateMember(memberDto);
        } else {
            model.addAttribute("alreadyHas", "틀렸습니다.");
            memberDto.setAnswerFalse(memberDto.getAnswerFalse()+1);
            memberService.updateMember(memberDto);
        }
        return "/quiz/answerCheck";
    }
}
