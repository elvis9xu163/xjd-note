package com.xjd.note.dao.mapper.custom;

import com.xjd.note.dao.model.IdMngrDo;

/**
 * <pre>
 * TODO
 * </pre>
 * 
 * @author elvis.xu
 * @since 2014-1-5 下午10:48:48
 */
public interface CustomIdMngrDoMapper {

    IdMngrDo selectByName(String name);
}
