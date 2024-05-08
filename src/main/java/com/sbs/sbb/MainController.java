package com.sbs.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @GetMapping("/sbb")
    @ResponseBody           // 이걸 붙혀야 아래 함수대로 출력문이 나온다.
    public String index() {
        return "안녕하세요!!!";
    }

    @GetMapping("/")
    public String root() {
        // localhost:8090으로 접속해도 localhost:8090/question/list 로 리다이렉션 가능
        return "redirect:/question/list";
    }
}
