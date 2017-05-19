package me.xx.blogsystem.controller;

import java.util.HashMap;
import java.util.Map;

import me.xx.blogsystem.entity.BlogType;
import me.xx.blogsystem.service.BlogTypeService;
import me.xx.blogsystem.utils.PageBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/blogType")
public class BlogTypeController {

	@Autowired
	private BlogTypeService blogTypeService;

	@RequestMapping("/insert")
	@ResponseBody
	public Object insert(BlogType blogType) throws Exception{
		int i=blogTypeService.insert(blogType);
		return i;
	}
	
	@RequestMapping("/deleteList")
	@ResponseBody
	public Object deleteList(String []ids) throws Exception{
		int i=blogTypeService.deleteList(ids);
		return i;
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public Object update(BlogType blogType) throws Exception{
		int i=blogTypeService.update(blogType);
		return i;
	}
	
	@RequestMapping("/selectPageList")
	@ResponseBody
	public Object selectPageList(PageBean<BlogType> pb){
		
		Map<String,Object> map=new HashMap<String,Object>(); 
		blogTypeService.selectPage(pb);
		map.put("rows",pb.getPageList());
		map.put("total",pb.getTotal());
		return map;
	}
}
