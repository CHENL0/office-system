package com.office.system.modlues.sysMsgM.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.office.system.modlues.msgM.entity.InfNotice;
import com.office.system.modlues.msgM.entity.InfNoticeType;
import com.office.system.modlues.msgM.service.InfNoticeSeivice;
import com.office.system.modlues.msgM.service.InfNoticeTypeService;
import com.office.system.modlues.sysMsgM.entity.SysORole;
import com.office.system.modlues.sysMsgM.entity.SysOUser;
import com.office.system.modlues.sysMsgM.service.SysORoleService;

@Controller
@RequestMapping("/a/sysORole")
public class SysORoleController {
	
	@Autowired
	SysORoleService sysORoleService;
	
	@RequestMapping("/save.do")
	public String save(Model model,SysORole sysORole){
		
		if (sysORole !=null && sysORole.getDelFlag().equals("0")) {
			sysORoleService.save(sysORole);
			return "redirect:"+"/a/sysORole/list.do";
		}
		return "moudlues/sysMsgM/sysMsgM_SysORoleAdd";
	}
	
	@RequestMapping("/del.do")
	@ResponseBody
	public String del(Model model,SysORole sysORole){
		sysORoleService.delete(sysORole);
		return null;
		
	}
	
	@RequestMapping("/list.do")
	public String list(Model model,SysORole sysORole){
		List<SysORole> sysORoles = sysORoleService.findList(sysORole);
		model.addAttribute("sysORoles", sysORoles);
		return "moudlues/sysMsgM/sysMsgM_SysORoleList";
		
	}
	
	@RequestMapping("/update.do")
	public String update(Model model,SysORole sysORole){
		
		if (sysORole !=null && sysORole.getDelFlag().equals("0")) {
			sysORoleService.update(sysORole);
			return "redirect:"+"/a/sysORole/list.do";
		}
		return "moudlues/sysMsgM/sysMsgM_SysORoleUpdate";
		
	}
	//暂时没有需求
	@RequestMapping("/show.do")
	public String show(Model model,SysORole sysORole){
		
		return null;
		
	}

}
