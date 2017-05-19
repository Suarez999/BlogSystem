package me.xx.blogsystem.service;

import java.util.List;
import java.util.Map;

import me.xx.blogsystem.entity.TComment;

public interface TCommentService extends BaseService<TComment>{

	List<TComment> findByMap(Map<String, Object> map);
	
	Integer getPageCount(Map<String,Object> map);
}
