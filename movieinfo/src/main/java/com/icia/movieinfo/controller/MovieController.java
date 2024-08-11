package com.icia.movieinfo.controller;

import com.icia.movieinfo.dto.MovieDto;
import com.icia.movieinfo.service.MovieService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Slf4j
public class MovieController {
    ModelAndView mav;

    // 서비스
    @Autowired
    private MovieService movieService;

    @GetMapping("/")
    public ModelAndView getList(Integer pageNum, HttpSession session) {
        log.info("getList()");

        mav = movieService.getMovielist(pageNum, session);
        return mav;
    }

    @GetMapping("writeFrm")
    public String writeFrm(){
        log.info("writeFrm()");

        return "writeFrm";
    }

    // @RequestPart: multipart 전용
    @PostMapping("writeProc")
    public String writeProc(@RequestPart List<MultipartFile> files,
                            MovieDto movie,
                            HttpSession session,
                            // RedirectAttributes: Redirect(서버에서 클라이언트로 명령)시 사용자의 컴퓨터로 갔다가 다시 새로운 요청이 들어오므로 데이터 유지를 위해
                            RedirectAttributes rttr) {
        log.info("writeProc()");
        String view = movieService.insertMovie(files, movie, session, rttr);

        return view;
    }

    @GetMapping("detail")
//    public ModelAndView detail(Integer m_code){ // TODO: 차이점?
    public ModelAndView detail(int m_code){
        log.info("detail()");

        mav = movieService.getMovie(m_code);
        mav.setViewName("detail");

        return mav;
    }

    //수정 페이지로 전환
    @GetMapping("updateFrm")
    public ModelAndView updateFrm(Integer m_code){
        log.info("updateFrm()");

        mav = movieService.getMovie(m_code);
        mav.setViewName("updateFrm");

        return mav;
    }

    @PostMapping("updateProc")
    public String updateProc(@RequestPart List<MultipartFile> files,
                             MovieDto movie,
                             HttpSession session,
                             RedirectAttributes rttr){
        log.info("updateProc()");

        String view = movieService.movieUpdate(files, movie, session, rttr);

        return view;
    }

    //delete 메소드 추가
    @GetMapping("delete")
    public String delete(Integer m_code){
        log.info("delete()");

        String view = movieService.deleteMovie(m_code);

        return view;
    }
}
