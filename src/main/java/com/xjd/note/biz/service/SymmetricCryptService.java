package com.xjd.note.biz.service;

/**
 * <pre>
 * 对称加密的Service
 * </pre>
 * @author Administrator
 * @date 2013-11-18
 */
public interface SymmetricCryptService {
	public static final String DES = "DES";
	public static final String DESede = "DESede";
	public static final String AES = "AES";

	byte[] encode(String algorithm, byte[] data);
	
	byte[] decode(String algorithm, byte[] data);
	
}
