package com.office.system.modlues.rlM.service;

import com.office.system.common.baseService.CrudService;
import com.office.system.modlues.rlM.dao.RlOvertimeDao;
import com.office.system.modlues.rlM.entity.RlOvertime;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Chen
 * @createTime 2019117 14:40
 * @description the service of RlOvertime
 */
@Service
public class RlOvertimeService extends CrudService<RlOvertimeDao, RlOvertime> {

    @Resource
    private RlOvertimeDao rlOvertimeDao;

    /**
     * @Description //TODO get all list by createBy(userId) for getting list
     * @Author Chen
     * @DateTime 2019/1/24
     * @Param
     * @Return
     */
//    public List<RlOvertime> rlOvertimeList(String createBy) {
//        return rlOvertimeDao.selectAllByCreateBy(createBy);
//    }

    /**
     * @Description //TODO get one data by overtimeId(id)
     * @Author Chen
     * @DateTime 2019/1/24
     * @Param
     * @Return
     */
    public RlOvertime selectByPrimaryKey(String overtimeId) {
        return rlOvertimeDao.selectByPrimaryKey(overtimeId);
    }

    public void updateDelFlagByIdForUser (String id){
        rlOvertimeDao.updateDelFlagByIdForUser(id);
    }

    public void updateDelFlagByIdForAudit (String id){
        rlOvertimeDao.updateDelFlagByIdForAudit(id);
    }

    public void updateStatusById (String overtimeId,int overtimeStatus){
        rlOvertimeDao.updateStatusById(overtimeId,overtimeStatus);
    }
    public List<RlOvertime> selectAllByCreateBy (RlOvertime rlOvertime){
        return rlOvertimeDao.selectAllByCreateBy(rlOvertime);
    }
    public List<RlOvertime> selectAll (){
        return rlOvertimeDao.selectAll();
    }
    public List<RlOvertime> selectAllByAudit (RlOvertime rlOvertime){
        return rlOvertimeDao.selectAllByAudit(rlOvertime);
    }
}
