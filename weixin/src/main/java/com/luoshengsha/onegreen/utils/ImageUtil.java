package com.luoshengsha.onegreen.utils;

/**
 * 图片工具类
 * @author luoshengsha
 * @date 2014年9月11日 上午10:29:49
 */
public class ImageUtil {
	/**本地文件分隔符*/
    public static final String LOCAL_FILE_SEPARATOR = System.getProperty("file.separator");
	/** 图片服务器地址 **/
	public static final String PICTURE_URL = "http://114.215.110.9/";
	/** 图片存储路径 **/
	public static final String PIC_PERSIST_PATH = "f:" + LOCAL_FILE_SEPARATOR+"tmpFiles"+LOCAL_FILE_SEPARATOR+"migo_picture";
	/** 附件服务器地址 **/
	public static final String ATTACHMENT_URL = "http://114.215.110.9/";
	/** 附件存储路径 **/
	public static final String ATTACHMENT_PERSIST_PATH = LOCAL_FILE_SEPARATOR+"fanna"+LOCAL_FILE_SEPARATOR+"attachment";
}
