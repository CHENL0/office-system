package com.itheima.mybatis.mapper;

import com.itheima.mybatis.pojo.RlOvertime;
import com.itheima.mybatis.pojo.RlOvertimeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RlOvertimeMapper {
    int countByExample(RlOvertimeExample example);

    int deleteByExample(RlOvertimeExample example);

    int insert(RlOvertime record);

    int insertSelective(RlOvertime record);

    List<RlOvertime> selectByExample(RlOvertimeExample example);

    int updateByExampleSelective(@Param("record") RlOvertime record, @Param("example") RlOvertimeExample example);

    int updateByExample(@Param("record") RlOvertime record, @Param("example") RlOvertimeExample example);
}