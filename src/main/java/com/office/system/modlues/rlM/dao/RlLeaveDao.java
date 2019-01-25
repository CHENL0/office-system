package com.office.system.modlues.rlM.dao;


import org.apache.ibatis.annotations.Param;

import com.office.system.common.baseDao.CrudDao;
import com.office.system.modlues.rlM.entity.RlLeave;

import java.util.List;

public interface RlLeaveDao extends CrudDao<RlLeave>{
    List<RlLeave> selectAllByCreateBy (String createBy);
    RlLeave selectByPrimaryKey (String id);
    void updateDelFlagById (String id);
    void  updateStatusById (@Param("leaveId") String leaveId,@Param("leaveStatus")int leaveStatus);
}