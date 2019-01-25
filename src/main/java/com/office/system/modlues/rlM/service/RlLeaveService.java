package com.office.system.modlues.rlM.service;

import com.office.system.common.baseService.CrudService;
import com.office.system.modlues.rlM.dao.RlLeaveDao;
import com.office.system.modlues.rlM.entity.RlLeave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Chen
 * @createTime 2019117 14:39
 * @description the service of RlLeave
 */
@Service
public class RlLeaveService extends CrudService<RlLeaveDao, RlLeave> {
    @Resource
    private RlLeaveDao rlLeaveDao;
    public List<RlLeave> selectAllByCreateBy(String createBy){
        return rlLeaveDao.selectAllByCreateBy(createBy);
    }
    public RlLeave selectByPrimaryKey(String id){
        return rlLeaveDao.selectByPrimaryKey(id);
    }

    public void updateDelFlagById(String id){
        rlLeaveDao.updateDelFlagById(id);
    }

    public void updateStatusById(String leaveId,int leaveStatus){
        rlLeaveDao.updateStatusById(leaveId,leaveStatus);
    }
}
