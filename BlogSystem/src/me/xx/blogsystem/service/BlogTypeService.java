package me.xx.blogsystem.service;

import java.util.List;

import me.xx.blogsystem.entity.BlogType;

public interface BlogTypeService extends BaseService<BlogType> {

	BlogType findByTypeName(String typeName) throws Exception;
	
	List<BlogType> findByBloggerId(int bloggerId);
}
