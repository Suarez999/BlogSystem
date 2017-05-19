package me.xx.blogsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import me.xx.blogsystem.dao.BlogMapper;
import me.xx.blogsystem.entity.Blog;
import me.xx.blogsystem.service.BlogService;
import me.xx.blogsystem.utils.PageBean;

public class BlogServiceImpl implements BlogService{

	@Autowired
	private BlogMapper blogMapper;
	
	public int insertBlog(Blog blog) throws Exception{
		
		return blogMapper.insertBlog(blog);
	}

	public PageBean<Blog> selectPage(PageBean<Blog> page) {
		page.setTotal(blogMapper.selectPageCount(page));
		page.setPageList(blogMapper.selectPage(page));
		return page;
	}

	public List<Blog> findAll() throws Exception{

		return blogMapper.findAll();
	}

	public int update(Blog entity) throws Exception {
		return blogMapper.update(entity);
	}

	public Blog findById(int id) throws Exception{
	
		return blogMapper.findById(id);
	}

	public int deleteList(String[] pks) throws Exception {
		
		return blogMapper.deleteList(pks);
	}

	public int insert(Blog t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Blog select(Blog t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Blog> findByType(int typeId) {
		return blogMapper.findByType(typeId);
	}

	public List<Blog> findByBloggerId(int bloggerId) {
		
		return blogMapper.findByBloggerId(bloggerId);
	}

	public List<Blog> selectByDate(int id) {
		
		return blogMapper.selectByDate(id);
	}

	public List<Blog> findByKeyword(String keyword) {
		
		return blogMapper.findByKeyword(keyword);
	}

}
