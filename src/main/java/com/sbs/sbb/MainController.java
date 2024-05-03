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
}
