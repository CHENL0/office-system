package com.itheima.mybatis.mapper;

import com.itheima.mybatis.pojo.WkWorkTarget;
import com.itheima.mybatis.pojo.WkWorkTargetExample;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface WkWorkTargetMapper {
    int countByExample(WkWorkTargetExample example);

    int deleteByExample(WkWorkTargetExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(WkWorkTarget record);

    int insertSelective(WkWorkTarget record);

    List<WkWorkTarget> selectByExample(WkWorkTargetExample example);

    WkWorkTarget selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") WkWorkTarget record, @Param("example") WkWorkTargetExample example);

    int updateByExample(@Param("record") WkWorkTarget record, @Param("example") WkWorkTargetExample example);

    int updateByPrimaryKeySelective(WkWorkTarget record);

    int updateByPrimaryKey(WkWorkTarget record);
}