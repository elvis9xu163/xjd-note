package com.xjd.note.biz.service.impl;

import java.nio.charset.Charset;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.xjd.note.biz.service.CryptService;

public class CryptServiceImplTest extends ServiceBaseTest {
	private static Logger log = LoggerFactory.getLogger(CryptServiceImplTest.class);
	
	@Autowired
	CryptServiceImpl cryptServiceImpl;
	
	@Test
	public void string2Bytes() {
		byte[] bytes = "李又又江同志号称“将军”？若他敢上钓鱼岛上高歌一曲！可以考虑给“银枪小霸王”减刑5年，否则请自去“将军”头衔，不要在这里丢人现眼！！！同意的请顶一个！".getBytes(Charset.forName("UTF-8"));
		
		String string = cryptServiceImpl.bytes2EncodedString(bytes);
		
		byte[] bs = cryptServiceImpl.encodedString2Bytes(string);
		
		Assert.assertArrayEquals(bytes, bs);
	}

	@Test
	public void testEncode() {
		byte[] data = "李又又江同志号称“将军”？若他敢上钓鱼岛上高歌一曲！可以考虑给“银枪小霸王”减刑5年，否则请自去“将军”头衔，不要在这里丢人现眼！！！同意的请顶一个！".getBytes(Charset.forName("UTF-8"));
		testEncode(CryptService.CODE_BASE64, data);
		testEncode(CryptService.CODE_HEX, data);
	}
	
	public void testEncode(String algorithm, byte[] data) {
		log.info("开始测试算法'{}'...", algorithm);
		log.info("原始数据: [{}]", cryptServiceImpl.bytes2EncodedString(data));
		
		byte[] endata = cryptServiceImpl.encode(algorithm, data);
		log.info("加密数据: [{}]", cryptServiceImpl.bytes2EncodedString(endata));
		
		byte[] dedata = cryptServiceImpl.decode(algorithm, endata);
		log.info("解密数据: [{}]", cryptServiceImpl.bytes2EncodedString(dedata));
		
		Assert.assertArrayEquals(data, dedata);
		Assert.assertEquals(cryptServiceImpl.bytes2EncodedString(data), cryptServiceImpl.bytes2EncodedString(dedata));
	}

	@Test
	public void testEncrypt() {
		//TODO
	}

	@Test
	public void testGenKey() {
		//TODO
	}

	@Test
	public void testDigest() {
		//TODO
	}

}
