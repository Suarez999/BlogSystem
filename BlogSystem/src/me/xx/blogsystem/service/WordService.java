package me.xx.blogsystem.service;

import java.util.List;
import java.util.Map;

import me.xx.blogsystem.entity.Word;

public interface WordService extends BaseService<Word>{
	
	List<Word> findByMap(Map<String,Object> map);
	
	Integer getPageCount(Map<String,Object> map);
}
