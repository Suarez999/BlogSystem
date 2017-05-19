package me.xx.blogsystem.service;

import java.util.List;

import me.xx.blogsystem.entity.Blog;

public interface BlogService extends BaseService<Blog> {

	int insertBlog(Blog blog) throws Exception;
	
	List<Blog> findByType(int typeId) throws Exception;

	List<Blog> findByBloggerId(int bloggerId);
	
	List<Blog> selectByDate(int id);
	
	List<Blog> findByKeyword(String keyword);
}
