package com.icia.movieinfo.controller;

import com.icia.movieinfo.dto.MovieDto;
import com.icia.movieinfo.service.MovieService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Slf4j
public class MovieController {

    // 서비스
    @Autowired
    private MovieService movieService;

    @GetMapping("/")
    public String getList(Integer pageNum, HttpSession session, Model model) {
        log.info("getList()");

        List<MovieDto> mList = movieService.getMovielist(pageNum, session);
        model.addAttribute("mList", mList);

        return "list";
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

}
