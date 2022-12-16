package xyz.ccola.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;
import xyz.ccola.domain.Movie;

/**
 * @ Name: MovieMapper
 * @ Author: Cola
 * @ Time: 2022/12/16 16:47
 * @ Description: MovieMapper
 */
@Mapper
public interface MovieMapper extends BaseMapper<Movie> {
}
