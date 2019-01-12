package com.office.system.modlues.msgM.entity;

import java.util.Date;

import com.office.system.common.baseEntity.DataEntity;

public class Email extends DataEntity<Email>{
	
	private String text;//邮件的内容
	
	private String staut;//状态 0 已读 1 未读
	
	private Date sendTime;//发送的时间

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getStaut() {
		return staut;
	}

	public void setStaut(String staut) {
		this.staut = staut;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	

}
