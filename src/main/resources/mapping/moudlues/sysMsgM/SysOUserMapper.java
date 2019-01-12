package com.itheima.mybatis.mapper;

import com.itheima.mybatis.pojo.SysOUser;
import com.itheima.mybatis.pojo.SysOUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysOUserMapper {
    int countByExample(SysOUserExample example);

    int deleteByExample(SysOUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysOUser record);

    int insertSelective(SysOUser record);

    List<SysOUser> selectByExample(SysOUserExample example);

    SysOUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysOUser record, @Param("example") SysOUserExample example);

    int updateByExample(@Param("record") SysOUser record, @Param("example") SysOUserExample example);

    int updateByPrimaryKeySelective(SysOUser record);

    int updateByPrimaryKey(SysOUser record);
}