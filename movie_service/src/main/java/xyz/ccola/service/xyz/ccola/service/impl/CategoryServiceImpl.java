package xyz.ccola.service.xyz.ccola.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ccola.domain.Category;
import xyz.ccola.mapper.CategoryMapper;
import xyz.ccola.service.CategoryService;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @ Name: CategoryServiceImpl
 * @ Author: Cola
 * @ Time: 2022/12/16 20:29
 * @ Description: CategoryServiceImpl
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public Category selectOne(Wrapper<Category> queryWrapper) {
        return CategoryService.super.selectOne(queryWrapper);
    }

    @Override
    public boolean exists(Wrapper<Category> queryWrapper) {
        return CategoryService.super.exists(queryWrapper);
    }

    @Override
    public int insert(Category entity) {
        return 0;
    }

    @Override
    public int deleteById(Serializable id) {
        return 0;
    }

    @Override
    public int deleteById(Category entity) {
        return 0;
    }

    @Override
    public int deleteByMap(Map<String, Object> columnMap) {
        return 0;
    }

    @Override
    public int delete(Wrapper<Category> queryWrapper) {
        return 0;
    }

    @Override
    public int deleteBatchIds(Collection<?> idList) {
        return 0;
    }

    @Override
    public int updateById(Category entity) {
        return 0;
    }

    @Override
    public int update(Category entity, Wrapper<Category> updateWrapper) {
        return 0;
    }

    @Override
    public Category selectById(Serializable id) {
        return null;
    }

    @Override
    public List<Category> selectBatchIds(Collection<? extends Serializable> idList) {
        return null;
    }

    @Override
    public List<Category> selectByMap(Map<String, Object> columnMap) {
        return null;
    }

    @Override
    public Long selectCount(Wrapper<Category> queryWrapper) {
        return null;
    }

    @Override
    public List<Category> selectList(Wrapper<Category> queryWrapper) {
        return categoryMapper.selectList(queryWrapper);
    }

    @Override
    public List<Map<String, Object>> selectMaps(Wrapper<Category> queryWrapper) {
        return null;
    }

    @Override
    public List<Object> selectObjs(Wrapper<Category> queryWrapper) {
        return null;
    }

    @Override
    public <P extends IPage<Category>> P selectPage(P page, Wrapper<Category> queryWrapper) {
        return null;
    }

    @Override
    public <P extends IPage<Map<String, Object>>> P selectMapsPage(P page, Wrapper<Category> queryWrapper) {
        return null;
    }
}
