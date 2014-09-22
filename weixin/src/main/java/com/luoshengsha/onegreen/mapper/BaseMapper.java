package com.luoshengsha.onegreen.mapper;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 基础mapper
 * @author luoshengsha
 * @date 2014年8月5日 下午2:13:55
 */
public interface BaseMapper<T> {
	/**
	 * 保存
	 * @param t
	 */
	public void save(T t);
	
	/**
	 * 更新
	 * @param t
	 */
	public void update(T t);
	
	/**
	 * 根据id查找
	 * @param id
	 * @return
	 */
	public T find(Serializable id);
	
	/**
	 * 查询
	 * author:luoshengsha
	 * @param parameterMap 查询条件，key代表字段，value代表此字段的值
	 * @return 查询结果
	 */
	public List<T> query(Map<String,Object> parameterMap);
	
	/**
	 * 获取所有符合条件的记录数
	 * author:luoshengsha
	 * @param parameterMap 查询条件，key代表字段，value代表此字段的值
	 * @return 返回符合此条件的记录数
	 */
	public int getCount(Map<String,Object> parameterMap);

	/**
	 * 根据条件查询数据
	 * @param argsMap 条件
	 * @return
	 */
	public List<T> getByCond(Map<String, Object> argsMap);
	
}
