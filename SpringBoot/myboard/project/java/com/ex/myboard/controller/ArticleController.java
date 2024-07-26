package com.ex.myboard.controller;

import com.ex.myboard.dto.ArticleDto;
import com.ex.myboard.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("articles")
public class ArticleController {
    @Autowired
    ArticleService articleService;
    @GetMapping("")
    public String showAllArticles(Model model) {
        List<ArticleDto> dtoList = articleService.findAll();
        model.addAttribute("dtoList", dtoList);
        return "show_all";
    }

    @GetMapping("new")
    public String newForm(){
        return "new";
    }

    @PostMapping("create")
    public String createArticle(ArticleDto dto){
        articleService.createArticle(dto);
        return "redirect:/articles";
    }

    @GetMapping("{id}")
    public String viewArticle(@PathVariable("id")Long id, Model model) {
        ArticleDto article = articleService.getOneArticle(id);
        model.addAttribute("article", article);
        return "show";
    }

    @GetMapping("{id}/delete")
    public String deleteArticle(@PathVariable("id")Long id) {
        articleService.deleteArticle(id);
        return "redirect:/articles";
    }

    @GetMapping("{id}/update")
    public String updateFormView(@PathVariable("id") Long id, Model model) {
        ArticleDto article = articleService.getOneArticle(id);
        model.addAttribute("article", article);
        return "update";
    }

    @PostMapping("update")
    public String updateArticle(ArticleDto dto) {
        articleService.updateArticle(dto);
        return "redirect:/articles";
    }
}
