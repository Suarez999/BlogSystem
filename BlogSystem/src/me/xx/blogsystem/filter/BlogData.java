package me.xx.blogsystem.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.xx.blogsystem.entity.Blog;
import me.xx.blogsystem.entity.Blogger;
import me.xx.blogsystem.entity.Link;
import me.xx.blogsystem.service.BlogService;
import me.xx.blogsystem.service.BloggerService;
import me.xx.blogsystem.service.LinkService;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class BlogData implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest sreq, ServletResponse sres,
			FilterChain filterChain) throws IOException, ServletException {
		
		HttpServletRequest request=(HttpServletRequest) sreq;
		HttpServletResponse response=(HttpServletResponse) sres;
		ServletContext context=request.getSession().getServletContext();
		ApplicationContext ctx=WebApplicationContextUtils.getRequiredWebApplicationContext(context);
		BlogService blogService=(BlogService) ctx.getBean("blogService");
		BloggerService bloggerService=(BloggerService) ctx.getBean("bloggerService");
		LinkService linkService=(LinkService)ctx.getBean("linkService");
		try {
			List<Blog> blogList=blogService.findAll();
			for(Blog blog : blogList) {
				List<String> imageList = blog.getImageList();
				String blogInfo = blog.getContent(); //��ȡ��������
				Document doc = Jsoup.parse(blogInfo); //����������(��ҳ��Ҳ����һЩhtml)תΪjsoup��Document
				Elements jpgs = doc.select("img[src$=.jpg]");//��ȡ<img>��ǩ�����к�׺��.jpg��Ԫ��
				Elements pngs = doc.select("img[src$=.png]");
				for(int i = 0; i < jpgs.size(); i++) {
					Element jpg = jpgs.get(i); //��ȡ������Ԫ��
					imageList.add(jpg.toString()); //��ͼƬ��Ϣ�浽imageList��
					//System.out.println(jpg.toString());
					if(i == 2)
						break; //ֻ������ͼƬ��Ϣ
				}
				for(int i = 0; i < pngs.size(); i++) {
					Element png = pngs.get(i); //��ȡ������Ԫ��
					imageList.add(png.toString()); //��ͼƬ��Ϣ�浽imageList��
					//System.out.println(png.toString());
					if(i == 2)
						break; //ֻ������ͼƬ��Ϣ
				}
			}

			List<Blogger> bloggerList=bloggerService.findTop5Blogger();
			List<Link> linkList=linkService.findAll();
			request.setAttribute("blogList",blogList);
			request.setAttribute("top5Blogger", bloggerList);
			request.setAttribute("linkList",linkList);
			filterChain.doFilter(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
