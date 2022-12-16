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

    /**
     * 根据 id 批量删除
     * @param ids ids
     */
    void deleteByIds(Integer[] ids);

    /**
     * 根据类型 cid 查询
     * @param cid 分类 id
     * @return Movie 集
     */
    List<Movie> findByCid(Integer cid);
}
