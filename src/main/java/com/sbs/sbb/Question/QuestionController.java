package com.sbs.sbb.Question;

import jakarta.websocket.server.PathParam;
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

    // 질문 등록하기 버튼 눌렀을 때 URL 매핑
    @GetMapping("/create")
    public String create() {
        return "question_form";
    }

    // 저장하기 버튼 눌렀을 때 URL 매핑
    @PostMapping("/create")
    public String questionCreate(@RequestParam(value="subject") String subject, @RequestParam(value="content") String content) {
        if(subject == null || subject.trim().length() == 0) {
            throw new RuntimeException("subject(을)를 입력해주세요.");
        }

        if(subject.trim().length() > 200) {
            throw new RuntimeException("subject(을)를 200자 이하로 입력해주세요.");
        }

        if(content == null || content.trim().length() == 0) {
            throw new RuntimeException("content(을)를 입력해주세요.");
        }

        if(content.trim().length() > 20_000) {
            throw new RuntimeException("content(을)를 20,000자 이하로 입력해주세요.");
        }

        Question q = this.questionService.create(subject, content);

        return "redirect:/question/list";
    }
}
