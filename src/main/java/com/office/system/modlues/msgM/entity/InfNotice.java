package com.office.system.modlues.msgM.entity;

import java.util.Date;

import com.office.system.common.baseEntity.DataEntity;

public class InfNotice extends DataEntity<InfNotice>{

    private String text;//内容	

    private Date pushDate;//发布时间

    private String writerId;

    private  InfNoticeType type;//公告的类型
    
    private String title;//公告的标题

    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

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

	public InfNoticeType getType() {
		return type;
	}

	public void setType(InfNoticeType type) {
		this.type = type;
	}


}