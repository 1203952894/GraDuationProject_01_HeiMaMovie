package xyz.ccola.service.xyz.ccola.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.ccola.domain.Movie;
import xyz.ccola.mapper.MovieMapper;
import xyz.ccola.service.MovieService;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @ Name: MovieServiceImpl
 * @ Author: Cola
 * @ Time: 2022/12/16 16:45
 * @ Description: MovieServiceImpl
 */
@Service
@Data
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieMapper movieMapper;

    @Override
    @Transactional
    public void deleteByIds(Integer[] ids) {
        for (Integer id : ids) {
            movieMapper.deleteById(id);
        }
    }

    @Override
    public List<Movie> findByCid(Integer cid) {
        QueryWrapper<Movie> wrapper = new QueryWrapper<>();
        wrapper.eq("cid", cid);
        return movieMapper.selectList(wrapper);
    }

    @Override
    public Movie selectOne(Wrapper<Movie> queryWrapper) {
        return MovieService.super.selectOne(queryWrapper);
    }

    @Override
    public boolean exists(Wrapper<Movie> queryWrapper) {
        return MovieService.super.exists(queryWrapper);
    }

    @Override
    public int insert(Movie entity) {
        return movieMapper.insert(entity);
    }

    @Override
    public int deleteById(Serializable id) {
        return movieMapper.deleteById(id);
    }

    @Override
    public int deleteById(Movie entity) {
        return 0;
    }

    @Override
    public int deleteByMap(Map<String, Object> columnMap) {
        return 0;
    }

    @Override
    public int delete(Wrapper<Movie> queryWrapper) {
        return 0;
    }

    @Override
    public int deleteBatchIds(Collection<?> idList) {
        return 0;
    }

    @Override
    public int updateById(Movie entity) {
        return movieMapper.updateById(entity);
    }

    @Override
    public int update(Movie entity, Wrapper<Movie> updateWrapper) {
        return 0;
    }

    @Override
    public Movie selectById(Serializable id) {
        return movieMapper.selectById(id);
    }

    @Override
    public List<Movie> selectBatchIds(Collection<? extends Serializable> idList) {
        return null;
    }

    @Override
    public List<Movie> selectByMap(Map<String, Object> columnMap) {
        return null;
    }

    @Override
    public Long selectCount(Wrapper<Movie> queryWrapper) {
        return null;
    }

    @Override
    public List<Movie> selectList(Wrapper<Movie> queryWrapper) {
        return movieMapper.selectList(queryWrapper);
    }

    @Override
    public List<Map<String, Object>> selectMaps(Wrapper<Movie> queryWrapper) {
        return null;
    }

    @Override
    public List<Object> selectObjs(Wrapper<Movie> queryWrapper) {
        return null;
    }

    @Override
    public <P extends IPage<Movie>> P selectPage(P page, Wrapper<Movie> queryWrapper) {
        return null;
    }

    @Override
    public <P extends IPage<Map<String, Object>>> P selectMapsPage(P page, Wrapper<Movie> queryWrapper) {
        return null;
    }
}
