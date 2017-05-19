package me.xx.blogsystem.dao;

import java.util.List;

import me.xx.blogsystem.entity.BlogType;


public interface BlogTypeMapper extends BaseMapper<BlogType>{
   
	BlogType findByTypeName(String typeName);
	
	List<BlogType> findByBloggerId(int bloggerId);
}