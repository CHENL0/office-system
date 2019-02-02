package com.office.system.common.baseWeb;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.office.system.modlues.sysMsgM.entity.SysOUser;
import com.office.system.modlues.sysMsgM.service.SysOUserService;

import oracle.net.aso.s;
/**
 * 登录管理
 * @author lzc
 *
 */
@Controller
@RequestMapping("/a")
public class LoginController {
	
	@Autowired
	 SysOUserService sysOUserService;
	
	@RequestMapping(value="/login.do",method=RequestMethod.GET)
	public String login(HttpServletRequest request){
		
			return "redirect:" + "/a/index.do";		
	}
	
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	public String login1(HttpServletRequest request,SysOUser sysOUser,Model model){
			String passwordMD5 = DigestUtils.md5Hex(sysOUser.getPassword());
			sysOUser.setPassword(passwordMD5);
		    List<SysOUser> users = sysOUserService.findList(new SysOUser());
		    String message  = null;
		    for (SysOUser user2 : users) {
		      if(user2.getPassword() != null && user2.getPassword() != ""){
				if(user2.getPassword().equals(sysOUser.getPassword()) && user2.getLoginName().equals(sysOUser.getLoginName())){
					request.getSession().setAttribute("login_flag", "true");//设置登录标志true为登录成功
					request.getSession().setAttribute("currentUserId", user2.getId());//为了首页能获取当前用户的
					request.getSession().setAttribute("currentRoleName", user2.getSysORole().getName());
					return "redirect:" + "/a/index.do";
				}
		      }
			}
			message = "登录失败，用户名或密码错误";
			model.addAttribute("message", message);
			return "common/login";		
	}

}
