package me.xx.blogsystem.service;

import java.util.List;

import me.xx.blogsystem.utils.PageBean;

public interface BaseService<T> {
	
	int insert(T t) throws Exception;
	
	T select(T t) throws Exception;
	
	List<T> findAll() throws Exception;
	
	int update(T entity) throws Exception;
	
	T findById(int id) throws Exception;
	
	int deleteList(String []pks) throws Exception;
	
	//·ÖÒ³»ã×Ü
	public PageBean<T> selectPage(PageBean<T> page);
}
