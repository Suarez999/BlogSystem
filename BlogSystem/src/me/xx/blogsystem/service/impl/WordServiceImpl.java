package me.xx.blogsystem.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import me.xx.blogsystem.dao.WordMapper;
import me.xx.blogsystem.entity.Word;
import me.xx.blogsystem.service.WordService;
import me.xx.blogsystem.utils.PageBean;

public class WordServiceImpl implements WordService {

	@Autowired
	private WordMapper wordMapper;
	public int insert(Word t) throws Exception {
		
		return wordMapper.insert(t);
	}

	public Word select(Word t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Word> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public int update(Word entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public Word findById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public int deleteList(String[] pks) throws Exception {
		
		return wordMapper.deleteList(pks);
	}

	public PageBean<Word> selectPage(PageBean<Word> page) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Word> findByMap(Map<String, Object> map) {
	
		return wordMapper.findByMap(map);
	}

	public Integer getPageCount(Map<String, Object> map) {
		
		return wordMapper.getPageCount(map);
	}

}
