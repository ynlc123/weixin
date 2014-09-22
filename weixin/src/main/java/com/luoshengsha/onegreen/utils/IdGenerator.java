package com.luoshengsha.onegreen.utils;

import java.util.UUID;

/**
 * id生成器
 * @author luoshengsha
 * @date 2014年9月4日 上午10:54:34
 */
public class IdGenerator {
	
	/**
	 * 生成id
	 * @return
	 */
	public static String generateId() {
		return UUID.randomUUID().toString().toLowerCase().replace("-", "");
	}
}
