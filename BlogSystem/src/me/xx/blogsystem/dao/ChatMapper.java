package me.xx.blogsystem.dao;

import java.util.List;
import java.util.Map;

import me.xx.blogsystem.entity.Chat;

public interface ChatMapper extends BaseMapper<Chat>{

	List<Chat> findByMap(Map<String,Object> map);
	
	Integer getPageCount(Map<String,Object> map);
}
