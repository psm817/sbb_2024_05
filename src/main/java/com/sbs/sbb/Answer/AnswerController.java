package com.sbs.sbb.Answer;

import com.sbs.sbb.Question.Question;
import com.sbs.sbb.Question.QuestionRepository;
import com.sbs.sbb.Question.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/answer")            // 매핑이 모두 question 라는 접두어로 시작하면 RequestMapping 으로 설정
@Controller
@RequiredArgsConstructor                // 생성자를 통해 객체 생성하는 역할이랑 동일
public class AnswerController {
    private final QuestionService questionService;

    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable("id") Integer id, @RequestParam(value="content") String content) {
        // 답변 부모 질문 객체를 받아온다.
        Question q = this.questionService.getQuestion(id);

        return "redirect:/question/detail/%d".formatted(id);
    }
}
