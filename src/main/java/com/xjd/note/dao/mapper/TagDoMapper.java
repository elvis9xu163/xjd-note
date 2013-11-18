package com.xjd.note.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xjd.note.dao.model.TagDo;
import com.xjd.note.dao.model.TagDoExample;

public interface TagDoMapper {
    int countByExample(TagDoExample example);

    int deleteByExample(TagDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TagDo record);

    int insertSelective(TagDo record);

    List<TagDo> selectByExample(TagDoExample example);

    TagDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TagDo record, @Param("example") TagDoExample example);

    int updateByExample(@Param("record") TagDo record, @Param("example") TagDoExample example);

    int updateByPrimaryKeySelective(TagDo record);

    int updateByPrimaryKey(TagDo record);
}