package com.office.system.modlues.sysMsgM.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.office.system.modlues.sysMsgM.entity.SysODepartment;
import com.office.system.modlues.sysMsgM.entity.SysORole;
import com.office.system.modlues.sysMsgM.entity.SysOUser;
import com.office.system.modlues.sysMsgM.service.SysODepartmentService;
import com.office.system.modlues.sysMsgM.service.SysORoleService;
import com.office.system.modlues.sysMsgM.service.SysOUserService;

/**
 * 涓汉淇℃伅鍜岀敤鎴风殑鎵�鏈変俊鎭ā鍧�
 * @author lzc
 *
 */
@Controller
@RequestMapping("/a/sysUser")
public class SysOUserController {
	
    @Autowired
	SysOUserService sysOUserService;
    
    @Autowired
    SysODepartmentService sysODepartmentService;
    
    @Autowired
    SysORoleService sysORoleService;
    
    
    //淇濆瓨
	@RequestMapping(value="/save.do",method=RequestMethod.POST)
	public String save(Model model,SysOUser sysOUser,HttpSession session) throws IllegalStateException, IOException{
		
		if (sysOUser !=null && sysOUser.getDelFlag().equals("0")) {
			String passwordMD5 =DigestUtils.md5Hex(sysOUser.getPassword());
			sysOUser.setPassword(passwordMD5);
//			sysOUserService.save(sysOUser,Mphoto,session);
			sysOUserService.save(sysOUser);
			String msg = "娣诲姞鎴愬姛!";
			model.addAttribute("msg", msg);
		}
		return "moudlues/sysMsgM/sysMsgM_SysOUserAdd";
	}
	@RequestMapping(value="/save.do",method=RequestMethod.GET)
	public String save2(Model model,SysOUser sysOUser){
		List<SysODepartment> sysODepartments = sysODepartmentService.findList(new SysODepartment());
		model.addAttribute("sysODepartments", sysODepartments);
		List<SysORole> sysORoles = sysORoleService.findList(new SysORole());
		model.addAttribute("sysORoles", sysORoles);
		return "moudlues/sysMsgM/sysMsgM_SysOUserAdd";
	}
	//鍒楄〃涓婄敤鎴风殑淇℃伅锛宲ost璇锋眰鐨勬洿鏂帮紝瑕佸仛鏇存柊
	@RequestMapping(value="/update.do",method=RequestMethod.POST)
	public String updateForPost(Model model,SysOUser sysOUser,String newPassword){
//		String passwordMD5 =DigestUtils.md5Hex(newPassword);
//		sysOUser.setPassword(passwordMD5);
		sysOUserService.update(sysOUser);
		SysOUser sysOUser2 = sysOUserService.get(sysOUser);
		model.addAttribute("sysOUser", sysOUser2);
		String msg = "淇敼鎴愬姛!";
		model.addAttribute("msg", msg);
		return "moudlues/sysMsgM/sysMsgM_SysOUserUpdate";
	}
	//get璇锋眰鐨勬洿鏂帮紝涓嶅仛鏇存柊锛屽彧璐熻矗璺宠浆椤甸潰
	@RequestMapping(value="/update.do",method=RequestMethod.GET)
	public String updateForGet(Model model,SysOUser sysOUser,String current_user_Id){
		SysOUser sysOUser2 = sysOUserService.get(sysOUser);

		SysOUser currentUser = sysOUserService.get(current_user_Id);
		model.addAttribute("sysOUser", sysOUser2);
		model.addAttribute("currentUser", currentUser);
		List<SysODepartment> sysODepartments = sysODepartmentService.findList(new SysODepartment());
		model.addAttribute("sysODepartments", sysODepartments);
		List<SysORole> sysORoles = sysORoleService.findList(new SysORole());
		model.addAttribute("sysORoles", sysORoles);
		return "moudlues/sysMsgM/sysMsgM_SysOUserUpdate";
	}
/*	//淇敼褰撳墠鐢ㄦ埛淇℃伅
	@RequestMapping(value="/updateCurrentUser.do",method=RequestMethod.POST)
	public String updateForPostCurrentUser(Model model,SysOUser sysOUser){
		sysOUserService.update(sysOUser);
		model.addAttribute("sysOUser", sysOUser);
		String msg = "淇敼鎴愬姛!";
		model.addAttribute("msg", msg);
		return "moudlues/sysMsgM/sysMsgM_SysOUserUpdate";
	}*/
	//post鏇存柊瀵嗙爜
	@RequestMapping(value="/updatePassword.do",method=RequestMethod.POST)
	public String updatePasswordForPost(Model model,SysOUser sysOUser){
		String passwordMD5 =DigestUtils.md5Hex(sysOUser.getPassword());
		sysOUser.setPassword(passwordMD5);
		sysOUserService.updatePasswordById(sysOUser);
		String msg = "淇敼瀵嗙爜鎴愬姛!";
		model.addAttribute("msg", msg);
		return "common/index";
	}
	//get鏇存柊瀵嗙爜
	@RequestMapping(value="/updatePassword.do",method=RequestMethod.GET)
	public String updatePasswordForGet(Model model,SysOUser sysOUser){
		SysOUser sysOUser2 = sysOUserService.get(sysOUser);
		model.addAttribute("sysOUser", sysOUser2);
		return "moudlues/sysMsgM/sysMsgM_SysOUserUpdatePassword";
	}
	//閫昏緫涓婂垹闄�
	@RequestMapping("/del.do")
	@ResponseBody
	public Object del(Model model,SysOUser sysOUser){
		sysOUserService.delete(sysOUser);
	    Map<String, String> responseDataMap = new HashMap<>();
	    responseDataMap.put("responseData","success");
	    return responseDataMap;
	}
	//鏌ヨ涓汉淇℃伅
	@RequestMapping("/show.do")
	public String from(Model model,SysOUser sysOUser){
		SysOUser sysOUser2 = sysOUserService.get(sysOUser);
		model.addAttribute("sysOUser", sysOUser2);
		return "moudlues/sysMsgM/sysMsgM_SysOUserShow";
	}
	//灞曠ず鎵�鏈夌敤鎴峰拰鍒嗛〉鏌ヨ鐢ㄦ埛锛堝墠鍙板凡鍋氬ソ鍒嗛〉锛�
	@RequestMapping("/list.do")
	public String list(Model model,SysOUser sysOUser){
		List<SysOUser> sysOUsers = sysOUserService.findList(sysOUser);
		model.addAttribute("sysOUserList", sysOUsers);
		return "moudlues/sysMsgM/sysMsgM_SysOUserList";
	}
	//灞曠ず鎵�鏈夌敤鎴峰拰鍒嗛〉鏌ヨ鐢ㄦ埛锛堝墠鍙板凡鍋氬ソ鍒嗛〉锛� 涓轰簡缁檋r閲嶇疆瀵嗙爜
	@RequestMapping("/listForHr.do")
	public String listForHr(Model model,SysOUser sysOUser){
		List<SysOUser> sysOUsers = sysOUserService.findList(sysOUser);
		model.addAttribute("sysOUserList", sysOUsers);
		return "moudlues/sysMsgM/sysMsgM_SysOUserListForHr";
	}

}
