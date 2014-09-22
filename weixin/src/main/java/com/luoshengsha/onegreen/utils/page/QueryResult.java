package com.luoshengsha.onegreen.utils.page;

import java.util.List;

/**
 * 查询结果
 * @author luoshengsha
 * @date 2014年8月5日 下午2:10:55
 * @param <T>
 */
public class QueryResult<T> {
	/**查询的结果集**/
	private List<T> resultlist;
	/**结果集的数目**/
	private long totalrecord;

	/**
	 * 返回结果集
	 * @return 返回结果集
	 */
	public List<T> getResultlist() {
		return resultlist;
	}

	public void setResultlist(List<T> resultlist) {
		this.resultlist = resultlist;
	}

	/**
	 * 返回总的记录数
	 * @return 返回总的记录数
	 */
	public long getTotalrecord() {
		return totalrecord;
	}

	public void setTotalrecord(long totalrecord) {
		this.totalrecord = totalrecord;
	}
}
