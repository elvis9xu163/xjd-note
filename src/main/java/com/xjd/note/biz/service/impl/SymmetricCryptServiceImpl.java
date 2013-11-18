/**
 * 
 */
package com.xjd.note.biz.service.impl;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.util.encoders.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.xjd.note.biz.service.SymmetricCryptService;
import com.xjd.note.util.SymmetricCryptUtil;

/**
 * @author elvis.xu
 * @date 2013-11-18
 */
@Service
public class SymmetricCryptServiceImpl implements SymmetricCryptService {

	@Value("#{properties['crypt.desKeyWithBase64']}")
	protected String desKey;
	@Value("#{properties['crypt.desedeKeyWithBase64']}")
	protected String desedeKey;
	@Value("#{properties['crypt.aesKeyWithBase64']}")
	protected String aesKey;

	protected byte[] desKeyBytes;
	protected byte[] desedeKeyBytes;
	protected byte[] aesKeyBytes;

	@PostConstruct
	public void init() {
		desKeyBytes = toBytes(desKey);
		desedeKeyBytes = toBytes(desedeKey);
		aesKeyBytes = toBytes(aesKey);
	}

	public byte[] toBytes(String key) {
		if (StringUtils.isBlank(key))
			return null;
		return Base64.decode(key.trim());
	}

	public byte[] getKey(String algorithm) {
		byte[] key = null;
		if (SymmetricCryptUtil.DES.equalsIgnoreCase(algorithm)) {
			key = desKeyBytes;
		} else if (SymmetricCryptUtil.DESede.equalsIgnoreCase(algorithm)) {
			key = desedeKeyBytes;
		} else if (SymmetricCryptUtil.AES.equalsIgnoreCase(algorithm)) {
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
	public byte[] encode(String algorithm, byte[] data) {
		byte[] key = getKey(algorithm);
		try {
			return SymmetricCryptUtil.encrypt(algorithm, key, data);
		} catch (Exception e) {
			throw new RuntimeException("Crypt exception.", e);
		}
	}

	@Override
	public byte[] decode(String algorithm, byte[] data) {
		byte[] key = getKey(algorithm);
		try {
			return SymmetricCryptUtil.decrypt(algorithm, key, data);
		} catch (Exception e) {
			throw new RuntimeException("Crypt exception.", e);
		}
	}

}
