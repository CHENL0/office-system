package com.office.system.modlues.msgM.entity;

import java.util.Date;

public class InfEmail {
    private String id;

    private String text;

    private String staut;

    private Date sendtime;

    private String getUserId;

    private String sendUserId;

    private String delFlag;

    private String creatBy;

    private Date createDate;

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

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public String getCreatBy() {
        return creatBy;
    }

    public void setCreatBy(String creatBy) {
        this.creatBy = creatBy == null ? null : creatBy.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}