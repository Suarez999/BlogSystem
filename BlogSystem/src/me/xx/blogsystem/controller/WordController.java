package me.xx.blogsystem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import me.xx.blogsystem.entity.Word;
import me.xx.blogsystem.service.WordService;
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
@RequestMapping("/word")
public class WordController {
	
	@Autowired
	private WordService wordService;
	
	@RequestMapping("/findAll")
	@ResponseBody
	public Object findAll(PageBean<Word> pg,String bloggerId,HttpServletResponse response) throws Exception{
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("bloggerId",bloggerId);
		map.put("start",pg.getStart());
		map.put("pageSize", pg.getRows());
		List<Word> list=wordService.findByMap(map);
		int total=wordService.getPageCount(map);
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
	
	@RequestMapping("/deleteList")
	@ResponseBody
	public Object deleteList(String ids) throws Exception{
		String[] pk=ids.split(",");
		int i=wordService.deleteList(pk);
		return i;
	}
}
