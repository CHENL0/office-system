package com.office.system.modlues.msgM.entity;

import java.util.Date;

import com.office.system.common.baseEntity.DataEntity;
import com.office.system.modlues.sysMsgM.entity.SysOUser;

public class InfEmail extends DataEntity<InfEmail> {
	
	private String title;//邮件的标题
	
    private String text;//邮件内容

    private String staut;//邮件状态

    private Date sendTime;//发送时间

    private SysOUser getUser;//接收的人

    private SysOUser sendUser;//发送人

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

    public String getStaut() {
        return staut;
    }

    public void setStaut(String staut) {
        this.staut = staut == null ? null : staut.trim();
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

	public SysOUser getGetUser() {
		return getUser;
	}

	public void setGetUser(SysOUser getUser) {
		this.getUser = getUser;
	}

	public SysOUser getSendUser() {
		return sendUser;
	}

	public void setSendUser(SysOUser sendUser) {
		this.sendUser = sendUser;
	}
    
}