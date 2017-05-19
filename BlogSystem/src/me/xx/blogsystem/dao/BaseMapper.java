package me.xx.blogsystem.dao;

import java.util.List;

import me.xx.blogsystem.utils.PageBean;

public interface BaseMapper<T> {

	int insert(T entity);
	
	int delete(T entity);
	
	int deleteList(String []pks);
	
	int update(T entity);
	
	T select(T entity);
	
	List<T> findAll();
	
	T findById(int id);
	
	//·ÖÒ³
	List<T> selectPage(PageBean<T> page);
	
	int selectPageCount(PageBean<T> page);
}
