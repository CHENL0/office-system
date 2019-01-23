package com.office.system.modlues.sysMsgM.web;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.office.system.modlues.sysMsgM.entity.SysODepartment;
import com.office.system.modlues.sysMsgM.entity.User;
import com.office.system.modlues.sysMsgM.service.SysODepartmentService;
import com.office.system.modlues.sysMsgM.service.UserService;


@Controller
public class UserController {
	
    @Autowired
	UserService userService;
	
    @Autowired
    SysODepartmentService sysODepartmentService;
    
	@RequestMapping("/test.do")
	public String test(Model model){
		User user = new User();
		user.setId("123");
		User user2 = userService.get(user);
		model.addAttribute("user", user2);
		return "common/NewFile";
		
	}

}
