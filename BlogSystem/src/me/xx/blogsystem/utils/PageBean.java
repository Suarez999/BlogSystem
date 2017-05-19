package me.xx.blogsystem.utils;

import java.util.List;

public class PageBean<T> {

	private int page;//��ǰҳ
	private int total;//�ܼ�¼��
	private int rows;//ÿҳ��¼��
	private int start;//��ǰҳ��ʼ��¼
	private String keyWord;//��ѯ�ؼ���
	private List<T> pageList;//��ǰҳ��¼
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
