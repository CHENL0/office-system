package com.itheima.mybatis.mapper;

import com.itheima.mybatis.pojo.RlLeave;
import com.itheima.mybatis.pojo.RlLeaveExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RlLeaveMapper {
    int countByExample(RlLeaveExample example);

    int deleteByExample(RlLeaveExample example);

    int deleteByPrimaryKey(String id);

    int insert(RlLeave record);

    int insertSelective(RlLeave record);

    List<RlLeave> selectByExample(RlLeaveExample example);

    RlLeave selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RlLeave record, @Param("example") RlLeaveExample example);

    int updateByExample(@Param("record") RlLeave record, @Param("example") RlLeaveExample example);

    int updateByPrimaryKeySelective(RlLeave record);

    int updateByPrimaryKey(RlLeave record);
}