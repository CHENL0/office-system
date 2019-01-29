package com.office.system.modlues.wkM.dao;


import org.apache.ibatis.annotations.Param;

import com.office.system.common.baseDao.CrudDao;
import com.office.system.modlues.wkM.entity.WkWorkReport;

import java.util.List;

public interface WkWorkReportDao extends CrudDao<WkWorkReport>{
    List<WkWorkReport> selectAllByCreateBy(WkWorkReport wkWorkReport);
    List<WkWorkReport> selectAllByAuditUserId(WkWorkReport wkWorkReport);
    void updateDelFlagByIdForUser(String id);
    void updateDelFlagByIdForAudit(String id);
    WkWorkReport selectByPrimaryKey(String wkWorkReportId);

}