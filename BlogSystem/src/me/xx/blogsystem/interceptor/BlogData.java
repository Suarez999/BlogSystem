package me.xx.blogsystem.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class BlogData implements HandlerInterceptor,ApplicationContextAware{

	private static ApplicationContext applicationContext;
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
//		String url=request.getRequestURI();
//		System.out.println(url);
//		if(url.indexOf("index.jsp")>0){
//			BlogService blogService=(BlogService) applicationContext.getBean("blogService");
//			List<Blog> blogList=blogService.findAllBlog();
//			request.setAttribute("blogList",blogList);
//		}
		return true;
	}

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		BlogData.applicationContext=applicationContext;
		
	}

}
