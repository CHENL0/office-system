package com.office.system.modlues.rlM.dao;


import org.apache.ibatis.annotations.Param;

import com.office.system.common.baseDao.CrudDao;
import com.office.system.modlues.rlM.entity.RlRuleMessage;

import java.util.List;

public interface RlRuleMessageDao extends CrudDao<RlRuleMessage> {
    RlRuleMessage selectByPrimaryKey(String ruleId);
    void updateDelFlagById (String id);
}