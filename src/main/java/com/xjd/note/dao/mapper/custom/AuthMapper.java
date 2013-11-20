package com.xjd.note.dao.mapper.custom;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xjd.note.dao.model.AuthorityDo;

/**
 * <pre>
 * 权限自定义Mapper
 * </pre>
 * @author elvis.xu
 * @since 2013-11-19
 */
public interface AuthMapper {
	
	/**
	 * <pre>
	 * 查询用户的权限
	 * </pre>
	 * @param userId
	 * @param authType see {@link com.xjd.note.util.AuthTypeEnum#getCode() AuthTypeEnum.getCode()}
	 * @return
	 * @author elvis.xu
	 * @since 2013-11-19
	 */
	List<AuthorityDo> queryAuthoritiesForUser(@Param("userId") long userId, @Param("authType") String authType);
	
	/**
	 * <pre>
	 * 查询权限组所包含的权限
	 * 注意子权限组
	 * </pre>
	 * @param groupId
	 * @param authType see {@link com.xjd.note.util.AuthTypeEnum#getCode() AuthTypeEnum.getCode()}
	 * @return
	 * @author elvis.xu
	 * @since 2013-11-19
	 */
	List<AuthorityDo> queryAuthoritiesForAuthGroup(@Param("groupId") long groupId, @Param("authType") String authType);
	
}
