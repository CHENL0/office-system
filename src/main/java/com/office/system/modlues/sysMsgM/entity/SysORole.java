package com.office.system.modlues.sysMsgM.entity;

import java.util.Date;

import com.office.system.common.baseEntity.DataEntity;

public class SysORole extends DataEntity<SysORole>{

    private String name;

    public SysORole(){
    	
    }
    public SysORole(String id) {
    	this.id = id;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}