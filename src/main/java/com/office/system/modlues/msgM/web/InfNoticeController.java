package com.office.system.modlues.msgM.web;

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
import com.office.system.modlues.sysMsgM.entity.SysOUser;

@Controller
@RequestMapping("/a/infNotice")
public class InfNoticeController {
	
	@Autowired
	InfNoticeSeivice infNoticeSeivice;
	
	@Autowired
	InfNoticeTypeService infNoticeTypeService;
	
	@RequestMapping("/save.do")
	public String save(Model model,InfNotice infNotice){
		
		if (infNotice !=null && infNotice.getDelFlag().equals("0")) {
			infNoticeSeivice.save(infNotice);
			String msg = "添加成功!";
			model.addAttribute("msg", msg);
//			return "redirect:"+"/a/infNotice/list.do";
		}
		List<InfNoticeType> infNoticeTypes = infNoticeTypeService.findList(new InfNoticeType());
		model.addAttribute("infNoticeTypes", infNoticeTypes);
		return "moudlues/msgM/msgM_InfNoticePush";
		
	}
	
	@RequestMapping("/del.do")
	@ResponseBody
	public String del(Model model,InfNotice infNotice){
		infNoticeSeivice.delete(infNotice);
		return "删除成功";
		
	}
	
	@RequestMapping("/list.do")
	public String list(Model model,InfNotice infNotice){
		List<InfNotice> infNotices = infNoticeSeivice.findList(infNotice);
		model.addAttribute("infNotices", infNotices);
		return "moudlues/msgM/msgM_InfNoticeList";
		
	}
	//公告查看
	@RequestMapping("/listShow.do")
	public String listShow(Model model,InfNotice infNotice){
		List<InfNotice> infNotices = infNoticeSeivice.findList(infNotice);
		model.addAttribute("infNotices", infNotices);
		return "moudlues/msgM/msgM_InfNoticeListShow";
		
	}
	@RequestMapping("/update.do")
	public String update(Model model,InfNotice infNotice){
		if (infNotice !=null && infNotice.getDelFlag().equals("0")) {
			infNoticeSeivice.save(infNotice);
			return "redirect:"+"/a/infNotice/list.do";
		}
		List<InfNoticeType> infNoticeTypes = infNoticeTypeService.findList(new InfNoticeType());
		model.addAttribute("infNoticeTypes", infNoticeTypes);
		return "moudlues/msgM/msgM_InfNoticePush";
		
	}
	//查看一个公告
	@RequestMapping("/show.do")
	public String show(Model model,InfNotice infNotice){
		InfNotice infNotice1 = infNoticeSeivice.get(infNotice);
		model.addAttribute("infNotice", infNotice1);
		return "moudlues/msgM/msgM_InfNoticeShow";
		
	}

}
