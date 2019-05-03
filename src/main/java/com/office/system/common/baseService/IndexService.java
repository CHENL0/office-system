package com.office.system.common.baseService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.office.system.modlues.sysMsgM.dao.SysODepartmentDao;
import com.office.system.modlues.sysMsgM.dao.SysOUserDao;
import com.office.system.modlues.sysMsgM.entity.SysODepartment;
import com.office.system.modlues.sysMsgM.entity.SysOUser;

@Service
public class IndexService {

	@Autowired
	SysOUserDao sysOUserDao;
	
	@Autowired
	SysODepartmentDao sysODepartmentDao;
	
	public List<List<String>> getListGroupBtCreateTime() {
		
		List<List<String>> tempList = new ArrayList();
		
		
		List<String> listGroupBtCreateTime = sysOUserDao.getListGroupByCreateTime();
		
		List<SysODepartment> departmentList = sysODepartmentDao.findList(new SysODepartment());
		
		for(int i = 0; i < departmentList.size(); i++) {
//			List<String> departmentArray = new ArrayList();
			SysOUser sysoUser = new SysOUser();
			sysoUser.setSysODepartment(departmentList.get(i));
			
			List<String> departmentArray = sysOUserDao.getListGroupByCreateTimeWithDept(sysoUser);
			departmentArray.add(0,departmentList.get(i).getName());
			tempList.add(departmentArray);
		}
		
		listGroupBtCreateTime.add(0,"years");
		tempList.add(0,listGroupBtCreateTime);
		
		return tempList;
		
	}
}
