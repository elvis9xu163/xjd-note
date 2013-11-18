package com.xjd.note.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xjd.note.dao.model.UserDo;
import com.xjd.note.dao.model.UserDoExample;

public interface UserDoMapper {
    int countByExample(UserDoExample example);

    int deleteByExample(UserDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserDo record);

    int insertSelective(UserDo record);

    List<UserDo> selectByExample(UserDoExample example);

    UserDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserDo record, @Param("example") UserDoExample example);

    int updateByExample(@Param("record") UserDo record, @Param("example") UserDoExample example);

    int updateByPrimaryKeySelective(UserDo record);

    int updateByPrimaryKey(UserDo record);
}