package me.xx.blogsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import me.xx.blogsystem.dao.FansMapper;
import me.xx.blogsystem.entity.Fans;
import me.xx.blogsystem.service.FansService;
import me.xx.blogsystem.utils.PageBean;

public class FansServiceImpl implements FansService {

	@Autowired
	private FansMapper fansMapper;
	public int insert(Fans t) throws Exception {

		return fansMapper.insert(t);
	}

	public Fans select(Fans t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Fans> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public int update(Fans entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public Fans findById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public int deleteList(String[] pks) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public PageBean<Fans> selectPage(PageBean<Fans> page) {
		// TODO Auto-generated method stub
		return null;
	}

	public Fans findByIp(String userIp) {
		// TODO Auto-generated method stub
		return fansMapper.findByIp(userIp);
	}

	public Integer deleteByIp(String userIp) {
		
		return fansMapper.deleteByIp(userIp);
	}

}
