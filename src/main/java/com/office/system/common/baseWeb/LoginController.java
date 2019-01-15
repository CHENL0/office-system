package com.office.system.common.baseWeb;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.office.system.modlues.sysMsgM.entity.User;
import com.office.system.modlues.sysMsgM.service.UserService;
/**
 * 登录
 * @author lzc
 *
 */
@Controller
@RequestMapping("/a")
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/login.do",method=RequestMethod.GET)
	public String login(HttpServletRequest request){
		
			return "redirect:" + "/a/index.do";		
	}
	
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	public String login1(HttpServletRequest request,User user){
		    List<User> users = userService.findList(new User());
		    String message  = null;
		    for (User user2 : users) {
				if(user2.getOldPassword().equals(user.getOldPassword()) && user2.getLoginName().equals(user.getLoginName())){
					request.getSession().setAttribute("login_flag", "true");
					request.getSession().setAttribute("currentUserId", user2.getId());//为了首页能获取当前用户的
					return "redirect:" + "/a/index.do";
				}
			}
			message = "登录失败，用户名或密码错误";
			return "common/login";		
	}

}
