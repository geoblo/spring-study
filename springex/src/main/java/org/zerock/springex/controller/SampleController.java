package org.zerock.springex.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 해당 클래스가 스프링 MVC에서 컨트롤러 역할을 한다는 것을 의미하고 스프링의 빈(Bean)으로 처리되기 위해서 사용
@Log4j2
public class SampleController {

    @GetMapping("/hello") // GET 방식으로 들어오는 요청(Request)을 처리하기 위해서 사용
    public void hello() {
        log.info("hello.............");
    }
    
}
