package xyz.ccola.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import xyz.ccola.domain.Member;

/**
 * @ Name: MemberService
 * @ Author: Cola
 * @ Time: 2022/12/16 20:28
 * @ Description: MemberService
 */
public interface MemberService extends BaseMapper<Member> {
    /**
     * 根据 id 批量删除
     * @param ids ids
     * @return count
     */
    void deleteByIds(Integer[] ids);
}
