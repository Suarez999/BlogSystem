package me.xx.blogsystem.dao;

import java.util.List;
import java.util.Map;

import me.xx.blogsystem.entity.Word;

public interface WordMapper extends BaseMapper<Word>{
    
	List<Word> findByMap(Map<String,Object> map);
	
	Integer getPageCount(Map<String,Object> map);
}