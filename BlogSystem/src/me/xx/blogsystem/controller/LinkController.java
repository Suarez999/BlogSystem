package me.xx.blogsystem.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import me.xx.blogsystem.entity.Link;
import me.xx.blogsystem.service.LinkService;
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
@RequestMapping("/link")
public class LinkController {

	@Autowired
	private LinkService linkService;
	
	@RequestMapping("/listAll")
	public Object listAll(PageBean<Link> page,HttpServletResponse response) throws Exception{
		linkService.selectPage(page);
		List<Link> linkList=page.getPageList();
		JSONObject result = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONArray jsonArray = JSONArray.fromObject(linkList, jsonConfig);
		result.put("rows", jsonArray);
		result.put("total", page.getTotal());
		ResponseUtil.write(response, result);
		return null;
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public Object insert(Link link) throws Exception{
		int i=linkService.insert(link);
		return i;
	} 
	
	@RequestMapping("/deleteList")
	@ResponseBody
	public Object deleteList(String ids) throws Exception{
		String[] pk=ids.split(",");
		int i=linkService.deleteList(pk);
		return i;
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public Object update(Link link) throws Exception{
		int i=linkService.update(link);
		return i;
	}
}
