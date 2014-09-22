package com.luoshengsha.onegreen.utils.page;

import java.util.List;
/**
 * 分页
 * @author luoshengsha
 * @date 2014年8月5日 下午2:10:46
 * @param <T>
 */
public class PageView<T> {
	/** 分页数据 **/
	private List<T> records;
	/** 页码开始索引和结束索引 **/
	private PageIndex pageindex;
	/** 总页数 **/
	private long totalpage = 1;
	/** 每页显示的条数 **/
	private int maxresult = 12;
	/** 当前页 **/
	private int currentpage = 1;
	/** 总记录数 **/
	private long totalrecord;
	/** 页码数量 ，默认为10**/
	private int pagecode = 10;
	
	/**
	 * 获取记录的开始索引
	 * author:luoshengsha
	 * @return 开始索引
	 */
	public int getFirstResult() {
		return (this.currentpage-1)*this.maxresult;
	}
	
	/**
	 * 返回页码数量
	 * @return 返回页码数量
	 */
	public int getPagecode() {
		return pagecode;
	}

	public void setPagecode(int pagecode) {
		this.pagecode = pagecode;
	}

	public PageView(int currentpage, int maxresult) {
		this.maxresult = maxresult;
		this.currentpage = currentpage;
	}
	
	/**
	 * 设置查询记录集
	 * @param qr 结果集
	 */
	public void setQueryResult(QueryResult<T> qr){
		//设置总的记录数
		setTotalrecord(qr.getTotalrecord());
		//设置页面的数据
		setRecords(qr.getResultlist());
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
		setTotalpage(this.totalrecord%this.maxresult==0? this.totalrecord/this.maxresult : this.totalrecord/this.maxresult+1);
	}
	
	/**
	 * 返回结果集
	 * @return 结果集
	 */
	public List<T> getRecords() {
		return records;
	}
	
	public void setRecords(List<T> records) {
		this.records = records;
	}
	
	/**
	 * 返回页面索引
	 * @return 页面索引
	 */
	public PageIndex getPageindex() {
		return pageindex;
	}
	
	/**
	 * 返回总页数
	 * @return 总页数
	 */
	public long getTotalpage() {
		return totalpage;
	}
	
	public void setTotalpage(long totalpage) {
		this.totalpage = totalpage;
		this.pageindex = PageIndex.getPageIndex(pagecode, currentpage, totalpage);
	}
	
	/**
	 * 返回每页显示的条数
	 * @return 每页显示的条数
	 */
	public int getMaxresult() {
		return maxresult;
	}
	
	/**
	 * 获取当前页码
	 * @return 当前页码
	 */
	public int getCurrentpage() {
		return currentpage;
	}
}