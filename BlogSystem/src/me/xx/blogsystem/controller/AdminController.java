package me.xx.blogsystem.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import me.xx.blogsystem.entity.Admin;
import me.xx.blogsystem.entity.BlogType;
import me.xx.blogsystem.service.AdminService;
import me.xx.blogsystem.service.BlogTypeService;
import me.xx.blogsystem.utils.ResponseUtil;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private BlogTypeService blogTypeService;
	
	@RequestMapping("/insertAdmin")
	public String insertAdmin(Admin admin,Model model){
		try {
			adminService.insert(admin);
			model.addAttribute("admin",admin);
			return "forward:/success.jsp";
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@RequestMapping("/login")
	public String login(Admin admin,Model model,HttpSession session) throws Exception{
		Admin ad = adminService.select(admin);
		if(ad!=null){
			session.setAttribute("username",admin.getUsername());
			session.setAttribute("adminId",ad.getId());
			return "admin/main";
		}else {
			model.addAttribute("msg","µÇÂ½Ê§°Ü£¡");
			return "adminlogin";
		}
	}
	
	@RequestMapping("/modifyPassword")
	public String modifyPassword(Admin admin,HttpServletResponse response) throws Exception{
		int i=adminService.update(admin);
		JSONObject result = new JSONObject();
		if(i > 0) {
			result.put("success", true);
		} else {
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		return null;
	}
	
	@RequestMapping("/logout")
	public void logout(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.getSession().invalidate();
		response.sendRedirect(request.getContextPath()+"/adminlogin.jsp");
	}
	
	@RequestMapping("/refreshSystemCache")
	public Object refreshSystemCache(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ServletContext application=request.getSession().getServletContext();
		List<BlogType> blogTypeList=blogTypeService.findAll();
		application.setAttribute("blogTypeList", blogTypeList);
		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
}
