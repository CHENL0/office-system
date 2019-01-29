package com.office.system.modlues.sysMsgM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.office.system.common.baseService.CrudService;
import com.office.system.modlues.sysMsgM.dao.SysODepartmentDispatchDao;
import com.office.system.modlues.sysMsgM.dao.SysOUserDao;
import com.office.system.modlues.sysMsgM.entity.SysODepartment;
import com.office.system.modlues.sysMsgM.entity.SysODepartmentDispatch;
import com.office.system.modlues.sysMsgM.entity.SysORole;
import com.office.system.modlues.sysMsgM.entity.SysOUser;

@Service
@Transactional(readOnly = true)
public class SysODepartmentDispatchService extends CrudService<SysODepartmentDispatchDao, SysODepartmentDispatch>{
	
	@Autowired
	SysOUserDao sysOUserDao;
	
	public void save(SysODepartmentDispatch sysODepartmentDispatch){
		SysOUser sysOUser = new SysOUser(sysODepartmentDispatch.getDispatchUser().getId());
		sysOUser.setSysODepartment(new SysODepartment(sysODepartmentDispatch.getNewDeparment().getId()));
		sysOUser.setSysORole(new SysORole(sysODepartmentDispatch.getNewRole().getId()));
		sysOUserDao.updateDepartment(sysOUser);
		super.save(sysODepartmentDispatch);
	}

}
