/**
 * 
 */
package com.xjd.note.biz.service.impl;

import junit.framework.Assert;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.xjd.note.biz.service.SymmetricCryptService;

/**
 * <pre>
 * 
 * </pre>
 * @author elvis.xu
 * @date 2013-11-18
 */
public class SymmetricCryptServiceImplTest extends ServiceBaseTest {
	private static Logger log = LoggerFactory.getLogger(SymmetricCryptServiceImplTest.class);

	@Autowired
	SymmetricCryptServiceImpl symmetricCryptServiceImpl;
	
	@Test
	public void test() {
		String data = "我是一只鱼, elvis9xu@163.com, !@#$%^&*(), 1234567890";
		test(SymmetricCryptService.DES, data);
		test(SymmetricCryptService.DESede, data);
		test(SymmetricCryptService.AES, data);
	}
	
	public void test(String algo, String data) {
		log.info("开始测试算法...: algorithm='{}', data=[{}]", algo, data);
		log.info("原数据(Base64编码): [{}]", Base64.encodeBase64String(data.getBytes()));
		
		byte[] enData = symmetricCryptServiceImpl.encode(algo, data.getBytes());
		log.info("加密后的数据(Base64编码): [{}]", Base64.encodeBase64String(enData));
		
		byte[] deData = symmetricCryptServiceImpl.decode(algo, enData);
		log.info("解密后的数据(Base64编码): [{}]", Base64.encodeBase64String(deData));
		log.info("解密后的数据: [{}]", new String(deData));
		
		Assert.assertEquals(data, new String(deData));
	}

}
