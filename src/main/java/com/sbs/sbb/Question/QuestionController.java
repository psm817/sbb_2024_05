package com.sbs.sbb.Question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor                // 생성자를 통해 객체 생성하는 역할이랑 동일
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping("/question/list")
    public String list(Model model) {
        List<Question> questionList = this.questionService.findAll();
        // html로 넘겨주는 attribute가 questionList이다.
        model.addAttribute("questionList", questionList);

        return "question_list";
    }
}
