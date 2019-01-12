package com.itheima.mybatis.mapper;

import com.itheima.mybatis.pojo.InfNotice;
import com.itheima.mybatis.pojo.InfNoticeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InfNoticeMapper {
    int countByExample(InfNoticeExample example);

    int deleteByExample(InfNoticeExample example);

    int deleteByPrimaryKey(String id);

    int insert(InfNotice record);

    int insertSelective(InfNotice record);

    List<InfNotice> selectByExample(InfNoticeExample example);

    InfNotice selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") InfNotice record, @Param("example") InfNoticeExample example);

    int updateByExample(@Param("record") InfNotice record, @Param("example") InfNoticeExample example);

    int updateByPrimaryKeySelective(InfNotice record);

    int updateByPrimaryKey(InfNotice record);
}