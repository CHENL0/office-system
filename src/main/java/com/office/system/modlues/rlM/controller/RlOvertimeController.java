package com.office.system.modlues.rlM.controller;

import com.office.system.modlues.rlM.entity.RlOvertime;
import com.office.system.modlues.rlM.service.RlOvertimeService;
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
 * @createTime 2019117 14:35
 * @description the controller of RlOvertime
 */
@Controller
@RequestMapping(value = "/RlOvertime")
public class RlOvertimeController {

    @Autowired
    private RlOvertimeService rlOvertimeService;
    @Autowired
    private SysOUserService sysOUserService;

    /**
     * @Description //TODO get list of one user by  he's id for showing all data;
     * @Author Chen
     * @DateTime 2019/1/24
     * @Param
     * @Return
     */
    @RequestMapping(value = "/overtimePage.do")
    public Object toOvertimePage(Model model, String currentUserId, String currentUserRole) {
        if(currentUserRole.equals("经理")){
            List<RlOvertime> rlOvertimeList = rlOvertimeService.findList(new RlOvertime());
            model.addAttribute("rlOvertimeList", rlOvertimeList);
        }else {
            List<RlOvertime> rlOvertimeList = rlOvertimeService.selectAllByCreateBy(currentUserId);
            model.addAttribute("rlOvertimeList", rlOvertimeList);
        }
        return "moudlues/rlM/rlOvertime_list";
    }

    /**
     * @Description //TODO to get one data by overtimeId for showing detail
     * @Author Chen
     * @DateTime 2019/1/24
     * @Param
     * @Return
     */
    @RequestMapping(value = "/showLeave.do")
    public Object showLeave(Model model, String overtimeId) {
        RlOvertime rlOvertime = rlOvertimeService.selectByPrimaryKey(overtimeId);
        model.addAttribute("rlOvertime", rlOvertime);
        return "moudlues/rlM/rlOvertime_show";
    }

    /**
     * @Description  //TODO 
     * @Author Chen
     * @DateTime 2019/1/25
     * @Param 
     * @Return 
     */
    @RequestMapping(value = "/submitOvertime.do")
    public Object submitLeave(Model model,RlOvertime rlOvertime) {
        if(rlOvertime != null && rlOvertime.getDelFlag().equals("0")){
            rlOvertimeService.save(rlOvertime);
            String msg = "提交成功!";
            model.addAttribute("msg", msg);
        }
        List<SysOUser> sysOUserList = sysOUserService.findList(new SysOUser());
        model.addAttribute("sysOUserList",sysOUserList);
        return "moudlues/rlM/rlOvertime_commit";
    }

    @RequestMapping(value = "/delOvertime.do")
    @ResponseBody
    public Object deleteOvertime (String id){
        rlOvertimeService.updateDelFlagById(id);
        Map<String, String> responseDataMap = new HashMap<>();
        responseDataMap.put("responseData","success");
        return responseDataMap;
    }

    @RequestMapping(value = "/updateOvertimeStatus.do")
    public Object updateLeaveStatus (Model model,String overtimeId,int overtimeStatus){
        if(overtimeStatus != 0 && overtimeId !=null){
            rlOvertimeService.updateStatusById(overtimeId,overtimeStatus);
            String msg = "提交成功!";
            model.addAttribute("msg", msg);
        }
        return "moudlues/rlM/rlOvertime_update";
    }

}
