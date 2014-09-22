package com.luoshengsha.onegreen.service;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.luoshengsha.onegreen.utils.page.QueryResult;

/**
 * 基础业务接口
 * @author luoshengsha
 * @date 2014年8月5日 下午2:22:09
 * @param <T>
 */
public interface BaseDAO<T> {
	/**
	 * 查询实体集。根据条件查找指定索引值的数据，并进行排序。
	 * author:luoshengsha
	 * @param index 数据开始索引值
	 * @param max 获取的数据量
	 * @param conditionMap 条件
	 * @param orderBy 排序
	 * @return 返回查询得到结果数据
	 */
	public QueryResult<T> query(int index,int max,Map<String,Object> conditionMap,LinkedHashMap<String,String> orderBy);
	/**
	 * 查询实体集。根据条件查找指定索引值的数据，但不排序
	 * author:luoshengsha
	 * @param index 数据开始索引值
	 * @param max 获取的数据量
	 * @param conditionMap 条件
	 * @return 返回查询得到的结果数据
	 */
	public QueryResult<T> query(int index,int max,Map<String,Object> conditionMap);
	/**
	 * 查询实体集。查找指定索引值的数据，但不排序
	 * author:luoshengsha
	 * @param index 数据开始索引值
	 * @param max 获取的数据量
	 * @return 返回查询得到的结果数据
	 */
	public QueryResult<T> query(int index,int max);
	/**
	 * 查询所有数据
	 * author:luoshengsha
	 * @return 返回查询得到的结果数据
	 */
	public QueryResult<T> query();
	
	/**
	 * 根据条件获取指定数量的数据
	 * @param conditionMap 产品
	 * @param orderBy 排序字段
	 * @param max 数量
	 * @return
	 */
	public List<T> getByCond(Map<String,Object> conditionMap, LinkedHashMap<String,String> orderBy, int max);
	
	/**
	 * 根据id获取实体
	 * author:luoshengsha
	 * @param id 实体id
	 * @return 返回得到的实体，当数据不存在时返回null
	 */
	public T find(Serializable id);
	
	/**
	 * 保存
	 * @param t
	 */
	public void save(T t);
	
	/**
	 * 更新
	 * @param t
	 */
	//public void update(T t);
}
