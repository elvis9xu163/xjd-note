package com.xjd.note.biz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjd.note.biz.service.IdMngrService;
import com.xjd.note.dao.mapper.IdMngrDoMapper;
import com.xjd.note.dao.mapper.custom.CustomIdMngrDoMapper;
import com.xjd.note.dao.model.IdMngrDo;

/**
 * <pre>
 * TODO
 * </pre>
 * @author elvis.xu
 * @since 2014-1-5 下午10:45:19
 */
@Service
public class IdMngrServiceImpl implements IdMngrService {

    @Autowired
    IdMngrDoMapper idMngrDoMapper;
    
    @Autowired
    CustomIdMngrDoMapper customIdMngrDoMapper;
    
    @Override
    public Long generateId(String name) {
//	IdMngrDo idMngrDo = customIdMngrDoMapper.selectByName(name);
//	if (idMngrDo == null) {
//	    idMngrDo = new IdMngrDo();
//	}
	return null;
    }

}
