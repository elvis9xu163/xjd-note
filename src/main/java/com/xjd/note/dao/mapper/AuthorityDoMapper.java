package com.xjd.note.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xjd.note.dao.model.AuthorityDo;
import com.xjd.note.dao.model.AuthorityDoExample;

public interface AuthorityDoMapper {
    int countByExample(AuthorityDoExample example);

    int deleteByExample(AuthorityDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AuthorityDo record);

    int insertSelective(AuthorityDo record);

    List<AuthorityDo> selectByExample(AuthorityDoExample example);

    AuthorityDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AuthorityDo record, @Param("example") AuthorityDoExample example);

    int updateByExample(@Param("record") AuthorityDo record, @Param("example") AuthorityDoExample example);

    int updateByPrimaryKeySelective(AuthorityDo record);

    int updateByPrimaryKey(AuthorityDo record);
}