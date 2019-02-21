package com.office.system.modlues.rlM.entity;

import java.util.Date;

import com.office.system.common.baseEntity.DataEntity;
import com.office.system.modlues.sysMsgM.entity.SysOUser;
import org.springframework.format.annotation.DateTimeFormat;

public class RlOvertime extends DataEntity<RlOvertime>{
//    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private String startDate;
//    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private String endDate;

    private String auditUserId;

    private String reason;

    private int overtimeStatus;

    private SysOUser auditUser;

    public SysOUser getAuditUser() {
        return auditUser;
    }

    public void setAuditUser(SysOUser auditUser) {
        this.auditUser = auditUser;
    }

    public int getOvertimeStatus() {
        return overtimeStatus;
    }

    public void setOvertimeStatus(int overtimeStatus) {
        this.overtimeStatus = overtimeStatus;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getAuditUserId() {
        return auditUserId;
    }

    public void setAuditUserId(String auditUserId) {
        this.auditUserId = auditUserId == null ? null : auditUserId.trim();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

}