package com.office.system.modlues.wkM.controller;

import com.office.system.modlues.sysMsgM.entity.SysODepartment;
import com.office.system.modlues.sysMsgM.entity.SysOUser;
import com.office.system.modlues.sysMsgM.service.SysODepartmentService;
import com.office.system.modlues.sysMsgM.service.SysOUserService;
import com.office.system.modlues.wkM.entity.WkWorkReport;
import com.office.system.modlues.wkM.service.WkWorkReportService;
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
 * @createTime 2019128 11:03
 * @description
 */
@Controller
@RequestMapping(value = "/WkWorkReport")
public class WkWorkReportController {
    @Autowired
    private WkWorkReportService wkWorkReportService;
    @Autowired
    private SysOUserService sysOUserService;
    @Autowired
    private SysODepartmentService sysODepartmentService;

    /**
     * @Description //TODO get list of one user by  he's id for showing all data;
     * @Author Chen
     * @DateTime 2019/1/24
     * @Param
     * @Return
     */
    @RequestMapping(value = "/wkWorkReportPage.do")
    public Object toWkWorkReportPage(Model model, WkWorkReport wkWorkReport) {
        List<WkWorkReport> wkWorkReportList = wkWorkReportService.selectAllByCreateBy(wkWorkReport);
        model.addAttribute("wkWorkReportList", wkWorkReportList);
        return "moudlues/wkM/wkWorkReport_list";
    }

    @RequestMapping(value = "/auditWkWorkReportPage.do")
    public Object toAuditWkWorkReportPage(Model model, WkWorkReport wkWorkReport){
        List<WkWorkReport> wkWorkReportList = wkWorkReportService.selectAllByAuditUserId(wkWorkReport);
        model.addAttribute("wkWorkReportList", wkWorkReportList);
        return "moudlues/wkM/wkWorkReport_list_audit";
    }


    @RequestMapping(value = "/deleteWkWorkTargetForUser.do")
    @ResponseBody
    public Object deleteWkWorkTargetForUser (String id){
        wkWorkReportService.updateDelFlagByIdForUser(id);
        Map<String, String> responseDataMap = new HashMap<>();
        responseDataMap.put("responseData","success");
        return responseDataMap;
    }

    @RequestMapping(value = "/deleteWkWorkTargetForAudit.do")
    @ResponseBody
    public Object deleteWkWorkTargetForAudit (String id){
        wkWorkReportService.updateDelFlagByIdForAudit(id);
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
    @RequestMapping(value = "/showWkWorkReport.do")
    public Object showRuleMessage (Model model,String wkWorkReportId){
        WkWorkReport wkWorkReport = wkWorkReportService.selectByPrimaryKey(wkWorkReportId);
        model.addAttribute("wkWorkReport",wkWorkReport);
        return "moudlues/wkM/wkWorkReport_show";
    }

    /**
     * @Description  //TODO
     * @Author Chen
     * @DateTime 2019/1/25
     * @Param
     * @Return
     */
    @RequestMapping(value = "/submitWkWorkReport.do")
    public Object submitLeave(Model model,WkWorkReport wkWorkReport) {
        if(wkWorkReport != null && wkWorkReport.getDelFlag().equals("0")){
            wkWorkReportService.save(wkWorkReport);
            String msg = "提交成功!";
            model.addAttribute("msg", msg);
        }
        List<SysODepartment> sysODepartmentList = sysODepartmentService.findList(new SysODepartment());
        model.addAttribute("sysODepartmentList",sysODepartmentList);
        List<SysOUser> sysOUserList = sysOUserService.findList(new SysOUser());
        model.addAttribute("sysOUserList",sysOUserList);
        return "moudlues/wkM/wkWorkReport_commit";
    }
}
