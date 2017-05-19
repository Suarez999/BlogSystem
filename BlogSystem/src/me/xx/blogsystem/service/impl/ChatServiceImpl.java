package me.xx.blogsystem.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import me.xx.blogsystem.dao.ChatMapper;
import me.xx.blogsystem.entity.Chat;
import me.xx.blogsystem.service.ChatService;
import me.xx.blogsystem.utils.PageBean;

public class ChatServiceImpl implements ChatService {

	@Autowired
	private ChatMapper chatMapper;
	
	public int insert(Chat t) throws Exception {
		
		return chatMapper.insert(t);
	}

	public Chat select(Chat t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Chat> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public int update(Chat entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public Chat findById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public int deleteList(String[] pks) throws Exception {
		// TODO Auto-generated method stub
		return chatMapper.deleteList(pks);
	}

	public PageBean<Chat> selectPage(PageBean<Chat> page) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Chat> findByMap(Map<String, Object> map) {
		
		return chatMapper.findByMap(map);
	}

	public Integer getPageCount(Map<String, Object> map) {
		
		return chatMapper.getPageCount(map);
	}

}
