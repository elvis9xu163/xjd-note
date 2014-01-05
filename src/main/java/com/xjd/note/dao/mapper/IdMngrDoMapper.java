package com.xjd.note.dao.mapper;

import com.xjd.note.dao.model.IdMngrDo;
import com.xjd.note.dao.model.IdMngrDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IdMngrDoMapper {
    int countByExample(IdMngrDoExample example);

    int deleteByExample(IdMngrDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(IdMngrDo record);

    int insertSelective(IdMngrDo record);

    List<IdMngrDo> selectByExample(IdMngrDoExample example);

    IdMngrDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") IdMngrDo record, @Param("example") IdMngrDoExample example);

    int updateByExample(@Param("record") IdMngrDo record, @Param("example") IdMngrDoExample example);

    int updateByPrimaryKeySelective(IdMngrDo record);

    int updateByPrimaryKey(IdMngrDo record);
}