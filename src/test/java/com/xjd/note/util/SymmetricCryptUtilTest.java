/**
 * 
 */
package com.xjd.note.util;

import junit.framework.Assert;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 * 
 * </pre>
 * @author elvis.xu
 * @date 2013-11-18
 */
public class SymmetricCryptUtilTest {
	private static Logger log = LoggerFactory.getLogger(SymmetricCryptUtilTest.class);

	@Test
	public void test() throws Exception {
		String data = "我爱你12345!#@$";
		test(SymmetricCryptUtil.DES, data);
		test(SymmetricCryptUtil.DESede, data);
		test(SymmetricCryptUtil.AES, data);
		test(SymmetricCryptUtil.Blowfish, data);
		test(SymmetricCryptUtil.RC2, data);
		test(SymmetricCryptUtil.RC4, data);
	}
	
	public void test(String algorithm, String data) throws Exception {
		log.info("开始测试加密算法...: algorithm={}, data=[{}]", algorithm, data);
		log.info("原数据(Base64编码): [{}]", Base64.encodeBase64String(data.getBytes()));
		
		byte[] key = SymmetricCryptUtil.genKey(algorithm, null);
		log.info("生成KEY(Base64编码): [{}]", Base64.encodeBase64String(key));
		
		byte[] enData = SymmetricCryptUtil.encrypt(algorithm, key, data.getBytes());
		log.info("加密后的数据(Base64编码): [{}]", Base64.encodeBase64String(enData));
		
		byte[] deData = SymmetricCryptUtil.decrypt(algorithm, key, enData);
		log.info("解密后的数据(Base64编码): [{}]", Base64.encodeBase64String(deData));
		log.info("解密后的数据: [{}]", new String(deData));
		
		Assert.assertEquals(data, new String(deData));
	}

}
