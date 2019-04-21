package com.office.system.modlues.rlM.entity;

import java.util.Date;

import com.office.system.common.baseEntity.DataEntity;

public class RlRuleMessage extends DataEntity<RlRuleMessage> {

    private String text;

    private String ruleTitle;

    public String getRuleTitle() {
        return ruleTitle;
    }

    public void setRuleTitle(String ruleTitle) {
        this.ruleTitle = ruleTitle;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }
}