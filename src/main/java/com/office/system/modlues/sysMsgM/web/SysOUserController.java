package com.office.system.modlues.sysMsgM.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.office.system.modlues.sysMsgM.entity.SysODepartment;
import com.office.system.modlues.sysMsgM.entity.SysOUser;
import com.office.system.modlues.sysMsgM.entity.User;
import com.office.system.modlues.sysMsgM.service.SysODepartmentService;
import com.office.system.modlues.sysMsgM.service.SysOUserService;
import com.office.system.modlues.sysMsgM.service.UserService;

/**
 * 个人信息和用户的所有信息模块
 * @author lzc
 *
 */
@Controller
@RequestMapping("/a/sysUser")
public class SysOUserController {
	
    @Autowired
	SysOUserService sysOUserService;
    
    @Autowired
    SysODepartmentService sysODepartmentService;
    
    //保存
	@RequestMapping(value="/save.do",method=RequestMethod.POST)
	public String save(Model model,@RequestParam MultipartFile Mphoto,SysOUser sysOUser,HttpSession session) throws IllegalStateException, IOException{
		if (sysOUser !=null && sysOUser.getDelFlag().equals("0")) {
			sysOUserService.save(sysOUser,Mphoto,session);
		}
		return "moudlues/sysMsgM/sysMsgM_SysOUserAdd";
	}
	@RequestMapping(value="/save.do",method=RequestMethod.GET)
	public String save2(SysOUser sysOUser) throws IllegalStateException, IOException{
		
		return "moudlues/sysMsgM/sysMsgM_SysOUserAdd";
	}
	//post请求的更新，要做更新
	@RequestMapping(value="/update.do",method=RequestMethod.POST)
	public String updateForPost(Model model,SysOUser sysOUser){
		sysOUserService.update(sysOUser);
		model.addAttribute("sysOUser", sysOUser);
		return "moudlues/sysMsgM/sysMsgM_SysOUserUpdate";
	}
	//get请求的更新，不做更新，只负责跳转页面
	@RequestMapping(value="/update.do",method=RequestMethod.GET)
	public String updateForGet(Model model,SysOUser sysOUser){
		SysOUser sysOUser2 = sysOUserService.get(sysOUser);
		model.addAttribute("sysOUser", sysOUser2);
		return "moudlues/sysMsgM/sysMsgM_SysOUserUpdate";
	}
	//post更新密码
	@RequestMapping(value="/updatePassword.do",method=RequestMethod.POST)
	public String updatePasswordForPost(Model model,SysOUser sysOUser){
		sysOUserService.updatePasswordById(sysOUser);
		model.addAttribute("sysOUser", sysOUser);
		return "moudlues/sysMsgM/sysMsgM_SysOUserUpdatePassword";
	}
	//get更新密码
	@RequestMapping(value="/updatePassword.do",method=RequestMethod.GET)
	public String updatePasswordForGet(Model model,SysOUser sysOUser){
		SysOUser sysOUser2 = sysOUserService.get(sysOUser);
		model.addAttribute("sysOUser", sysOUser2);
		return "moudlues/sysMsgM/sysMsgM_SysOUserUpdatePassword";
	}
	//逻辑上删除
	@RequestMapping("/del.do")
	public String del(Model model,SysOUser sysOUser){
		sysOUserService.delete(sysOUser);
		return "moudlues/sysMsgM/sysMsgM_SysOUserList";
	}
	//查询个人信息
	@RequestMapping("/show.do")
	public String from(Model model,SysOUser sysOUser){
		SysOUser sysOUser2 = sysOUserService.get(sysOUser);
		model.addAttribute("sysOUser", sysOUser2);
		return "moudlues/sysMsgM/sysMsgM_SysOUserShow";
	}
	//展示所有用户和分页查询用户（前台已做好分页）
	@RequestMapping("/list.do")
	public String list(Model model,SysOUser sysOUser){
		List<SysOUser> sysOUsers = sysOUserService.findList(sysOUser);
		model.addAttribute("sysOUserList", sysOUsers);
		return "moudlues/sysMsgM/sysMsgM_SysOUserList";
	}

}
