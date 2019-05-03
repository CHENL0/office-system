package com.office.system.modlues.sysMsgM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.office.system.common.baseService.CrudService;
import com.office.system.modlues.sysMsgM.dao.SysODepartmentDao;
import com.office.system.modlues.sysMsgM.dao.SysORoleDao;
import com.office.system.modlues.sysMsgM.entity.SysODepartment;
import com.office.system.modlues.sysMsgM.entity.SysORole;

@Service
@Transactional(readOnly = true)
public class SysORoleService extends CrudService<SysORoleDao, SysORole>{
	
	/*@Autowired 
	UserDao userDao;
	
	public User getUser(User user){
		return userDao.get(user);
	}*/
	

}
