package com.office.system.modlues.sysMsgM.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.office.system.modlues.sysMsgM.entity.SysODepartment;
import com.office.system.modlues.sysMsgM.entity.SysORole;
import com.office.system.modlues.sysMsgM.entity.SysOUser;
import com.office.system.modlues.sysMsgM.service.SysODepartmentService;
import com.office.system.modlues.sysMsgM.service.SysORoleService;
import com.office.system.modlues.sysMsgM.service.SysOUserService;

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
    
    @Autowired
    SysORoleService sysORoleService;
    
    
    //保存
	@RequestMapping(value="/save.do",method=RequestMethod.POST)
	public String save(Model model,SysOUser sysOUser,HttpSession session) throws IllegalStateException, IOException{
		
		if (sysOUser !=null && sysOUser.getDelFlag().equals("0")) {
			String passwordMD5 =DigestUtils.md5Hex(sysOUser.getPassword());
			sysOUser.setPassword(passwordMD5);
//			sysOUserService.save(sysOUser,Mphoto,session);
			sysOUserService.save(sysOUser);
			String msg = "添加成功!";
			model.addAttribute("msg", msg);
		}
		return "moudlues/sysMsgM/sysMsgM_SysOUserAdd";
	}
	@RequestMapping(value="/save.do",method=RequestMethod.GET)
	public String save2(Model model,SysOUser sysOUser){
		List<SysODepartment> sysODepartments = sysODepartmentService.findList(new SysODepartment());
		model.addAttribute("sysODepartments", sysODepartments);
		List<SysORole> sysORoles = sysORoleService.findList(new SysORole());
		model.addAttribute("sysORoles", sysORoles);
		return "moudlues/sysMsgM/sysMsgM_SysOUserAdd";
	}
	//列表上用户的信息，post请求的更新，要做更新
	@RequestMapping(value="/update.do",method=RequestMethod.POST)
	public String updateForPost(Model model,SysOUser sysOUser,String newPassword){
		String passwordMD5 =DigestUtils.md5Hex(newPassword);
		sysOUser.setPassword(passwordMD5);
		sysOUserService.update(sysOUser);
		SysOUser sysOUser2 = sysOUserService.get(sysOUser);
		model.addAttribute("sysOUser", sysOUser2);
		String msg = "修改成功!";
		model.addAttribute("msg", msg);
		return "moudlues/sysMsgM/sysMsgM_SysOUserUpdate";
	}
	//get请求的更新，不做更新，只负责跳转页面
	@RequestMapping(value="/update.do",method=RequestMethod.GET)
	public String updateForGet(Model model,SysOUser sysOUser,String current_user_Id){
		SysOUser sysOUser2 = sysOUserService.get(sysOUser);

		SysOUser currentUser = sysOUserService.get(current_user_Id);
		model.addAttribute("sysOUser", sysOUser2);
		model.addAttribute("currentUser", currentUser);
		List<SysODepartment> sysODepartments = sysODepartmentService.findList(new SysODepartment());
		model.addAttribute("sysODepartments", sysODepartments);
		List<SysORole> sysORoles = sysORoleService.findList(new SysORole());
		model.addAttribute("sysORoles", sysORoles);
		return "moudlues/sysMsgM/sysMsgM_SysOUserUpdate";
	}
/*	//修改当前用户信息
	@RequestMapping(value="/updateCurrentUser.do",method=RequestMethod.POST)
	public String updateForPostCurrentUser(Model model,SysOUser sysOUser){
		sysOUserService.update(sysOUser);
		model.addAttribute("sysOUser", sysOUser);
		String msg = "修改成功!";
		model.addAttribute("msg", msg);
		return "moudlues/sysMsgM/sysMsgM_SysOUserUpdate";
	}*/
	//post更新密码
	@RequestMapping(value="/updatePassword.do",method=RequestMethod.POST)
	public String updatePasswordForPost(Model model,SysOUser sysOUser){
		String passwordMD5 =DigestUtils.md5Hex(sysOUser.getPassword());
		sysOUser.setPassword(passwordMD5);
		sysOUserService.updatePasswordById(sysOUser);
		String msg = "修改密码成功!";
		model.addAttribute("msg", msg);
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
	@ResponseBody
	public Object del(Model model,SysOUser sysOUser){
		sysOUserService.delete(sysOUser);
	    Map<String, String> responseDataMap = new HashMap<>();
	    responseDataMap.put("responseData","success");
	    return responseDataMap;
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
	//展示所有用户和分页查询用户（前台已做好分页） 为了给hr重置密码
	@RequestMapping("/listForHr.do")
	public String listForHr(Model model,SysOUser sysOUser){
		List<SysOUser> sysOUsers = sysOUserService.findList(sysOUser);
		model.addAttribute("sysOUserList", sysOUsers);
		return "moudlues/sysMsgM/sysMsgM_SysOUserListForHr";
	}

}
