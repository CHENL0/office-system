package com.office.system.modlues.wkM.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.office.system.common.baseEntity.DataEntity;

public class WkWorkTarget  extends DataEntity<WkWorkTarget>{

    private String text;

    private Date startDate;

    private Date endDate;


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