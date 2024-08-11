package com.icia.movieinfo.dao;

import com.icia.movieinfo.dto.MovieDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MovieDao {
    List<MovieDto> getMovieList(Map<String,Integer> map);

    void insertMovie(MovieDto movieDto);
}
