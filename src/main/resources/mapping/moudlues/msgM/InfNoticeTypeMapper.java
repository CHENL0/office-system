package com.itheima.mybatis.mapper;

import com.itheima.mybatis.pojo.InfNoticeType;
import com.itheima.mybatis.pojo.InfNoticeTypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InfNoticeTypeMapper {
    int countByExample(InfNoticeTypeExample example);

    int deleteByExample(InfNoticeTypeExample example);

    int deleteByPrimaryKey(String id);

    int insert(InfNoticeType record);

    int insertSelective(InfNoticeType record);

    List<InfNoticeType> selectByExample(InfNoticeTypeExample example);

    InfNoticeType selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") InfNoticeType record, @Param("example") InfNoticeTypeExample example);

    int updateByExample(@Param("record") InfNoticeType record, @Param("example") InfNoticeTypeExample example);

    int updateByPrimaryKeySelective(InfNoticeType record);

    int updateByPrimaryKey(InfNoticeType record);
}