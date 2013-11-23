package com.xjd.note.dao.mapper.custom;

import java.util.List;

import org.fest.assertions.api.Assertions;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.unitils.database.annotations.Transactional;
import org.unitils.database.util.TransactionMode;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.spring.annotation.SpringBeanByType;

import com.xjd.note.dao.AuthTypeEnum;
import com.xjd.note.dao.mapper.DaoBaseTest;
import com.xjd.note.dao.model.AuthorityDo;

@DataSet("AuthMapperTest.xml")
@Transactional(value=TransactionMode.ROLLBACK)
public class AuthMapperTest extends DaoBaseTest {
	private static Logger log = LoggerFactory.getLogger(AuthMapperTest.class);
	
	@SpringBeanByType
	AuthMapper authMapper;

	@Test
	public void testQueryAuthoritiesForUser() {
		{
			List<AuthorityDo> list = authMapper.queryAuthoritiesForUser(1L, AuthTypeEnum.ALL.getCode());
			log.info("{} for user: {}", AuthTypeEnum.ALL.getName(), list.size());
			Assertions.assertThat(list).hasSize(3);
		}
		{
			List<AuthorityDo> list = authMapper.queryAuthoritiesForUser(1L, AuthTypeEnum.ONLY_AUTHORITY.getCode());
			log.info("{} for user: {}", AuthTypeEnum.ONLY_AUTHORITY.getName(), list.size());
			Assertions.assertThat(list).hasSize(2);
		}
		{
			List<AuthorityDo> list = authMapper.queryAuthoritiesForUser(1L, AuthTypeEnum.ONLY_GROUP.getCode());
			log.info("{} for user: {}", AuthTypeEnum.ONLY_GROUP.getName(), list.size());
			Assertions.assertThat(list).hasSize(1);
		}
	}

	@Test
	public void testQueryAuthoritiesForAuthGroup() {
		{
			List<AuthorityDo> list = authMapper.queryAuthoritiesForAuthGroup(4L, AuthTypeEnum.ALL.getCode());
			log.info("{} for group: {}", AuthTypeEnum.ALL.getName(), list.size());
			Assertions.assertThat(list).hasSize(3);
		}
		{
			List<AuthorityDo> list = authMapper.queryAuthoritiesForAuthGroup(4L, AuthTypeEnum.ONLY_AUTHORITY.getCode());
			log.info("{} for group: {}", AuthTypeEnum.ONLY_AUTHORITY.getName(), list.size());
			Assertions.assertThat(list).hasSize(2);
		}
		{
			List<AuthorityDo> list = authMapper.queryAuthoritiesForAuthGroup(4L, AuthTypeEnum.ONLY_GROUP.getCode());
			log.info("{} for group: {}", AuthTypeEnum.ONLY_GROUP.getName(), list.size());
			Assertions.assertThat(list).hasSize(1);
		}
	}

}
