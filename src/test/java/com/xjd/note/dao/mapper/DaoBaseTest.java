package com.xjd.note.dao.mapper;

import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.spring.annotation.SpringApplicationContext;

@RunWith(UnitilsJUnit4TestClassRunner.class)
public class DaoBaseTest {

	@SpringApplicationContext({"classpath:spring-context-test.xml", "classpath:spring-data.xml"})
	ApplicationContext applicationContext;
	
}
