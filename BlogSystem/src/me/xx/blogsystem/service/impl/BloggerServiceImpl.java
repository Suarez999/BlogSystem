package me.xx.blogsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import me.xx.blogsystem.dao.BloggerMapper;
import me.xx.blogsystem.entity.Blogger;
import me.xx.blogsystem.service.BloggerService;
import me.xx.blogsystem.utils.PageBean;

public class BloggerServiceImpl implements BloggerService{

	@Autowired
	private BloggerMapper bloggerMapper;
	
	public int insert(Blogger t) throws Exception {
		
		return bloggerMapper.insert(t);
	}

	public Blogger select(Blogger entity) throws Exception {
		
		return bloggerMapper.select(entity);
	}

	public List<Blogger> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public int update(Blogger entity) throws Exception {
		
		return bloggerMapper.update(entity);
	}

	public Blogger findById(int id) throws Exception {
		
		return bloggerMapper.findById(id);
	}

	public int deleteList(String[] pks) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public PageBean<Blogger> selectPage(PageBean<Blogger> page) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Blogger> findTop5Blogger() throws Exception {
		
		return bloggerMapper.findTop5Blogger();
	}

}
