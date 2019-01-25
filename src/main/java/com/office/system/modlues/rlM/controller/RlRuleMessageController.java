package com.office.system.modlues.rlM.controller;

import com.office.system.modlues.rlM.entity.RlRuleMessage;
import com.office.system.modlues.rlM.service.RlRuleMessageService;
import com.office.system.modlues.sysMsgM.entity.SysOUser;
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
 * @createTime 2019117 14:36
 * @description the controller of RlRuleMessage
 */
@Controller
@RequestMapping(value = "/RlRuleMessage")
public class RlRuleMessageController {

    @Autowired
    private RlRuleMessageService rlRuleMessageService;

        /**
         * @Description  //TODO 
         * @Author Chen
         * @DateTime 2019/1/25
         * @Param 
         * @Return 
         */
    @RequestMapping(value = "/ruleMessagePage.do")
    public Object toRuleMessage (Model model,RlRuleMessage rlRuleMessage){
        List<RlRuleMessage> rlRuleMessageList = rlRuleMessageService.findList(rlRuleMessage);
        model.addAttribute("rlRuleMessageList",rlRuleMessageList);
        return "moudlues/rlM/rlRuleMessage_list";
    }

    /**
     * @Description  //TODO
     * @Author Chen
     * @DateTime 2019/1/25
     * @Param
     * @Return
     */
    @RequestMapping(value = "/showRuleMessage.do")
    public Object showRuleMessage (Model model,String ruleId){
        RlRuleMessage rlRuleMessage = rlRuleMessageService.selectByPrimaryKey(ruleId);
        model.addAttribute("rlRuleMessage",rlRuleMessage);
        return "moudlues/rlM/rlRuleMessage_show";
    }

    @RequestMapping(value = "/delRuleMessage.do")
    @ResponseBody
    public Object deleteOvertime (String id){
        rlRuleMessageService.updateDelFlagById(id);
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
    @RequestMapping(value = "/submitRule.do")
    public Object submitLeave(Model model,RlRuleMessage rlRuleMessage) {
        if(rlRuleMessage != null && rlRuleMessage.getDelFlag().equals("0")){
            rlRuleMessageService.save(rlRuleMessage);
            String msg = "提交成功!";
            model.addAttribute("msg", msg);
        }
        return "moudlues/rlM/rlRuleMessage_commit";
    }
}
