package org.zerock.springex.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.springex.dto.TodoDTO;

@Controller
@RequestMapping("/todo") // 특정한 경로의 요청(Request)을 지정, 클래스의 선언부와 메소드에 사용 가능
@Log4j2
public class TodoController {

    @RequestMapping("/list") // 최종 경로는 '/todo/list'
    public void list() {
        log.info("todo list........");
    }

    // @RequestMapping(value = "/register", method = RequestMethod.GET)
//    public void register() {
//        log.info("todo register....");
//    }
    // 스프링 4버전 이후에는 @GetMapping, @PostMapping 추가됨
    @GetMapping("/register")
    public void registerGET() {
        log.info("GET todo register....");
    }

    @PostMapping("/register")
    public String registerPost(TodoDTO todoDTO) { // 객체 자료형의 파라미터 수집
        log.info("POST todo register....");
        log.info(todoDTO);

        return "redirect:/todo/list";
    }
}
