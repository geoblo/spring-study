package com.icia.movieinfo.service;

import com.icia.movieinfo.dao.MovieDao;
import com.icia.movieinfo.dto.MovieDto;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class MovieService {
    @Autowired
    private MovieDao movieDao;

//    private ModelAndView mav;

    private int listCnt = 5;

//    public ModelAndView getMovielist(Integer pageNum, HttpSession session) {
    public List<MovieDto> getMovielist(Integer pageNum, HttpSession session) {
        log.info("getMovielist()");
//        mav = new ModelAndView();

        if (pageNum == null) {
            pageNum = 1;
        }

        Map<String, Integer> map = new HashMap<>();
        map.put("pageNum", (pageNum - 1) * listCnt);
        map.put("listCnt", listCnt);

        List<MovieDto> mList = movieDao.getMovieList(map);
//        mav.addObject("mList", mList);
        
        // paging 처리

        session.setAttribute("pageNum", pageNum);

        return mList;
    }

    public String insertMovie(List<MultipartFile> files,
                              MovieDto movie,
                              HttpSession session,
                              RedirectAttributes rttr) {
        log.info("insertMovie()");
        String msg = null;
        String view = null;

        try {
            if(!files.get(0).isEmpty()) {
                fileUpload(files, session, movie);
            }
            movieDao.insertMovie(movie);
            view = "redirect:/?pageNum=1";
            msg = "작성 성공";
        } catch (Exception e) {
            e.printStackTrace();
            view = "redirect:writeFrm";
            msg = "작성 실패";
        }

        rttr.addFlashAttribute("msg", msg);
        return view;
    }

    private void fileUpload(List<MultipartFile> files,
                            HttpSession session,
                            MovieDto movie) throws Exception {
        log.info("fileUpload()");
        String sysname = null; // 변경할 이름
        String oriname = null; // 원본 이름

        String realPath = session.getServletContext().getRealPath("/"); // /webapp 까지의 경로
        realPath += "upload/";
        File folder = new File(realPath);
        if(folder.isDirectory() == false){//폴더가 없을 경우 실행.
            folder.mkdir();//폴더 생성 메소드
        }

        MultipartFile mf = files.get(0);
        oriname = mf.getOriginalFilename();//업로드 파일명 가져오기

        sysname = System.currentTimeMillis() + oriname.substring(oriname.lastIndexOf("."));
        //업로드하는 파일을 upload 폴더에 저장.
        File file = new File(realPath + sysname);
        //파일 저장(upload 폴더)
        mf.transferTo(file);

//        movie.setP_oriname(oriname);
        movie.setP_sysname(sysname);
    }

}
