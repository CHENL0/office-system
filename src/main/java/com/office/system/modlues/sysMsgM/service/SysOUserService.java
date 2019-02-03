package com.office.system.modlues.sysMsgM.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.office.system.common.baseService.CrudService;
import com.office.system.modlues.sysMsgM.dao.SysODepartmentDao;
import com.office.system.modlues.sysMsgM.dao.SysOUserDao;
import com.office.system.modlues.sysMsgM.entity.SysODepartment;
import com.office.system.modlues.sysMsgM.entity.SysOUser;

@Service
@Transactional(readOnly = true)
public class SysOUserService extends CrudService<SysOUserDao,SysOUser>{
	
	@Autowired
	SysOUserDao sysOUserDao;
	
	//修改密码
	public void updatePasswordById(SysOUser sysOUser){
		sysOUserDao.updatePasswordById(sysOUser);
	}
	//保存
//	public void save(SysOUser sysOUser,MultipartFile Mphoto,HttpSession session) throws IllegalStateException, IOException{
//
//		String path = session.getServletContext().getRealPath("/sysOUserPhoto");//获取应用根目录下的sysOUserPhoto文件夹
//		String fileName = Mphoto.getOriginalFilename();//上传文件名
//   		File file = new File(path, fileName);
//   		Mphoto.transferTo(file);//将上传文件写到服务器上指定的文件。
//   		sysOUser.setPhoto(fileName);
//   		sysOUserDao.insert(sysOUser);
//   		
//	}
	//删除
	public void delete(SysOUser sysOUser){
		super.delete(sysOUser);
		sysOUserDao.deleteGetSysOUserEmail(sysOUser);
		sysOUserDao.deleteSendSysOUserEmail(sysOUser);
	}
	

}
