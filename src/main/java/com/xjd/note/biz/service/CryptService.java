package com.xjd.note.biz.service;

/**
 * <pre>
 * 加解密的Service
 * </pre>
 * @author elvis.xu
 * @since 2013-11-19
 */
public interface CryptService {
	public static final String CODE_BASE64 = "BASE64";
	public static final String CODE_HEX = "HEX";
	
	public static final String CIPHER_DES = "DES";
	public static final String CIPHER_DESede = "DESede";
	public static final String CIPHER_AES = "AES";
	
	public static final String DIGEST_MD5 = "MD5";
	public static final String DIGEST_SHA1 = "SHA-1";

	/**
	 * <pre>
	 * 使用编码算法进行编码
	 * </pre>
	 * @param codeAlgorithm
	 * @param data
	 * @return
	 * @author elvis.xu
	 * @since 2013-11-19
	 */
	byte[] encode(String codeAlgorithm, byte[] data);
	
	/**
	 * <pre>
	 * 使用编码算法进行解码
	 * </pre>
	 * @param codeAlgorithm
	 * @param data
	 * @return
	 * @author elvis.xu
	 * @since 2013-11-19
	 */
	byte[] decode(String codeAlgorithm, byte[] data);
	
	/**
	 * <pre>
	 * 使用加密算法进行加密
	 * </pre>
	 * @param cipherAlgorithm
	 * @param data
	 * @return
	 * @author elvis.xu
	 * @since 2013-11-19
	 */
	byte[] encrypt(String cipherAlgorithm, byte[] data);
	
	/**
	 * <pre>
	 * 使用加密算法进行解密
	 * </pre>
	 * @param cipherAlgorithm
	 * @param data
	 * @return
	 * @author elvis.xu
	 * @since 2013-11-19
	 */
	byte[] decrypt(String cipherAlgorithm, byte[] data);
	
	
	/**
	 * <pre>
	 * 生成加密算法的密码
	 * </pre>
	 * @param cipherAlgorithm
	 * @param seed
	 * @return
	 * @author elvis.xu
	 * @since 2013-11-19
	 */
	byte[] genKey(String cipherAlgorithm, byte[] seed);
	
	/**
	 * <pre>
	 * 使用摘要算法计算摘要
	 * </pre>
	 * @param digestAlgorithm
	 * @param data
	 * @return
	 * @author elvis.xu
	 * @since 2013-11-19
	 */
	byte[] digest(String digestAlgorithm, byte[] data);
	
	/**
	 * <pre>
	 * byte[]转字符串(编码后的)
	 * </pre>
	 * @param bytes
	 * @return
	 * @author elvis.xu
	 * @since 2013-11-19
	 */
	String bytes2EncodedString(byte[] bytes);
	
	/**
	 * <pre>
	 * 字符串(编码后的)转byte[]
	 * </pre>
	 * @param string
	 * @return
	 * @author elvis.xu
	 * @since 2013-11-19
	 */
	byte[] encodedString2Bytes(String string);
	
	/**
	 * <pre>
	 * 使用配置的编码算法进行编码
	 * </pre>
	 * @param codeAlgorithm
	 * @param data
	 * @return
	 * @author elvis.xu
	 * @since 2013-11-19
	 */
	byte[] encode(byte[] data);
	
	/**
	 * <pre>
	 * 使用配置的编码算法进行解码
	 * </pre>
	 * @param codeAlgorithm
	 * @param data
	 * @return
	 * @author elvis.xu
	 * @since 2013-11-19
	 */
	byte[] decode(byte[] data);
	
	/**
	 * <pre>
	 * 使用配置的加密算法进行加密
	 * </pre>
	 * @param cipherAlgorithm
	 * @param data
	 * @return
	 * @author elvis.xu
	 * @since 2013-11-19
	 */
	byte[] encrypt(byte[] data);
	
	/**
	 * <pre>
	 * 使用配置的加密算法进行解密
	 * </pre>
	 * @param cipherAlgorithm
	 * @param data
	 * @return
	 * @author elvis.xu
	 * @since 2013-11-19
	 */
	byte[] decrypt(byte[] data);
	
	
	/**
	 * <pre>
	 * 生成配置的加密算法的密码
	 * </pre>
	 * @param cipherAlgorithm
	 * @param seed
	 * @return
	 * @author elvis.xu
	 * @since 2013-11-19
	 */
	byte[] genKey(byte[] seed);
	
	/**
	 * <pre>
	 * 使用配置的摘要算法计算摘要
	 * </pre>
	 * @param digestAlgorithm
	 * @param data
	 * @return
	 * @author elvis.xu
	 * @since 2013-11-19
	 */
	byte[] digest(byte[] data);
	
}
