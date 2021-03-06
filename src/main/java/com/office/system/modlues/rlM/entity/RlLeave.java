package com.office.system.modlues.rlM.entity;

import java.util.Date;

import com.office.system.common.baseEntity.DataEntity;
import com.office.system.modlues.sysMsgM.entity.SysOUser;
import org.springframework.format.annotation.DateTimeFormat;

public class RlLeave extends DataEntity<RlLeave>{

    private String reason;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endDate;

    private String auditUserId;

    private int leaveStatus;

    private String leaveType;

    private SysOUser auditUser;

    public SysOUser getAuditUser() {
        return auditUser;
    }

    public void setAuditUser(SysOUser auditUser) {
        this.auditUser = auditUser;
    }

    public int getLeaveStatus() {
        return leaveStatus;
    }

    public void setLeaveStatus(int leaveStatus) {
        this.leaveStatus = leaveStatus;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getAuditUserId() {
        return auditUserId;
    }

    public void setAuditUserId(String auditUserId) {
        this.auditUserId = auditUserId == null ? null : auditUserId.trim();
    }
}