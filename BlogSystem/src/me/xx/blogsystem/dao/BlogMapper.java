package me.xx.blogsystem.dao;

import java.util.List;

import me.xx.blogsystem.entity.Blog;


public interface BlogMapper extends BaseMapper<Blog>{
	
	int insertBlog(Blog blog);
	
	List<Blog> findByType(int typeId);

	List<Blog> findByBloggerId(int bloggerId);
	
	List<Blog> selectByDate(int id);
	
	List<Blog> findByKeyword(String keyword);
}