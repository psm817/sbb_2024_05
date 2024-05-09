package com.sbs.sbb.Question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/question")            // 매핑이 모두 question 라는 접두어로 시작하면 RequestMapping 으로 설정
@Controller
@RequiredArgsConstructor                // 생성자를 통해 객체 생성하는 역할이랑 동일
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Question> questionList = this.questionService.getList();
        model.addAttribute("questionList", questionList);

        return "question_list";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Question q = this.questionService.getQuestion(id);

        model.addAttribute("question", q);

        return "question_detail";               // return 값은 html 파일명
    }

    @GetMapping("/create")
    public String questionCreate() {
        return "question_form";
    }
}
