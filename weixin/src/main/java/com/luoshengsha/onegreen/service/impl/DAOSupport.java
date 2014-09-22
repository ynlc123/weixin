package com.luoshengsha.onegreen.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.luoshengsha.onegreen.mapper.BaseMapper;
import com.luoshengsha.onegreen.service.BaseDAO;
import com.luoshengsha.onegreen.utils.page.QueryResult;

/**
 * 基础业务接口实现
 * @author luoshengsha
 * @date 2014年8月5日 下午2:22:26
 * @param <T>
 */
public abstract class DAOSupport<T> implements BaseDAO<T> {

	/**
	 * 获取每个实体的mapper
	 * author:luoshengsha
	 * @return BaseMapper
	 */
	protected abstract BaseMapper<T> getMapper();
	
	/**
	 * 查询实体集。根据条件查找指定索引值的数据，并进行排序。
	 * 当index<=0或是max<0时，不进行分页。
	 * mybatis-config.xml配置文件中，可以通过index获取开始索引值，max获取待显示的数据量，orderBy获取排序sql
	 */
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public QueryResult<T> query(int index,int max,Map<String,Object> conditionMap,LinkedHashMap<String,String> orderBy) {
		QueryResult<T> qr = new QueryResult<T>();
		
		Map<String,Object> argsMap = null;
		if(conditionMap != null) {
			argsMap = conditionMap;
		} else {
			argsMap = new HashMap<String,Object>();
		}
		if(index >= 0 && max > 0) {
			argsMap.put("index", index);
			argsMap.put("max", max);
		}
		if(orderBy != null && !orderBy.isEmpty()) {
			argsMap.put("orderBy", buildOrderby(orderBy));
		}
		qr.setResultlist(getMapper().query(argsMap));
		qr.setTotalrecord(getMapper().getCount(argsMap));
		
		return qr;
	}
	
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public QueryResult<T> query(int index, int max, Map<String, Object> conditionMap) {
		return this.query(index, max, conditionMap, null);
	}

	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public QueryResult<T> query(int index, int max) {
		return this.query(index, max, null);
	}

	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public QueryResult<T> query() {
		return this.query(-1, -1);
	}

	@Override
	public List<T> getByCond(Map<String,Object> conditionMap, LinkedHashMap<String,String> orderBy, int max) {
		Map<String,Object> argsMap = null;
		if(conditionMap != null) {
			argsMap = conditionMap;
		} else {
			argsMap = new HashMap<String,Object>();
		}
		if(max > 0) {
			argsMap.put("max", max);
		}
		if(orderBy != null && !orderBy.isEmpty()) {
			argsMap.put("orderBy", buildOrderby(orderBy));
		}
		return getMapper().getByCond(argsMap);
	}

	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public T find(Serializable id) {
		return getMapper().find(id);
	}

	@Override
	public void save(T t) {
		getMapper().save(t);
	}
	
	

	/*@Override
	public void update(T t) {
		getMapper().update(t);
	}*/

	/**
	 * 构建排序
	 * author:luoshengsha
	 * @param orderby 格式如："name：desc",代表根据name进行desc排序
	 * @return 拼装好的排序sql，如“name desc”
	 */
	protected static String buildOrderby(LinkedHashMap<String, String> orderby) {
		StringBuffer orderSql = new StringBuffer("");
		if(orderby!=null && orderby.size()>0){
			for(String key : orderby.keySet()){
				orderSql.append(key).append(" ").append(orderby.get(key)).append(",");
			}
			orderSql.deleteCharAt(orderSql.length()-1);
		}
		return orderSql.toString();
	}
}
