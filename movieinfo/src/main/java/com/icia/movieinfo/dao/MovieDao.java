package com.icia.movieinfo.dao;

import com.icia.movieinfo.dto.MovieDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface MovieDao {
    List<MovieDto> getMovieList(Map<String,Integer> map);

    void insertMovie(MovieDto movieDto);

    // xml이 아닌 어노테이션 방식
    @Select("select count(*) from mlist")
    int cntMovie();

    @Select("SELECT * FROM movietbl WHERE m_code=#{m_code}")
    MovieDto movieSelect(Integer m_code);

    void movieUpdate(MovieDto movie);

    // delete 추가
    void movieDelete(Integer m_code);
}
