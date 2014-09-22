package com.luoshengsha.onegreen.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.apache.log4j.Logger;

public class MD5Util {
	private static final Logger logger = Logger.getLogger(MD5Util.class);

	public static final String encode(String rawPass) {
		return encode(rawPass, null);
	}

	public static final String encode(String rawPass, Object salt) {
		String saltedPass = mergePasswordAndSalt(rawPass, salt);
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			byte[] digest = messageDigest.digest(saltedPass.getBytes("UTF-8"));
			return new String(encode(digest));
		} catch (Exception e) {
		}
		return rawPass;
	}

	public static final String encode(String rawPass, Object salt, String key) {
		String saltedPass = mergePasswordAndSalt(rawPass, salt);
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			byte[] digest = messageDigest.digest(saltedPass.getBytes("UTF-8"));
			return new String(encode(digest, key));
		} catch (Exception e) {
		}
		return rawPass;
	}

	private static String mergePasswordAndSalt(String password, Object salt) {
		if ((salt == null) || ("".equals(salt.toString().trim()))) {
			return password;
		}
		return password + "{" + salt.toString() + "}";
	}

	private static char[] encode(byte[] bytes) {
		char[] HEX = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a',
				'b', 'c', 'd', 'e', 'f' };
		int nBytes = bytes.length;
		char[] result = new char[2 * nBytes];
		int j = 0;
		for (int i = 0; i < nBytes; ++i) {
			result[(j++)] = HEX[((0xF0 & bytes[i]) >>> 4)];

			result[(j++)] = HEX[(0xF & bytes[i])];
		}
		return result;
	}

	private static char[] encode(byte[] bytes, String key) {
		char[] HEX = key.toCharArray();
		int nBytes = bytes.length;
		char[] result = new char[2 * nBytes];
		int j = 0;
		for (int i = 0; i < nBytes; ++i) {
			result[(j++)] = HEX[((0xF0 & bytes[i]) >>> 4)];

			result[(j++)] = HEX[(0xF & bytes[i])];
		}
		return result;
	}

	public static String getMD5Str(String str) {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(str.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			logger.error("NoSuchAlgorithmException caught!");
			System.exit(-1);
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getCause(), e);
		}
		byte[] byteArray = messageDigest.digest();
		StringBuffer md5StrBuff = new StringBuffer();
		for (int i = 0; i < byteArray.length; ++i) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
				md5StrBuff.append("0").append(
						Integer.toHexString(0xFF & byteArray[i]));
			else {
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
			}
		}
		return md5StrBuff.toString();
	}

	public static String mixEncription(String password, String uuid) {
		String mixPwd = password + uuid;
		return getMD5Str(mixPwd);
	}

	public static void main(String[] args) {
		String s = UUID.randomUUID().toString();
		System.out.println(s + "  " + MD5Util.mixEncription("123456", s));
//		String uuid = s.replaceAll("-", "");
//		uuid = "acdc4d3b4acd4c129d4e4be712e38d27";
//		System.out.println(encode("admin"));
//		System.out.println(encode("admin", "sadfasdf"));
//		System.out.println(encode("admin", "sadfasdf", uuid));
	}
}