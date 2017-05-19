package me.xx.blogsystem.controller;

import me.xx.blogsystem.entity.Fans;
import me.xx.blogsystem.service.FansService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/fans")
public class FansController {

	@Autowired
	private FansService fansService;
	
	@RequestMapping("/findByIp")
	@ResponseBody
	public Object findByIp(String userIp) throws Exception{
		Fans fan=fansService.findByIp(userIp);
		int i=0;
		if(fan!=null){
			return i+1;
		}else return 0;
	}
}
