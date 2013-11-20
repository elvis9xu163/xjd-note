package com.xjd.note.biz.service.impl;

import java.nio.charset.Charset;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.xjd.note.biz.service.CryptService;
import com.xjd.util.crypt.CipherUtil;
import com.xjd.util.crypt.CoderUtil;
import com.xjd.util.crypt.CryptUtil;
import com.xjd.util.crypt.DigestUtil;

/**
 * <pre>
 * 
 * </pre>
 * @author elvis.xu
 * @since 2013-11-19
 */
@Service
public class CryptServiceImpl implements CryptService {
	private static Logger log = LoggerFactory.getLogger(CryptServiceImpl.class);
	
	public static final String DEFAULT_CODE_STRING = CryptService.CODE_BASE64;
	public static final String DEFAULT_CODE_ALGORITHM = CryptService.CODE_BASE64;
	public static final String DEFAULT_CIPHER_ALGORITHM = CryptService.CIPHER_DESede;
	public static final String DEFAULT_DIGEST_ALGORITHM = CryptService.DIGEST_SHA1;
	
	@Value("#{properties['crypt.charset']}")
	protected String charsetName;
	
	@Value("#{properties['crypt.code.string']}")
	protected String codeString;
	
	@Value("#{properties['crypt.code.algorithm']}")
	protected String codeAlgorithm;
	
	@Value("#{properties['crypt.cipher.algorithm']}")
	protected String cipherAlgorithm;
	
	@Value("#{properties['crypt.digest.algorithm']}")
	protected String digestAlgorithm;

	@Value("#{properties['crypt.key.des']}")
	protected String desKey;
	
	@Value("#{properties['crypt.key.desede']}")
	protected String desedeKey;
	
	@Value("#{properties['crypt.key.aes']}")
	protected String aesKey;
	
	protected Charset charset;
	protected byte[] desKeyBytes;
	protected byte[] desedeKeyBytes;
	protected byte[] aesKeyBytes;

	@PostConstruct
	public void init() {
		if (StringUtils.isBlank(charsetName)) {
			charset = Charset.defaultCharset();
			charsetName = charset.name();
			log.info("使用默认字符编码: {}", charsetName);
		} else {
			log.info("读取到字符编码配置: {}", charsetName);
			charset = Charset.forName(charsetName.trim());
		}
		
		if (StringUtils.isBlank(codeString)) {
			codeString = DEFAULT_CODE_STRING;
			log.info("使用默认字符串编码算法: {}", codeString);
		} else {
			log.info("读取到字符串编码算法配置: {}", codeString);
			codeString = codeString.trim();
		}
		
		if (StringUtils.isBlank(codeAlgorithm)) {
			codeAlgorithm = DEFAULT_CODE_ALGORITHM;
			log.info("使用默认编码算法: {}", codeAlgorithm);
		} else {
			log.info("读取到编码算法配置: {}", codeAlgorithm);
			codeAlgorithm = codeAlgorithm.trim();
		}
		
		if (StringUtils.isBlank(cipherAlgorithm)) {
			cipherAlgorithm = DEFAULT_CIPHER_ALGORITHM;
			log.info("使用默认加密算法: {}", cipherAlgorithm);
		} else {
			log.info("读取到加密算法配置: {}", cipherAlgorithm);
			cipherAlgorithm = cipherAlgorithm.trim();
		}
		
		if (StringUtils.isBlank(digestAlgorithm)) {
			digestAlgorithm = DEFAULT_DIGEST_ALGORITHM;
			log.info("使用默认摘要算法: {}", digestAlgorithm);
		} else {
			log.info("读取到摘要算法配置: {}", digestAlgorithm);
			digestAlgorithm = digestAlgorithm.trim();
		}
		desKeyBytes = encodedString2Bytes(desKey);
		desedeKeyBytes = encodedString2Bytes(desedeKey);
		aesKeyBytes = encodedString2Bytes(aesKey);
	}

	public byte[] getKey(String algorithm) {
		byte[] key = null;
		if (CipherUtil.DES.equalsIgnoreCase(algorithm)) {
			key = desKeyBytes;
			
		} else if (CipherUtil.DESede.equalsIgnoreCase(algorithm)) {
			key = desedeKeyBytes;
			
		} else if (CipherUtil.AES.equalsIgnoreCase(algorithm)) {
			key = aesKeyBytes;
			
		} else {
			throw new RuntimeException(String.format("Currently the algorithm '%s' is not support.", algorithm));
		}
		if (key == null) {
			throw new RuntimeException(String.format("Can not find key for crypt algorithm '%s'.", algorithm));
		}
		return key;
	}
	
	@Override
	public byte[] encode(String codeAlgorithm, byte[] data) {
		return CoderUtil.encode(codeAlgorithm, data);
	}

	@Override
	public byte[] decode(String codeAlgorithm, byte[] data) {
		return CoderUtil.decode(codeAlgorithm, data);
	}

	@Override
	public byte[] encrypt(String cipherAlgorithm, byte[] data) {
		return CipherUtil.encrypt(cipherAlgorithm, getKey(cipherAlgorithm), data);
	}

	@Override
	public byte[] decrypt(String cipherAlgorithm, byte[] data) {
		return CipherUtil.decrypt(cipherAlgorithm, getKey(cipherAlgorithm), data);
	}

	@Override
	public byte[] genKey(String cipherAlgorithm, byte[] seed) {
		return CipherUtil.genKey(cipherAlgorithm, seed);
	}

	@Override
	public byte[] digest(String digestAlgorithm, byte[] data) {
		return DigestUtil.digest(digestAlgorithm, data);
	}

	@Override
	public String bytes2EncodedString(byte[] bytes) {
		if (bytes == null) return null;
		byte[] enBytes = CryptUtil.encode(codeString, bytes);
		return new String(enBytes, charset);
	}

	@Override
	public byte[] encodedString2Bytes(String string) {
		if (string == null) return null;
		byte[] enBytes = string.getBytes(charset);
		return CryptUtil.decode(codeString, enBytes);
	}

	@Override
	public byte[] encode(byte[] data) {
		return encode(codeAlgorithm, data);
	}

	@Override
	public byte[] decode(byte[] data) {
		return decode(codeAlgorithm, data);
	}

	@Override
	public byte[] encrypt(byte[] data) {
		return encrypt(cipherAlgorithm, data);
	}

	@Override
	public byte[] decrypt(byte[] data) {
		return decrypt(cipherAlgorithm, data);
	}

	@Override
	public byte[] genKey(byte[] seed) {
		return genKey(cipherAlgorithm, seed);
	}

	@Override
	public byte[] digest(byte[] data) {
		return digest(digestAlgorithm, data);
	}
	
}
