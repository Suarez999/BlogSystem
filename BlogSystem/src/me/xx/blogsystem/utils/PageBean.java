package me.xx.blogsystem.utils;

import java.util.List;

public class PageBean<T> {

	private int page;//当前页
	private int total;//总记录数
	private int rows;//每页记录数
	private int start;//当前页开始记录
	private String keyWord;//查询关键字
	private List<T> pageList;//当前页记录
	private String value;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getStart() {
		this.start=(page-1)*rows;
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public List<T> getPageList() {
		return pageList;
	}
	public void setPageList(List<T> pageList) {
		this.pageList = pageList;
	}
}
