package me.xx.blogsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import me.xx.blogsystem.dao.LinkMapper;
import me.xx.blogsystem.entity.Link;
import me.xx.blogsystem.service.LinkService;
import me.xx.blogsystem.utils.PageBean;

public class LinkServiceImpl implements LinkService {

	@Autowired
	private LinkMapper linkMapper;
	
	public int insert(Link t) throws Exception {
		
		return linkMapper.insert(t);
	}

	public Link select(Link t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Link> findAll() throws Exception {
		
		return linkMapper.findAll();
	}

	public int update(Link entity) throws Exception {
		
		return linkMapper.update(entity);
	}

	public Link findById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public int deleteList(String[] pks) throws Exception {
		
		return linkMapper.deleteList(pks);
	}

	public PageBean<Link> selectPage(PageBean<Link> page) {
		page.setTotal(linkMapper.selectPageCount(page));
		page.setPageList(linkMapper.selectPage(page));
		return page;
	}
}
