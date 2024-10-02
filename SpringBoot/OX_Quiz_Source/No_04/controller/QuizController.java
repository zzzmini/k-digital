package com.ex.quizCRUD.controller;

import com.ex.quizCRUD.dto.QuizDTO;
import com.ex.quizCRUD.service.MemberService;
import com.ex.quizCRUD.service.QuizService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@Controller
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    @Autowired
    MemberService memberService;

    @GetMapping("")
    public String showQuiz(Model model){
        if(quizService.findAll() != null){
            model.addAttribute("lists", quizService.findAll());
            return "quiz/showQuiz";
        }else{
            return "quiz/nullQuiz";
        }
    }

    @GetMapping("insert")
    public String insertQuiz(Model model){
        model.addAttribute("dto", new QuizDTO());
        return "quiz/insertQuiz";
    }

    @PostMapping("insert")
    public String insertQuiz(@Valid @ModelAttribute("dto") QuizDTO dto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.info("========Validation Error");
            return "quiz/insertQuiz";
        }
        quizService.saveQuiz(dto);
        return "redirect:/quiz";
    }

    @GetMapping("update/{id}")
    public String updateQuiz(Model model, @PathVariable("id")Long id){
        log.info("=======updateId" + id);
        QuizDTO dto = quizService.findById(id);
        model.addAttribute("dto", dto);
        return "quiz/updateQuiz";
    }

    @PostMapping("update")
    public String updateQuiz(@Valid @ModelAttribute("dto") QuizDTO dto, BindingResult bindingResult){
        log.info("=======updateDTO " + dto.toString());
        if(bindingResult.hasErrors()){
            return "quiz/updateQuiz";
        }
        quizService.updateQuiz(dto);
        return "redirect:/quiz";
    }

    @PostMapping("delete")
    public String deleteQuiz(@RequestParam("id")Long id){
        log.info("=======deleteId: " + id);
        quizService.deleteQuiz(id);
        return "redirect:/quiz";
    }

    @GetMapping("play")
    public String playQuiz(Model model){
        QuizDTO dto = quizService.randQuiz();
        model.addAttribute("dto", dto);
        if(dto != null){
            return "quiz/playQuiz";
        }else{
            return "quiz/nullQuiz";
        }
    }
}
