package com.luoshengsha.onegreen.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

/**
 * 时间工具类
 * <p>版权所有：凡纳网络科技有限责任公司</p>
 * <p>网址：<a href="http://www.fanna.com.cn" target="_blank">http://www.fanna.com.cn</a></p>
 * @author luoshengsha
 * 时间：2014-1-3 下午2:55:02
 */
public class TimeUtil {
	/**
     * 把时间转成字符串
     * @param date
     * @param pattern
     * @return 
     * @author luoshengsha
     */
    public static String format2String(Date date, String pattern) {
    	try {
    		//当传入的时间为空时，返回null
    		if(date==null) return null;
    		
			SimpleDateFormat formater = null;
			if(!StringUtils.isEmpty(pattern)) {
				formater = new SimpleDateFormat(pattern);
			} else {
				formater = new SimpleDateFormat("yyyy-MM-dd");
			}
			return formater.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    /**
     * 把时间转成字符串
     * @param date
     * @return 
     * @author luoshengsha
     */
    public static String format2String(Date date) {
    	return format2String(date,null);
    }
    
    /**
     * 把字符串转化成时间
     * @param dateStr
     * @param pattern
     * @return 
     * @author luoshengsha
     */
    public static Date str2Date(String dateStr, String pattern) {
    	try {
    		//当传入的时间为空时，返回null
    		if(StringUtils.isEmpty(dateStr)) return null;
    		
			SimpleDateFormat formater = null;
			if(!StringUtils.isEmpty(pattern)) {
				formater = new SimpleDateFormat(pattern);
			} else {
				formater = new SimpleDateFormat("yyyy-MM-dd");
			}
			return formater.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    /**
     * 把字符串转化成时间
     * @param dateStr
     * @return 
     * @author luoshengsha
     */
    public static Date str2Date(String dateStr) {
    	return str2Date(dateStr,null);
    }
    
    /**
     * 获取两个时间之间的天数
     * @param from 起始时间
     * @param to 结束时间
     * @return 
     * @author luoshengsha
     */
    public static long getDays(Date from, Date to) {
    	if(from == null) return 0;//当起始时间为空时，返回0
    	if(to == null) to = new Date();//当结束时间为空时，默认结束时间为当天
    	long times = to.getTime()-from.getTime();
    	return times/1000/60/60/24;
    }
    
    /**
     * 获取指定时间到今天的天数
     * @param from
     * @return 
     * @author luoshengsha
     */
    public static long getDaysToToday(Date from) {
    	return getDays(from,null);
    }
    
    /**
     * 获取今天到指定时间之间的天数
     * @param from
     * @return 
     * @author luoshengsha
     */
    public static long getDaysfromToday(Date to) {
    	long days = getDays(new Date(),to);
    	return days>=0 ? days : Math.abs(days);
    }
    
    /**
     * 获取今天0点0时0分0秒的时间
     * @return 
     * @author luoshengsha
     */
    public static Date getToday() {
    	try {
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date today = sdf.parse(calendar.get(Calendar.YEAR)+"-"+(calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.DATE));
			return today;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
    }
    
    public static void main(String [] args) {
    	//System.out.println(format2String(TimeUtil.str2Date("2014-01-03", null),null));
//    	System.out.println(getDaysfromToday(str2Date("2014-1-11")));
//    	Calendar calendar = Calendar.getInstance();
//    	System.out.println(calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH)+1) + "-" + calendar.get(Calendar.DATE));
    	System.out.println(getDaysToToday(new Date()));
    }
}
