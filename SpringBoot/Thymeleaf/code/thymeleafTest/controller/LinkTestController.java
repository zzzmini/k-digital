package com.example.thymeleafTest.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/articles")
public class LinkTestController {
    @GetMapping("/main")
    public String main() {
        return "/articles/main";
    }

    @GetMapping("/list")
    public String listAll(Model model) {
        String title = "/articles/list";
        String message = "전체 게시글 읽기 성공";

        model.addAttribute("title", title);
        model.addAttribute("message", message);
        return "/articles/list_all";
    }

    @GetMapping("/member/{id}")
    public String memberSelect(Model model,
                               @PathVariable("id")int id,
                               @RequestParam("name")String name) {
        String title = "/articles/member/{" + id + "}";
        String message = name + "이 선택되었습니다.";

        model.addAttribute("title", title);
        model.addAttribute("message", message);
        return "/articles/member-list";
    }
    @GetMapping("/{id}")
    public String listOne(@PathVariable("id")int id, Model model) {
        String title = "/articles/{" + id + "}";
        String message = id + "번 게시글 읽기 성공";

        model.addAttribute("title", title);
        model.addAttribute("message", message);
        return "/articles/list_one";
    }

    @GetMapping("/create")
    public String newInfo(@RequestParam("name")String name,
                          @RequestParam("height")int height,
                          @RequestParam("weight")int weight, Model model) {
        String title = "/articles/create?name=" + name + "&height=" + height +
                "&weight=" + weight;
        String message = name + "의 키는 " + height + ", 몸무게는 " + weight + "입니다.";

        model.addAttribute("title", title);
        model.addAttribute("message", message);
        return "/articles/new";
    }

    @GetMapping("/update")
    public String update(Model model) {
        String title = "/articles/update";
        String message = "업데이트 성공 화면 출력";

        model.addAttribute("title", title);
        model.addAttribute("message", message);
        return "/articles/update_ok";
    }

    @GetMapping("/{id}/update")
    public String updateById(@PathVariable("id") int id,
                            Model model) {
        String title = "/articles/{" + id + "}/update";
        String message = id + "번 게시글 수정 폼 로딩 완료";

        model.addAttribute("title", title);
        model.addAttribute("message", message);
        return "/articles/update";
    }

    @GetMapping("/{id}/delete")
    public String deleteById(@PathVariable("id") int id,
                             Model model) {
        String title = "/articles/{" + id + "}/delete";
        String message = id + "번 게시글 삭제 완료";

        model.addAttribute("title", title);
        model.addAttribute("message", message);
        return "/articles/delete_ok";
    }

    @GetMapping("/{id}/articleComment")
    public String viewArticleComment(@PathVariable("id") int id,
                             Model model) {
        String title = "/articles/{" + id + "}/articleCommnet";
        String message = id + "번 게시글의 모든 댓글보기 성공";

        model.addAttribute("title", title);
        model.addAttribute("message", message);
        return "/articles/comment_view";
    }

    @GetMapping("/{id}/articleComments/{articleCommentId}/delete")
    public String articleCommentDelete(@PathVariable("id") int id,
                                     @PathVariable("articleCommentId")int articleCommentId,
                                     Model model) {
        String title = "/articles/{" + id + "}/articleComments/{" + articleCommentId + "}/delete";
        String message = id + "번 게시글의 " + articleCommentId + "번째 답글 삭제 완료";

        model.addAttribute("title", title);
        model.addAttribute("message", message);
        return "/articles/delete_ok";
    }
}
