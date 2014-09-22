package com.luoshengsha.onegreen.utils.page;

/**
 * 页码索引
 * @author luoshengsha
 * @date 2014年8月5日 下午2:10:37
 */
public class PageIndex {
	/** 开始索引 **/
	private long startindex;
	/** 结束索引 **/
	private long endindex;

	public PageIndex(long startindex, long endindex) {
		this.startindex = startindex;
		this.endindex = endindex;
	}

	/**
	 * @return 返回开始索引
	 */
	public long getStartindex() {
		return startindex;
	}

	public void setStartindex(long startindex) {
		this.startindex = startindex;
	}

	/**
	 * @return 返回结束索引
	 */
	public long getEndindex() {
		return endindex;
	}

	public void setEndindex(long endindex) {
		this.endindex = endindex;
	}

	/**
	 * 计算所要显示的数据索引
	 * author:luoshengsha
	 * @param viewpagecount 每页显示的数目
	 * @param currentPage 当前页码
	 * @param totalpage 总页码
	 * @return 返回计算后的新数据索引
	 */
	public static PageIndex getPageIndex(long viewpagecount, int currentPage,
			long totalpage) {
		long startpage = currentPage
				- (viewpagecount % 2 == 0 ? viewpagecount / 2 - 1
						: viewpagecount / 2);
		long endpage = currentPage + viewpagecount / 2;
		if (startpage < 1) {
			startpage = 1;
			if (totalpage >= viewpagecount)
				endpage = viewpagecount;
			else
				endpage = totalpage;
		}
		if (endpage > totalpage) {
			endpage = totalpage;
			if ((endpage - viewpagecount) > 0)
				startpage = endpage - viewpagecount + 1;
			else
				startpage = 1;
		}
		return new PageIndex(startpage, endpage);
	}
}
