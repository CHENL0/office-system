package com.office.system.modlues.rlM.controller;

import com.office.system.modlues.rlM.entity.RlLeave;
import com.office.system.modlues.rlM.service.RlLeaveService;
import com.office.system.modlues.sysMsgM.entity.SysOUser;
import com.office.system.modlues.sysMsgM.service.SysOUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Chen
 * @createTime 2019117 14:34
 * @description the controller of RlLeave
 */
@Controller
@RequestMapping("/RlLeave")
public class RlLeaveController {
    @Autowired
    private RlLeaveService rlLeaveService;
    @Autowired
    private SysOUserService sysOUserService;

    /**
     * @Description //TODO to RlLeave.html
     * @Author Chen
     * @DateTime 2019/1/17
     * @Param
     * @Return
     */
    @RequestMapping(value = "/leavePage.do")
    public Object toLeavePage(Model model, String currentUserId,String currentUserRole) {
        if(currentUserRole.equals("经理")){
            List<RlLeave> rlLeaveList = rlLeaveService.findList(new RlLeave());
            model.addAttribute("rlLeaveList", rlLeaveList);
        }else {
            List<RlLeave> rlLeaveList = rlLeaveService.selectAllByCreateBy(currentUserId);
            model.addAttribute("rlLeaveList", rlLeaveList);
        }
        return "moudlues/rlM/rlLeave_list";
    }

    /**
     * @Description //TODO show detail of leave
     * @Author Chen
     * @DateTime 2019/1/24
     * @Param
     * @Return
     */
    @RequestMapping(value = "/showLeave.do")
    public Object showLeave(Model model, String leaveId){
        RlLeave rlLeave = rlLeaveService.selectByPrimaryKey(leaveId);
        model.addAttribute("rlLeave",rlLeave);
        return "moudlues/rlM/rlLeave_show";
    }

    /**
     * @Description  //TODO submit the leave's data
     * @Author Chen
     * @DateTime 2019/1/25
     * @Param 
     * @Return 
     */
    @RequestMapping(value = "/submitLeave.do")
    public Object submitLeave(Model model,RlLeave rlLeave) {
        if(rlLeave != null && rlLeave.getDelFlag().equals("0")){
             rlLeaveService.save(rlLeave);
            String msg = "提交成功!";
            model.addAttribute("msg", msg);
        }
        List<SysOUser> sysOUserList = sysOUserService.findList(new SysOUser());
        model.addAttribute("sysOUserList",sysOUserList);
        return "moudlues/rlM/rlLeave_commit";
    }


    @RequestMapping(value = "/delLeave.do")
    public @ResponseBody
    Object delLeave (String id){
        rlLeaveService.updateDelFlagById(id);
        Map<String, String> responseDataMap = new HashMap<>();
        responseDataMap.put("responseData","success");
        return responseDataMap;
    }


    @RequestMapping(value = "/updateLeaveStatus.do")
    public Object updateLeaveStatus (Model model,String leaveId,int leaveStatus){
        if(leaveStatus != 0 && leaveId !=null){
            rlLeaveService.updateStatusById(leaveId,leaveStatus);
            String msg = "提交成功!";
            model.addAttribute("msg", msg);
        }
        return "moudlues/rlM/rlLeave_update";
    }

}
