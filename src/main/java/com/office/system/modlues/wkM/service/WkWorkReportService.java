package com.office.system.modlues.wkM.service;

import com.office.system.common.baseService.CrudService;
import com.office.system.modlues.wkM.dao.WkWorkReportDao;
import com.office.system.modlues.wkM.dao.WkWorkTargetDao;
import com.office.system.modlues.wkM.entity.WkWorkReport;
import com.office.system.modlues.wkM.entity.WkWorkTarget;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Chen
 * @createTime 28 11:06
 * @description
 */
@Service
public class WkWorkReportService extends CrudService<WkWorkReportDao,WkWorkReport> {
    @Resource
    private WkWorkReportDao wkWorkReportDao;

    public List<WkWorkReport> selectAllByCreateBy(WkWorkReport wkWorkReport){
        return wkWorkReportDao.selectAllByCreateBy(wkWorkReport);
    }
    public List<WkWorkReport> selectAllByAuditUserId(WkWorkReport wkWorkReport){
        return wkWorkReportDao.selectAllByAuditUserId(wkWorkReport);
    }
    public void updateDelFlagByIdForUser(String id){
        wkWorkReportDao.updateDelFlagByIdForUser(id);
    }
    public void updateDelFlagByIdForAudit(String id){
        wkWorkReportDao.updateDelFlagByIdForAudit(id);
    }
    public WkWorkReport selectByPrimaryKey(String wkWorkReportId){
        return wkWorkReportDao.selectByPrimaryKey(wkWorkReportId);
    }
}
