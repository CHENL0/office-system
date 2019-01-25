package com.office.system.modlues.rlM.dao;


import org.apache.ibatis.annotations.Param;

import com.office.system.common.baseDao.CrudDao;
import com.office.system.modlues.rlM.entity.RlOvertime;

import java.util.List;

public interface RlOvertimeDao extends CrudDao<RlOvertime> {
    List<RlOvertime> selectAllByCreateBy (String createBy);
    RlOvertime selectByPrimaryKey (String overtimeId);
    void updateDelFlagById(String id);
    void updateStatusById (@Param("overtimeId") String overtimeId,@Param("overtimeStatus")int overtimeStatus);

}