package com.office.system.modlues.msgM.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.office.system.common.baseService.CrudService;
import com.office.system.modlues.msgM.dao.InfEmailDao;
import com.office.system.modlues.msgM.entity.InfEmail;

@Service
@Transactional(readOnly = true)
public class InfEmailSeivice extends CrudService<InfEmailDao, InfEmail>{

}
