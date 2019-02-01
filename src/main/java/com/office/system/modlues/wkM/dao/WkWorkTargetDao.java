package com.office.system.modlues.wkM.dao;


import org.apache.ibatis.annotations.Param;

import com.office.system.common.baseDao.CrudDao;
import com.office.system.modlues.wkM.entity.WkWorkTarget;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
public interface WkWorkTargetDao extends CrudDao<WkWorkTarget> {
     WkWorkTarget selectByPrimaryKey(String wkWorkTargetId);
     void updateDelFlagById(String id);
}