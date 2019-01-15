package com.office.system.modlues.msgM.entity;

import java.util.Date;

import com.office.system.common.baseEntity.DataEntity;

public class InfEmail extends DataEntity<InfEmail> {
	
    private String text;

    private String staut;

    private Date sendtime;

    private String getUserId;

    private String sendUserId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public String getStaut() {
        return staut;
    }

    public void setStaut(String staut) {
        this.staut = staut == null ? null : staut.trim();
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    public String getGetUserId() {
        return getUserId;
    }

    public void setGetUserId(String getUserId) {
        this.getUserId = getUserId == null ? null : getUserId.trim();
    }

    public String getSendUserId() {
        return sendUserId;
    }

    public void setSendUserId(String sendUserId) {
        this.sendUserId = sendUserId == null ? null : sendUserId.trim();
    }
}