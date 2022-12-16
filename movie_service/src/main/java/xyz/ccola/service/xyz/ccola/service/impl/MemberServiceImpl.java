package xyz.ccola.service.xyz.ccola.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ccola.domain.Member;
import xyz.ccola.mapper.MemberMapper;
import xyz.ccola.service.MemberService;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @ Name: MemberServiceImpl
 * @ Author: Cola
 * @ Time: 2022/12/16 20:29
 * @ Description: MemberServiceImpl
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public Member selectOne(Wrapper<Member> queryWrapper) {
        return MemberService.super.selectOne(queryWrapper);
    }

    @Override
    public boolean exists(Wrapper<Member> queryWrapper) {
        return MemberService.super.exists(queryWrapper);
    }

    @Override
    public int insert(Member entity) {
        return 0;
    }

    @Override
    public int deleteById(Serializable id) {
        return 0;
    }

    @Override
    public int deleteById(Member entity) {
        return 0;
    }

    @Override
    public int deleteByMap(Map<String, Object> columnMap) {
        return 0;
    }

    @Override
    public int delete(Wrapper<Member> queryWrapper) {
        return 0;
    }

    @Override
    public int deleteBatchIds(Collection<?> idList) {
        return 0;
    }

    @Override
    public int updateById(Member entity) {
        return 0;
    }

    @Override
    public int update(Member entity, Wrapper<Member> updateWrapper) {
        return 0;
    }

    @Override
    public Member selectById(Serializable id) {
        return null;
    }

    @Override
    public List<Member> selectBatchIds(Collection<? extends Serializable> idList) {
        return null;
    }

    @Override
    public List<Member> selectByMap(Map<String, Object> columnMap) {
        return null;
    }

    @Override
    public Long selectCount(Wrapper<Member> queryWrapper) {
        return null;
    }

    @Override
    public List<Member> selectList(Wrapper<Member> queryWrapper) {
        return null;
    }

    @Override
    public List<Map<String, Object>> selectMaps(Wrapper<Member> queryWrapper) {
        return null;
    }

    @Override
    public List<Object> selectObjs(Wrapper<Member> queryWrapper) {
        return null;
    }

    @Override
    public <P extends IPage<Member>> P selectPage(P page, Wrapper<Member> queryWrapper) {
        return null;
    }

    @Override
    public <P extends IPage<Map<String, Object>>> P selectMapsPage(P page, Wrapper<Member> queryWrapper) {
        return null;
    }
}
