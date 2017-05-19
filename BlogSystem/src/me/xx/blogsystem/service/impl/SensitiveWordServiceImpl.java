package me.xx.blogsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import me.xx.blogsystem.dao.SensitiveWordMapper;
import me.xx.blogsystem.entity.SensitiveWord;
import me.xx.blogsystem.service.SensitiveWordService;
import me.xx.blogsystem.utils.PageBean;

public class SensitiveWordServiceImpl implements SensitiveWordService {

	
	@Autowired
	private SensitiveWordMapper sensitiveWordMapper;
	
	public int insert(SensitiveWord t) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public SensitiveWord select(SensitiveWord t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SensitiveWord> findAll() throws Exception {
	
		return sensitiveWordMapper.findAll();
	}

	public int update(SensitiveWord entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public SensitiveWord findById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public int deleteList(String[] pks) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public PageBean<SensitiveWord> selectPage(PageBean<SensitiveWord> page) {
		// TODO Auto-generated method stub
		return null;
	}

}
