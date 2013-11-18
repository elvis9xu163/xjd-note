package com.xjd.note.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xjd.note.dao.model.NoteDo;
import com.xjd.note.dao.model.NoteDoExample;

public interface NoteDoMapper {
    int countByExample(NoteDoExample example);

    int deleteByExample(NoteDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(NoteDo record);

    int insertSelective(NoteDo record);

    List<NoteDo> selectByExample(NoteDoExample example);

    NoteDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") NoteDo record, @Param("example") NoteDoExample example);

    int updateByExample(@Param("record") NoteDo record, @Param("example") NoteDoExample example);

    int updateByPrimaryKeySelective(NoteDo record);

    int updateByPrimaryKey(NoteDo record);
}