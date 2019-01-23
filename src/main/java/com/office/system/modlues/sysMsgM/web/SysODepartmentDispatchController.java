package com.office.system.modlues.sysMsgM.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.office.system.modlues.msgM.entity.InfNotice;
import com.office.system.modlues.msgM.entity.InfNoticeType;
import com.office.system.modlues.msgM.service.InfNoticeSeivice;
import com.office.system.modlues.msgM.service.InfNoticeTypeService;
import com.office.system.modlues.sysMsgM.entity.SysODepartment;
import com.office.system.modlues.sysMsgM.entity.SysODepartmentDispatch;
import com.office.system.modlues.sysMsgM.entity.SysORole;
import com.office.system.modlues.sysMsgM.entity.SysOUser;
import com.office.system.modlues.sysMsgM.service.SysODepartmentDispatchService;
import com.office.system.modlues.sysMsgM.service.SysODepartmentService;
import com.office.system.modlues.sysMsgM.service.SysORoleService;
import com.office.system.modlues.sysMsgM.service.SysOUserService;

@Controller
@RequestMapping("/a/sysODepartmentDispatch")
public class SysODepartmentDispatchController {
	
	@Autowired
	SysODepartmentDispatchService sysODepartmentDispatchService;
	
	@Autowired
	SysOUserService sysOUserService;
	
	@Autowired
	SysODepartmentService sysODepartmentService;
	
	@Autowired
	SysORoleService sysORoleService;
	
	//post请求的保存，要执行保存
	@RequestMapping(value="/save.do",method=RequestMethod.POST)
	public String saveForPost(Model model,SysOUser sysOUser,SysODepartmentDispatch sysODepartmentDispatch){
		if(sysODepartmentDispatch != null ){
			sysODepartmentDispatchService.save(sysODepartmentDispatch);
			String msg = "添加成功!";
			model.addAttribute("msg", msg);
		}
		return "moudlues/sysMsgM/sysMsgM_SysODepartmentDispatchAdd";
	}
	//post请求的保存，不要执行保存，只负责跳转页面
	@RequestMapping(value="/save.do",method=RequestMethod.GET)
	public String saveForGet(Model model,SysOUser sysOUser,SysODepartmentDispatch sysODepartmentDispatch){
			SysOUser sysOUser2 = sysOUserService.get(sysOUser);
			List<SysODepartment> sysODepartments = sysODepartmentService.findList(new SysODepartment());
			List<SysORole> sysORoles = sysORoleService.findList(new SysORole());
			model.addAttribute("sysOUser", sysOUser2);
			model.addAttribute("sysODepartments", sysODepartments);
			model.addAttribute("sysORoles", sysORoles);
			return "moudlues/sysMsgM/sysMsgM_SysODepartmentDispatchAdd";
		}
	//删除	
	@RequestMapping("/del.do")
	@ResponseBody
	public String del(Model model,SysODepartmentDispatch sysODepartmentDispatch){
		sysODepartmentDispatchService.delete(sysODepartmentDispatch);
		return "删除成功";
		
	}
	//展示数据（前端已分好页）
	@RequestMapping("/list.do")
	public String list(Model model,SysODepartmentDispatch sysODepartmentDispatch){
	    List<SysODepartmentDispatch> sysODepartmentDispatchs = sysODepartmentDispatchService.findList(sysODepartmentDispatch);
	    model.addAttribute("sysODepartmentDispatchs", sysODepartmentDispatchs);
		return "moudlues/sysMsgM/sysMsgM_SysODepartmentDispatchList";
		
	}
	//暂时没有需求
	@RequestMapping("/update.do")
	public String update(Model model,SysODepartmentDispatch sysODepartmentDispatch){
		
		return null;
		
	}
	//查看调数据的页面
	@RequestMapping("/show.do")
	public String show(Model model,SysODepartmentDispatch sysODepartmentDispatch){
	    SysODepartmentDispatch sysODepartmentDispatch2 = sysODepartmentDispatchService.get(sysODepartmentDispatch);
	    model.addAttribute("sysODepartmentDispatch", sysODepartmentDispatch2);
		return "moudlues/syssysMsgM/sysMsgM_SysODepartmentDispatchShow";
		
	}

}
