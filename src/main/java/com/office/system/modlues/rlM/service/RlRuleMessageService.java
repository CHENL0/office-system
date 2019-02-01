package com.office.system.modlues.rlM.service;

import com.office.system.common.baseService.CrudService;
import com.office.system.modlues.rlM.dao.RlRuleMessageDao;
import com.office.system.modlues.rlM.entity.RlRuleMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Chen
 * @createTime 2019117 14:44
 * @description the service of RlRuleMessage
 */
@Service
public class RlRuleMessageService extends CrudService<RlRuleMessageDao, RlRuleMessage> {

    @Resource
    RlRuleMessageDao rlRuleMessageDao;

    public RlRuleMessage selectByPrimaryKey(String ruleId){
        return rlRuleMessageDao.selectByPrimaryKey(ruleId);
    }

    public void updateDelFlagById (String id){
        rlRuleMessageDao.updateDelFlagById(id);
    }
}
