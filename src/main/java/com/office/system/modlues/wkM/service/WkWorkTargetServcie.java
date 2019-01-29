package com.office.system.modlues.wkM.service;

import com.office.system.common.baseService.CrudService;
import com.office.system.modlues.wkM.dao.WkWorkTargetDao;
import com.office.system.modlues.wkM.entity.WkWorkTarget;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Chen
 * @createTime 28 11:07
 * @description
 */
@Service
public class WkWorkTargetServcie extends CrudService<WkWorkTargetDao,WkWorkTarget> {
    @Resource
    private WkWorkTargetDao wkWorkTargetDao;

    public WkWorkTarget selectByPrimaryKey (String wkWorkTargetId){
        return wkWorkTargetDao.selectByPrimaryKey(wkWorkTargetId);
    }

    public void updateDelFlagById (String id){
        wkWorkTargetDao.updateDelFlagById(id);
    }
}
