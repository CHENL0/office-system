package com.itheima.mybatis.mapper;

import com.itheima.mybatis.pojo.InfEmail;
import com.itheima.mybatis.pojo.InfEmailExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InfEmailMapper {
    int countByExample(InfEmailExample example);

    int deleteByExample(InfEmailExample example);

    int deleteByPrimaryKey(String id);

    int insert(InfEmail record);

    int insertSelective(InfEmail record);

    List<InfEmail> selectByExample(InfEmailExample example);

    InfEmail selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") InfEmail record, @Param("example") InfEmailExample example);

    int updateByExample(@Param("record") InfEmail record, @Param("example") InfEmailExample example);

    int updateByPrimaryKeySelective(InfEmail record);

    int updateByPrimaryKey(InfEmail record);
}