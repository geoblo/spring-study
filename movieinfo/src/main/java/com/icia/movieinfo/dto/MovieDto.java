package com.icia.movieinfo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Data
@Getter
@Setter
public class MovieDto {
    private int m_code;
    private String m_name;//제목
    private String m_director;//감독
    private String m_nation;//국가
    private String m_genre;//장르
    private String m_actor;//주연배우
    private String m_open;//개봉일
    private String m_synopsis;//영화 개요
//    private String p_oriname;//포스터이미지 이름(수업에서 다운로드는 안할거라 생략)
    private String p_sysname;//포스터 저장 이름
}
