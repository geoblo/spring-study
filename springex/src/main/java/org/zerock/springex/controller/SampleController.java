package org.zerock.springex.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.springex.dto.TodoDTO;

import java.time.LocalDate;

@Controller // 해당 클래스가 스프링 MVC에서 컨트롤러 역할을 한다는 것을 의미하고 스프링의 빈(Bean)으로 처리되기 위해서 사용
@Log4j2
public class SampleController {

    @GetMapping("/hello") // GET 방식으로 들어오는 요청(Request)을 처리하기 위해서 사용
    public void hello() {
        log.info("hello.............");
    }

    // 파라미터 자동 수집과 변환
    // 기본 자료형
    @GetMapping("/ex1")
    public void ex1(String name, int age) {
        log.info("ex1.............");
        log.info("name: " + name);
        log.info("age: " + age);
    }

    // 파라미터가 전달되지 않으면 문제가 발생할 수 있음
    // @RequestParam으로 기본값 지정
    @GetMapping("/ex2")
    public void ex2(@RequestParam(name = "name", defaultValue = "AAA") String name,
                    @RequestParam(name = "age", defaultValue = "20") int age) {
        log.info("ex2.............");
        log.info("name: " + name);
        log.info("age: " + age);
    }

    // 기본적으로 HTTP는 문자열로 데이터를 전달
    // 컨트롤러는 문자열 기준으로 특정한 클래스의 객체로 처리하는 작업이 진행
    // 이때 가장 문제가 되는 타입이 바로 날짜 관련
    // '2020-10-10' => Date, LocalDate, LocalDateTime 등으로 변환하는 작업에서 파라미터 수집 시 에러 발생
    @GetMapping("/ex3")
    public void ex3(LocalDate dueDate) {
        log.info("ex3.............");
        log.info("dueDate: " + dueDate);
    }

    // Model이라는 특별한 파라미터
    @GetMapping("/ex4")
    public void ex4(Model model) {
        log.info("ex4.............");
        log.info("model: " + model.toString());

        model.addAttribute("message", "Hello World");
        log.info("model: " + model);
    }

    // Model이라는 특별한 파라미터
    @GetMapping("/ex4_1")
    public void ex4Extra(TodoDTO todoDTO, Model model) {
        log.info("ex4Extra.............");
        log.info(todoDTO);
    }
}
