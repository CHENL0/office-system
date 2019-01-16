package com.office.system.modlues.sysMsgM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.office.system.common.baseService.CrudService;
import com.office.system.modlues.sysMsgM.dao.SysODepartmentDao;
import com.office.system.modlues.sysMsgM.dao.UserDao;
import com.office.system.modlues.sysMsgM.entity.SysODepartment;
import com.office.system.modlues.sysMsgM.entity.User;

@Service
@Transactional(readOnly = true)
public class SysODepartmentService extends CrudService<SysODepartmentDao, SysODepartment>{
	
	/*@Autowired 
	UserDao userDao;
	
	public User getUser(User user){
		return userDao.get(user);
	}*/
	

}
