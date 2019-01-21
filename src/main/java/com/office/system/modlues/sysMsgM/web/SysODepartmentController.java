package com.office.system.modlues.sysMsgM.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.office.system.modlues.msgM.entity.InfNotice;
import com.office.system.modlues.msgM.entity.InfNoticeType;
import com.office.system.modlues.msgM.service.InfNoticeSeivice;
import com.office.system.modlues.msgM.service.InfNoticeTypeService;
import com.office.system.modlues.sysMsgM.entity.SysODepartment;
import com.office.system.modlues.sysMsgM.entity.SysOUser;
import com.office.system.modlues.sysMsgM.service.SysODepartmentService;

@Controller
@RequestMapping("/a/sysODepartment")
public class SysODepartmentController {
	
	@Autowired
	SysODepartmentService sysODepartmentService;
	
	@RequestMapping("/save.do")
	public String save(Model model,SysODepartment sysODepartment){
		
		if (sysODepartment !=null && sysODepartment.getDelFlag().equals("0")) {
			sysODepartmentService.save(sysODepartment);
			return "redirect:"+"/a/sysODepartment/list.do";
		}
		return "moudlues/sysMsgM/sysMsgM_SysODepartmentAdd";
		
	}
	
	@RequestMapping("/del.do")
	public String del(Model model,SysODepartment sysODepartment){
		return null;
		
	}
	
	@RequestMapping("/list.do")
	public String list(Model model,SysODepartment sysODepartment){
		List<SysODepartment> sysODepartments = sysODepartmentService.findList(sysODepartment);
		model.addAttribute("sysODepartments", sysODepartments);
		return "moudlues/sysMsgM/sysMsgM_SysODepartmentList";
	}
	
	@RequestMapping("/update.do")
	public String update(Model model,SysODepartment sysODepartment){
		return null;
		
	}
	
	@RequestMapping("/show.do")
	public String show(Model model,SysODepartment sysODepartment){
	
		return null;
		
	}

}
