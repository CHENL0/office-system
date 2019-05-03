package com.office.system.common.baseWeb;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.office.system.common.baseService.IndexService;
import com.office.system.modlues.sysMsgM.entity.SysOUser;
import com.office.system.modlues.sysMsgM.service.SysOUserService;

import java.util.List;


/**
 * 访问主页
 * @author 
 *
 */
@Controller
@RequestMapping("/a")
public class IndexController {
	
	@Autowired
	SysOUserService sysOUserService;
	@Autowired
	IndexService indexService;
	
	@RequestMapping(value={"/getRightCharts.do"})
	@ResponseBody
	public List<List<String>> getRightCharts() {
		return indexService.getListGroupBtCreateTime();
	}
	
	@RequestMapping(value={"/index.do",""})
	public String index(HttpServletRequest request,Model model){
		String loginFlag = (String) request.getSession().getAttribute("login_flag");
		String currentUserId = (String) request.getSession().getAttribute("currentUserId");
		//判断seesion里面是否存在登录标志
		if (loginFlag !=null && loginFlag != "" && currentUserId != null && currentUserId !=""){
		  if(loginFlag.equals("true")){
			//向model添加内容
			  SysOUser currentUser = sysOUserService.get(new SysOUser(currentUserId));
			  model.addAttribute("currentUser",currentUser);
			  model.addAttribute("rightChartsData", indexService.getListGroupBtCreateTime());
			return "common/index";
		  }
		}
		return "common/login";
	}
	@RequestMapping(value={"/data.do"})
	public String getData(HttpServletRequest request,Model model){
		SysOUser hrInfo = sysOUserService.getHrInfo();
		List<SysOUser> managerInfoList = sysOUserService.getManagerInfoList();
		return "common/login";
	}

}
