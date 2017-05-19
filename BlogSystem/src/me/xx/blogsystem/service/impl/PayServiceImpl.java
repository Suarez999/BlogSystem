package me.xx.blogsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import me.xx.blogsystem.dao.PayMapper;
import me.xx.blogsystem.entity.Pay;
import me.xx.blogsystem.service.PayService;
import me.xx.blogsystem.utils.PageBean;

public class PayServiceImpl implements PayService{

	@Autowired
	private PayMapper payMapper;
	
	public int insert(Pay t) throws Exception {
		
		return payMapper.insert(t);
	}

	public Pay select(Pay t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Pay> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public int update(Pay entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public Pay findById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public int deleteList(String[] pks) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public PageBean<Pay> selectPage(PageBean<Pay> page) {
		// TODO Auto-generated method stub
		return null;
	}

}
