package com.office.system.common.baseWeb;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.office.system.modlues.sysMsgM.entity.User;
import com.office.system.modlues.sysMsgM.service.UserService;



/**
 * 访问主页
 * @author 
 *
 */
@Controller
@RequestMapping("/a")
public class IndexController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value={"/index.do",""})
	public String index(HttpServletRequest request,Model model){
		String loginFlag = (String) request.getSession().getAttribute("login_flag");
		String currentUserId = (String) request.getSession().getAttribute("currentUserId");
		//判断seesion里面是否存在登录标志
		if (loginFlag !=null && loginFlag != "" && currentUserId != null && currentUserId !=""){
		  if(loginFlag.equals("true")){
			//向model添加内容
			  User currentUser = userService.get(new User(currentUserId));
			  model.addAttribute("currentUser",currentUser);
			return "common/index";
		  }
		}
		return "common/login";
		
	}

}
