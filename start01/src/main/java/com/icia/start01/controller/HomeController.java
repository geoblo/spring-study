package com.icia.start01.controller;

import com.icia.start01.dto.DataDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@Slf4j // 로그용 라이브러리
public class HomeController {
    // RequestMapping은 클래스에 붙일수 있어 유용함
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    @RequestMapping("/") // method 생략 시 기본이 GET
    @GetMapping("/")
    public String home() {
        log.info("home()");
        return "home"; // view template 이름 - home.html
    }

    @GetMapping("intro")
    public String intro(Model model) {
        log.info("intro()");
        Date now = new Date();
        model.addAttribute("data", now);
        return "intro";
    }

    @GetMapping("t_output")
    public ModelAndView t_output() {
        log.info("t_output()");
        ModelAndView mav = new ModelAndView("t_output");
        
        // 텍스트 데이터 넣기
        mav.addObject("testStr", "<h3>h3로 만든 문자열</h3>");
        mav.addObject("message", "안녕~");

        // Map 데이터
        Map<String, String> map = new HashMap<>();
        map.put("data1", "홍길동");
        map.put("data2", "20");
        map.put("data3", "인천시 미추홀구");
        mav.addObject("mapdata", map);

        // DTO 데이터
        DataDto dataDto = new DataDto();
        dataDto.setName("아무개");
        dataDto.setAge(30);
        dataDto.setAddress("서울시 영등포구");
        mav.addObject("dtodata", dataDto);

//        mav.setViewName("t_output"); // 위처럼 쓰면 생략 가능
        return mav;
    }

    @GetMapping("t_control")
    public String t_control(Model model) {
        log.info("t_control()");

        model.addAttribute("data", "이 문자열이 보입니다.");
        model.addAttribute("age", 25);

        List<DataDto> d_list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            DataDto data = new DataDto();
            data.setName("이름" + i);
            data.setAge(25 + i);
            data.setAddress("주소" + i);
            d_list.add(data);
        }
        model.addAttribute("dList", d_list);

        return "t_control";
    }

    @GetMapping("sendData")
    public String sendData() {
        log.info("sendData()");

        return "sendData";
    }

//    @GetMapping("a_send")
//    public String aTagDataSend(@RequestParam("num1") String num1,
//                               @RequestParam("num2") int num2, // 문자열로 들어오는데 자동 형변환 됨
//                               Model model) {
//        log.info("aTagDataSend() {} {}", num1, num2);
//
//        int n1 = Integer.parseInt(num1);
//        model.addAttribute("result", n1 + num2);
//
//        return "s_result";
//    }

    // @RequestParam은 생략 가능
    // 단, 변수명을 똑같이 맞춰야함에 주의!
    @GetMapping("a_send")
    public String aTagDataSend(String num1,
                               int num2, // 문자열로 들어오는데 자동 형변환 됨
                               Model model) {
        log.info("aTagDataSend() {} {}", num1, num2);

        int n1 = Integer.parseInt(num1);
        model.addAttribute("result", n1 + num2);

        return "s_result";
    }

    @GetMapping("noneDtoSend")
    public String noneDtoSend(@RequestParam("name") String name,
                              @RequestParam("age") int age,
                              @RequestParam("address") String address,
                              Model model) { // 파라미터 순서는 안지켜도 됨, 보통 Model을 가장 마지막에 작성
        log.info("noneDtoSend()");
        log.info("name : " + name);
        log.info("age : " + age);
        log.info("address : " + address);

        model.addAttribute("result", "none dto send OK");
        
        return "s_result";
    }

    @PostMapping("dtoSend")
    public String dtoSend(DataDto dataDto, Model model) {
        log.info("dtoSend()");
        log.info("name : " + dataDto.getName());
        log.info("age : " + dataDto.getAge());
        log.info("address : " + dataDto.getAddress());

        model.addAttribute("result", "dto send OK");

        return "s_result";
    }

}
