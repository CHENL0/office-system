package com.office.system.modlues.msgM.entity;

import java.util.Date;

import com.office.system.common.baseEntity.DataEntity;

public class InfNotice extends DataEntity<InfNotice>{

    private String text;

    private Date pushDate;

    private String writerId;

    private String typeId;



    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public Date getPushDate() {
        return pushDate;
    }

    public void setPushDate(Date pushDate) {
        this.pushDate = pushDate;
    }

    public String getWriterId() {
        return writerId;
    }

    public void setWriterId(String writerId) {
        this.writerId = writerId == null ? null : writerId.trim();
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

}