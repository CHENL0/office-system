package com.office.system.modlues.sysMsgM.dao;


import org.apache.ibatis.annotations.Param;

import com.office.system.common.baseDao.CrudDao;
import com.office.system.modlues.sysMsgM.entity.SysOUser;

import java.util.List;

public interface SysOUserDao extends CrudDao<SysOUser>{
	//更新密码
	public void updatePasswordById(SysOUser sysOUser);
	SysOUser getHrInfo();
	List<SysOUser> getManagerInfoList();
	//逻辑上删除用户所拥有的邮件
	public void deleteGetSysOUserEmail(SysOUser sysOUser);
	public void deleteSendSysOUserEmail(SysOUser sysOUser);
	//更新部门
	public void updateDepartment(SysOUser sysOUser);
   
}