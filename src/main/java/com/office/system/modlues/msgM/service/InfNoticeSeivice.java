package com.office.system.modlues.msgM.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.office.system.common.baseService.CrudService;
import com.office.system.modlues.msgM.dao.InfNoticeDao;
import com.office.system.modlues.msgM.entity.InfNotice;

@Service
@Transactional(readOnly = true)
public class InfNoticeSeivice extends CrudService<InfNoticeDao, InfNotice>{

}
