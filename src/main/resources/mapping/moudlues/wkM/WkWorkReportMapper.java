package com.itheima.mybatis.mapper;

import com.itheima.mybatis.pojo.WkWorkReport;
import com.itheima.mybatis.pojo.WkWorkReportExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WkWorkReportMapper {
    int countByExample(WkWorkReportExample example);

    int deleteByExample(WkWorkReportExample example);

    int deleteByPrimaryKey(String id);

    int insert(WkWorkReport record);

    int insertSelective(WkWorkReport record);

    List<WkWorkReport> selectByExample(WkWorkReportExample example);

    WkWorkReport selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WkWorkReport record, @Param("example") WkWorkReportExample example);

    int updateByExample(@Param("record") WkWorkReport record, @Param("example") WkWorkReportExample example);

    int updateByPrimaryKeySelective(WkWorkReport record);

    int updateByPrimaryKey(WkWorkReport record);
}