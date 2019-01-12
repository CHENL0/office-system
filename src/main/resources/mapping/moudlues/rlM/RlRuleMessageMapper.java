package com.itheima.mybatis.mapper;

import com.itheima.mybatis.pojo.RlRuleMessage;
import com.itheima.mybatis.pojo.RlRuleMessageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RlRuleMessageMapper {
    int countByExample(RlRuleMessageExample example);

    int deleteByExample(RlRuleMessageExample example);

    int deleteByPrimaryKey(String id);

    int insert(RlRuleMessage record);

    int insertSelective(RlRuleMessage record);

    List<RlRuleMessage> selectByExample(RlRuleMessageExample example);

    RlRuleMessage selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RlRuleMessage record, @Param("example") RlRuleMessageExample example);

    int updateByExample(@Param("record") RlRuleMessage record, @Param("example") RlRuleMessageExample example);

    int updateByPrimaryKeySelective(RlRuleMessage record);

    int updateByPrimaryKey(RlRuleMessage record);
}