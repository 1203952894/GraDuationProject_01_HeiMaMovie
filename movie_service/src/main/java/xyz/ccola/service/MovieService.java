package xyz.ccola.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import xyz.ccola.domain.Movie;

import java.io.Serializable;
import java.util.List;

/**
 * @ Name: MovieService
 * @ Author: Cola
 * @ Time: 2022/12/16 16:44
 * @ Description: MovieService
 */
public interface MovieService extends BaseMapper<Movie> {

    void deleteByIds(Integer[] ids);

}
