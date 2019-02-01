package com.office.system.modlues.sysMsgM.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
			String msg = "添加成功!";
			model.addAttribute("msg", msg);
		}
		return "moudlues/sysMsgM/sysMsgM_SysODepartmentAdd";
		
	}
	
	@RequestMapping("/del.do")
	@ResponseBody
	public Object del(Model model,SysODepartment sysODepartment){
		sysODepartmentService.delete(sysODepartment);
		  Map<String, String> responseDataMap = new HashMap<>();
		  responseDataMap.put("responseData","success");
		  return responseDataMap;
		
	}
	
	@RequestMapping("/list.do")
	public String list(Model model,SysODepartment sysODepartment){
		List<SysODepartment> sysODepartments = sysODepartmentService.findList(sysODepartment);
		model.addAttribute("sysODepartments", sysODepartments);
		return "moudlues/sysMsgM/sysMsgM_SysODepartmentList";
	}
	
	@RequestMapping("/update.do")
	public String update(Model model,SysODepartment sysODepartment){
		if (sysODepartment !=null && sysODepartment.getDelFlag().equals("0")) {
			sysODepartmentService.update(sysODepartment);
			String msg = "修改成功!";
			model.addAttribute("msg", msg);
		}
		return "moudlues/sysMsgM/sysMsgM_SysODepartmentUpdate";
		
	}
	//信息太少，暂时没有需求
	@RequestMapping("/show.do")
	public String show(Model model,SysODepartment sysODepartment){
	
		return null;
		
	}

}
