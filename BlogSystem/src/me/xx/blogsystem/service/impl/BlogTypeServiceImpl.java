package me.xx.blogsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import me.xx.blogsystem.dao.BlogTypeMapper;
import me.xx.blogsystem.entity.BlogType;
import me.xx.blogsystem.service.BlogTypeService;
import me.xx.blogsystem.utils.PageBean;

public class BlogTypeServiceImpl implements BlogTypeService{

	@Autowired
	private BlogTypeMapper blogTypeMapper;
	
	public int update(BlogType entity) throws Exception {
		return blogTypeMapper.update(entity);
	}

	public int insert(BlogType blogType) throws Exception{

		return blogTypeMapper.insert(blogType);
	}
	
	public int deleteList(String[] pks) throws Exception {
		
		return blogTypeMapper.deleteList(pks);
	}

	public List<BlogType> findAll() throws Exception{
		List<BlogType> list=blogTypeMapper.findAll();
		return list;
	}
	
	public BlogType findById(int id) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}
	
	public PageBean<BlogType> selectPage(PageBean<BlogType> page) {
		page.setTotal(blogTypeMapper.selectPageCount(page));
		page.setPageList(blogTypeMapper.selectPage(page));
		return page;
	}

	public BlogType select(BlogType t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public BlogType findByTypeName(String typeName) {
		
		return blogTypeMapper.findByTypeName(typeName);
	}

	public List<BlogType> findByBloggerId(int bloggerId) {
		
		return blogTypeMapper.findByBloggerId(bloggerId);
	}

	
}
