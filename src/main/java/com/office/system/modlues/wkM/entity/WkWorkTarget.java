package com.office.system.modlues.wkM.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.office.system.common.baseEntity.DataEntity;
import com.office.system.modlues.sysMsgM.entity.SysODepartment;
import org.springframework.format.annotation.DateTimeFormat;

public class WkWorkTarget  extends DataEntity<WkWorkTarget>{

    private String text;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endDate;

    private String departmentId;

    private SysODepartment sysODepartment;

    public SysODepartment getSysODepartment() {
        return sysODepartment;
    }

    public void setSysODepartment(SysODepartment sysODepartment) {
        this.sysODepartment = sysODepartment;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
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
}