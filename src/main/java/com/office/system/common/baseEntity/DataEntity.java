/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.office.system.common.baseEntity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.office.system.modlues.sysMsgM.entity.SysOUser;
import com.office.system.modlues.sysMsgM.entity.User;

/**
 * 数据Entity类
 * @author lzc
 * 
 */
public abstract class DataEntity<T> {

	protected String id;
	protected Date createDate;	// 创建日期
	protected String delFlag; 	// 删除标记（0：正常；1：删除；2：审核）
	protected SysOUser createBy;//创建人
	protected SysOUser updateBy;//更新人
	protected Date updateDate;//更新日期
	
	public DataEntity() {
		super();
		this.delFlag = "0";
	}
	
	public DataEntity(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public SysOUser getCreateBy() {
		return createBy;
	}

	public void setCreateBy(SysOUser createBy) {
		this.createBy = createBy;
	}

	public SysOUser getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(SysOUser updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	


}
