package com.itheima.mybatis.mapper;

import com.itheima.mybatis.pojo.SysODepartment;
import com.itheima.mybatis.pojo.SysODepartmentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysODepartmentMapper {
    int countByExample(SysODepartmentExample example);

    int deleteByExample(SysODepartmentExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysODepartment record);

    int insertSelective(SysODepartment record);

    List<SysODepartment> selectByExample(SysODepartmentExample example);

    SysODepartment selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysODepartment record, @Param("example") SysODepartmentExample example);

    int updateByExample(@Param("record") SysODepartment record, @Param("example") SysODepartmentExample example);

    int updateByPrimaryKeySelective(SysODepartment record);

    int updateByPrimaryKey(SysODepartment record);
}