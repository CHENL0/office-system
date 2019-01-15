package com.office.system.modlues.sysMsgM.entity;

import java.util.Date;

import com.office.system.common.baseEntity.DataEntity;

public class SysODepartment extends DataEntity<SysODepartment> {

    private String name;

    private String text;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }
}