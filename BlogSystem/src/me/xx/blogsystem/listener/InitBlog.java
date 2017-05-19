package me.xx.blogsystem.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import me.xx.blogsystem.entity.BlogType;
import me.xx.blogsystem.service.BlogTypeService;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class InitBlog implements ServletContextListener,ApplicationContextAware{

	private static ApplicationContext applicationContext;
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		
		InitBlog.applicationContext=applicationContext;
	}

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println(applicationContext);
		ServletContext application = sce.getServletContext();
		BlogTypeService blogTypeService=(BlogTypeService) applicationContext.getBean("blogTypeService");
		List<BlogType> blogTypeList;
		try {
			blogTypeList = blogTypeService.findAll();
			//System.out.println(blogTypeList);
			application.setAttribute("blogTypeList", blogTypeList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
