package me.xx.blogsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import me.xx.blogsystem.dao.AdminMapper;
import me.xx.blogsystem.entity.Admin;
import me.xx.blogsystem.service.AdminService;
import me.xx.blogsystem.utils.PageBean;

public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminMapper adminMapper;

	public int insert(Admin t) throws Exception {
		
		return adminMapper.insert(t);
	}

	public Admin select(Admin t) throws Exception {
		
		return adminMapper.select(t);
	}

	public List<Admin> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public int update(Admin entity) throws Exception {
		
		return adminMapper.update(entity);
	}

	public Admin findById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public int deleteList(String[] pks) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public PageBean<Admin> selectPage(PageBean<Admin> page) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
