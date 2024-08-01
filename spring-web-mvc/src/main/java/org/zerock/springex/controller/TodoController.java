package org.zerock.springex.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.springex.dto.TodoDTO;
import org.zerock.springex.service.TodoService;

import javax.validation.Valid;

@Controller
@RequestMapping("/todo") // 특정한 경로의 요청(Request)을 지정, 클래스의 선언부와 메소드에 사용 가능
@Log4j2
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @RequestMapping("/list") // 최종 경로는 '/todo/list'
    public void list(Model model) {
        log.info("todo list........");

        model.addAttribute("dtoList", todoService.getAll());
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
    public String registerPost(@Valid TodoDTO todoDTO, // 객체 자료형의 파라미터 수집
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        log.info("POST todo register....");

        if (bindingResult.hasErrors()) {
            log.info("has errors......");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/todo/register";
        }

        log.info(todoDTO);

        todoService.register(todoDTO);

        return "redirect:/todo/list";
    }

    // 스프링 MVC에는 여러 개의 경로를 배열과 같은 표기법을 이용해서 하나의 @GetMapping으로 처리할 수 있기 때문에
    // 수정과 삭제에도 같은 메소드를 이용
    @GetMapping({"/read", "modify"})
    public void read(Long tno, Model model) {
        TodoDTO todoDTO = todoService.getOne(tno);
        log.info(todoDTO);

        model.addAttribute("dto", todoDTO);
    }

    @PostMapping("/remove")
    public String remove(Long tno, RedirectAttributes redirectAttributes) {
        log.info("------------- remove ---------------");
        log.info("tno: " + tno);

        todoService.remove(tno);

        return "redirect:/todo/list";
    }

    @PostMapping("/modify")
    public String modify(@Valid TodoDTO todoDTO,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            log.info("has errors......");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addAttribute("tno", todoDTO.getTno());
            return "redirect:/todo/modify";
        }

        log.info(todoDTO);

        todoService.modify(todoDTO);

        return "redirect:/todo/list";
    }
}
