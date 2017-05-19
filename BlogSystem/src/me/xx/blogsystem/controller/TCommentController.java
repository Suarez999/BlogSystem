package me.xx.blogsystem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import me.xx.blogsystem.entity.Blog;
import me.xx.blogsystem.entity.TComment;
import me.xx.blogsystem.service.BlogService;
import me.xx.blogsystem.service.TCommentService;
import me.xx.blogsystem.utils.DateJsonValueProcessor;
import me.xx.blogsystem.utils.PageBean;
import me.xx.blogsystem.utils.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/comment")
public class TCommentController {

	@Autowired
	private TCommentService tCommentService;
	
	@Autowired
	private BlogService blogService;
	
	@RequestMapping("/insert")
	@ResponseBody
	public Object insert(TComment tComment,String imageCode,HttpSession session,HttpServletRequest request) throws Exception{
	
		int i;
		String imgcd=(String) session.getAttribute("sRand");
		if(imageCode.equals(imgcd)){
			String userIp=request.getRemoteAddr();
			tComment.setUserip(userIp);
			i=tCommentService.insert(tComment);
			Blog blog=blogService.findById(tComment.getBlog().getId());
			blog.setReplyhit(blog.getReplyhit()+1);
			int hit=blogService.update(blog);
			System.out.println(hit);
			System.out.println(blogService.findAll());
		}else{
			i=0;
		}
		
		return i;
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
	public Object findAll(String state,PageBean<TComment> pg,String bloggerId,HttpServletResponse response) throws Exception{
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("state",state);
		map.put("bloggerId",bloggerId);
		map.put("start",pg.getStart());
		map.put("pageSize", pg.getRows());
		List<TComment> list=tCommentService.findByMap(map);
		System.out.println(list);
		int total=tCommentService.getPageCount(map);
		JSONObject result = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;	
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public Object update(String ids,String state) throws Exception{
		
		int flag=0;
		String[] idStr=ids.split(",");
		for(int i=0;i<idStr.length;i++){
			TComment comment=new TComment();
			comment.setId(Integer.parseInt(idStr[i]));
			comment.setState(Integer.parseInt(state));
			flag=tCommentService.update(comment);
		}
		return flag;
	}
	
	@RequestMapping("/deleteList")
	@ResponseBody
	public Object deleteList(String ids) throws Exception{
		String[] pk=ids.split(",");
		int i=tCommentService.deleteList(pk);
		return i;
	}
}
