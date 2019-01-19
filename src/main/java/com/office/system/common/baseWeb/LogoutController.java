package com.office.system.common.baseWeb;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/a")
public class LogoutController {
	
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest request){
		request.getSession().removeAttribute("login_flag");
		request.getSession().removeAttribute("currentUserId");
		return "common/login";
	}

}
