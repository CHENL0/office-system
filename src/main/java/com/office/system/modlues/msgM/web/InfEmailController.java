package com.office.system.modlues.msgM.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.office.system.modlues.msgM.entity.InfEmail;
import com.office.system.modlues.msgM.service.InfEmailSeivice;
import com.office.system.modlues.sysMsgM.entity.SysOUser;
import com.office.system.modlues.sysMsgM.service.SysOUserService;

/**
 * 
 * 邮件管理
 */

@Controller
@RequestMapping("/a/infEmail")
public class InfEmailController {
	
	@Autowired
	InfEmailSeivice infEmailSeivice;
	
	@Autowired
	SysOUserService sysOUserService;
	
	@RequestMapping("/list.do")
	public String list(InfEmail infEmail,Model model){
		List<InfEmail> infEmails = infEmailSeivice.findList(infEmail);
		model.addAttribute("infEmails", infEmails);
		return "moudlues/msgM/msgM_InfEmailList";
	}
	//暂时没需求
	/*@RequestMapping("/update.do")
	public String update(InfEmail infEmail,Model model){
		infEmailSeivice.update(infEmail);
		return null;
	}*/
	
	
	@RequestMapping("/del.do")
	@ResponseBody
	public String del(InfEmail infEmail,Model model){
		infEmailSeivice.delete(infEmail);
		return "删除成功";
	}
	
	@RequestMapping("/save.do")
	public String save(InfEmail infEmail,Model model){
		
		if (infEmail !=null && infEmail.getDelFlag().equals("0")) {
			infEmailSeivice.save(infEmail);
			String msg = "添加成功!";
			model.addAttribute("msg", msg);
//			return "redirect:"+"/a/infEmail/list.do";
		}
		List<SysOUser> sysOUsers = sysOUserService.findList(new SysOUser());
		model.addAttribute("sysOUsers", sysOUsers);
		return "moudlues/msgM/msgM_InfEmailSend";
	}
	
	@RequestMapping("/show.do")
	public String get(InfEmail infEmail,Model model){
		InfEmail infEmail2 = infEmailSeivice.get(infEmail);
		model.addAttribute("infEmail", infEmail2);
		return "moudlues/msgM/msgM_InfEmailShow";
	}
	
	

}
