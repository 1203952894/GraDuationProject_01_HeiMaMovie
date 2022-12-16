package xyz.ccola.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import xyz.ccola.domain.Member;

/**
 * @ Name: MemberMapper
 * @ Author: Cola
 * @ Time: 2022/12/16 20:27
 * @ Description: MemberMapper
 */
@Mapper
public interface MemberMapper extends BaseMapper<Member> {
}
