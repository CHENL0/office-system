package com.itheima.mybatis.mapper;

import com.itheima.mybatis.pojo.SysORole;
import com.itheima.mybatis.pojo.SysORoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysORoleMapper {
    int countByExample(SysORoleExample example);

    int deleteByExample(SysORoleExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysORole record);

    int insertSelective(SysORole record);

    List<SysORole> selectByExample(SysORoleExample example);

    SysORole selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysORole record, @Param("example") SysORoleExample example);

    int updateByExample(@Param("record") SysORole record, @Param("example") SysORoleExample example);

    int updateByPrimaryKeySelective(SysORole record);

    int updateByPrimaryKey(SysORole record);
}