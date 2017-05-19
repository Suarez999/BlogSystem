package me.xx.blogsystem.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import me.xx.blogsystem.dao.TCommentMapper;
import me.xx.blogsystem.entity.TComment;
import me.xx.blogsystem.service.TCommentService;
import me.xx.blogsystem.utils.PageBean;

public class TCommentServiceImpl implements TCommentService{

	@Autowired
	private TCommentMapper tCommentMapper;
	public int insert(TComment t) throws Exception {
		return tCommentMapper.insert(t);
	}

	public TComment select(TComment t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TComment> findAll() throws Exception {

		return tCommentMapper.findAll();
	}

	public int update(TComment entity) throws Exception {
		
		return tCommentMapper.update(entity);
	}

	public TComment findById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public int deleteList(String[] pks) throws Exception {
		
		return tCommentMapper.deleteList(pks);
	}

	public PageBean<TComment> selectPage(PageBean<TComment> page) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TComment> findByMap(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return tCommentMapper.findByMap(map);
	}

	public Integer getPageCount(Map<String,Object> map) {
		
		return tCommentMapper.getPageCount(map);
	}

}
