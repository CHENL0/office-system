package com.office.system.modlues.wkM.controller;

import com.office.system.modlues.sysMsgM.entity.SysODepartment;
import com.office.system.modlues.sysMsgM.service.SysODepartmentService;
import com.office.system.modlues.wkM.entity.WkWorkTarget;
import com.office.system.modlues.wkM.service.WkWorkTargetServcie;
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
 * @createTime 28 11:18
 * @description
 */
@Controller
@RequestMapping(value = "/WkWorkTarget")
public class WkWorkTargetController {

    @Autowired
    private WkWorkTargetServcie wkWorkTargetServcie;
    @Autowired
    private SysODepartmentService sysODepartmentService;

    @RequestMapping(value = "/wkWorkTargetPage.do")
    public Object toLeavePage(Model model ,WkWorkTarget wkWorkTarget) {
        List<WkWorkTarget> wkWorkTargetList = wkWorkTargetServcie.findList(wkWorkTarget);
        model.addAttribute("wkWorkTargetList", wkWorkTargetList);
        return "moudlues/wkM/wkWorkTarget_list";
    }

    /**
     * @Description  //TODO
     * @Author Chen
     * @DateTime 2019/1/25
     * @Param
     * @Return
     */
    @RequestMapping(value = "/showWkWorkTarget.do")
    public Object showRuleMessage (Model model,String wkWorkTargetId){
        WkWorkTarget wkWorkTarget = wkWorkTargetServcie.selectByPrimaryKey(wkWorkTargetId);
        model.addAttribute("wkWorkTarget",wkWorkTarget);
        return "moudlues/wkM/wkWorkTarget_show";
    }

    @RequestMapping(value = "/deleteWkWorkTarget.do")
    @ResponseBody
    public Object deleteWkWorkTarget (String id){
        wkWorkTargetServcie.updateDelFlagById(id);
        Map<String, String> responseDataMap = new HashMap<>();
        responseDataMap.put("responseData","success");
        return responseDataMap;
    }


    /**
     * @Description  //TODO
     * @Author Chen
     * @DateTime 2019/1/25
     * @Param
     * @Return
     */
    @RequestMapping(value = "/submitWkWorkTarget.do")
    public Object submitLeave(Model model,WkWorkTarget wkWorkTarget) {
        if(wkWorkTarget != null && wkWorkTarget.getDelFlag().equals("0")){
            wkWorkTargetServcie.save(wkWorkTarget);
            String msg = "提交成功!";
            model.addAttribute("msg", msg);
        }
        List<SysODepartment> sysODepartmentList = sysODepartmentService.findList(new SysODepartment());
        model.addAttribute("sysODepartmentList",sysODepartmentList);
        return "moudlues/wkM/wkWorkTarget_commit";
    }
}
