package me.xx.blogsystem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.xx.blogsystem.entity.Blog;
import me.xx.blogsystem.entity.BlogType;
import me.xx.blogsystem.entity.Blogger;
import me.xx.blogsystem.entity.Pay;
import me.xx.blogsystem.entity.TComment;
import me.xx.blogsystem.service.BlogService;
import me.xx.blogsystem.service.BlogTypeService;
import me.xx.blogsystem.service.BloggerService;
import me.xx.blogsystem.service.PayService;
import me.xx.blogsystem.service.TCommentService;
import me.xx.blogsystem.utils.DateJsonValueProcessor;
import me.xx.blogsystem.utils.PageBean;
import me.xx.blogsystem.utils.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/blog")
public class BlogController {

	@Autowired
	private BlogService blogService;
	
	@Autowired
	private TCommentService tCommentService;
	
	@Autowired
	private BlogTypeService blogTypeService;
	
	@Autowired
	private BloggerService bloggerService;
	
	@Autowired
	private PayService payService;
	
	@RequestMapping("/save")
	@ResponseBody
	public Object save(Blog blog) throws Exception{
		int i=0;
		i=blogService.insertBlog(blog);
		return i;
	}
	
	@RequestMapping("/selectPage")
	@ResponseBody
	public Object selectPage(PageBean<Blog> page,HttpServletResponse response,String title) throws Exception{
		blogService.selectPage(page);
		List<Blog> blogList=page.getPageList();
		JSONObject result = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONArray jsonArray = JSONArray.fromObject(blogList, jsonConfig);
		result.put("rows", jsonArray);
		result.put("total", page.getTotal());
		ResponseUtil.write(response, result);
		return null;
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public Object update(Blog blog) throws Exception{
		int i=blogService.update(blog);
		return i;
	}
	
	@RequestMapping("/deleteList")
	@ResponseBody
	public Object deleteList(String []pks) throws Exception{
		int i=blogService.deleteList(pks);
		return i;
	}
	
	@RequestMapping("/findById")
	@ResponseBody
	public Object findById(String id) throws Exception{
		Blog blog=blogService.findById(Integer.parseInt(id));
		System.out.println(blog);
		return blog;
	}
	
	@RequestMapping("/findBlogById")
	public String findBlogById(Model model,String id,String bloggerId) throws Exception{
		Blog blog=blogService.findById(Integer.parseInt(id));
		String keyWords = blog.getKeyword();
		String[] keyWordList = keyWords.split(" ");
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("blogId",blog.getId());
		map.put("state", 1);
		map.put("bloggerId", bloggerId);
		List<TComment> commentList=tCommentService.findByMap(map);
		model.addAttribute("blog", blog);
		//System.out.println(blog);
		if(blog.getClickhit()==null){
			blog.setClickhit(1);
		}else{
			blog.setClickhit(blog.getClickhit()+1);
		}
		blogService.update(blog);
		System.out.println(blog);
		//System.out.println(blogService.findById(4).getClickhit());
		model.addAttribute("keyWords",keyWordList);
		model.addAttribute("commentList", commentList);
		return "foreground/blog/blogDetail";
	}
	
	@RequestMapping("/findByType")
	public String findByType(String type,Model model) throws Exception{
		type=new String(type.getBytes("iso-8859-1"),"utf-8");
		if(type.equals("首页")){
			return "index";
		}
		BlogType blogType=blogTypeService.findByTypeName(type);
		if(blogType!=null){
			List<Blog> blogList=blogService.findByType(blogType.getId());
			for(Blog blog : blogList) {
				List<String> imageList = blog.getImageList();
				String blogInfo = blog.getContent(); //获取博客内容
				Document doc = Jsoup.parse(blogInfo); //将博客内容(网页中也就是一些html)转为jsoup的Document
				Elements jpgs = doc.select("img[src$=.jpg]");//获取<img>标签中所有后缀是.jpg的元素
				Elements pngs = doc.select("img[src$=.png]");
				for(int i = 0; i < jpgs.size(); i++) {
					Element jpg = jpgs.get(i); //获取到单个元素
					imageList.add(jpg.toString()); //把图片信息存到imageList中
					//System.out.println(jpg.toString());
					if(i == 2)
						break; //只存三张图片信息
				}
				for(int i = 0; i < pngs.size(); i++) {
					Element png = pngs.get(i); //获取到单个元素
					imageList.add(png.toString()); //把图片信息存到imageList中
					System.out.println(png.toString());
					if(i == 2)
						break; //只存三张图片信息
				}
			}
			List<Blogger> bloggerList=bloggerService.findTop5Blogger();
			model.addAttribute("blogList",blogList);
			model.addAttribute("top5Blogger", bloggerList);
			return "foreground/blog/wx";	
		}else return "success";
	}
	
	@RequestMapping("/findByBloggerId")
	public String findByBloggerId(String id,Model model){
		List<Blog> blog = blogService.findByBloggerId(Integer.parseInt(id));
		model.addAttribute("nowBlog",blog);
		return "foreground/blogger/blogger";	
	}
	
	@RequestMapping("/daShang")
	public String daShang(String bloggerId,String id,Model model) throws Exception{
		Blogger blogger=bloggerService.findById(Integer.parseInt(bloggerId));
		model.addAttribute("nowBlogger",blogger);
		model.addAttribute("blogId",id);
		return "foreground/blog/dashang";
	}
	
	@RequestMapping("/updatePay")
	@ResponseBody
	public Object updatePay(Pay pay,String blogId,Model model,HttpServletRequest request) throws Exception{
		String userIp=request.getRemoteAddr();
		pay.setUserIp(userIp);
		int i=payService.insert(pay);
		int id=Integer.parseInt(blogId);
		Blog blog=blogService.findById(id);
		blog.setPayhit(blog.getPayhit()+1);
		int j=blogService.update(blog);
		return i&j;
	}
	
	@RequestMapping("/findByKeyword")
	public String findByKeyword(String keyword,Model model) throws Exception{
		List<Blog> blogList=blogService.findByKeyword(keyword);
		if(blogList!=null){
			for(Blog blog : blogList) {
				List<String> imageList = blog.getImageList();
				String blogInfo = blog.getContent(); //获取博客内容
				Document doc = Jsoup.parse(blogInfo); //将博客内容(网页中也就是一些html)转为jsoup的Document
				Elements jpgs = doc.select("img[src$=.jpg]");//获取<img>标签中所有后缀是.jpg的元素
				Elements pngs = doc.select("img[src$=.png]");
				for(int i = 0; i < jpgs.size(); i++) {
					Element jpg = jpgs.get(i); //获取到单个元素
					imageList.add(jpg.toString()); //把图片信息存到imageList中
					//System.out.println(jpg.toString());
					if(i == 2)
						break; //只存三张图片信息
				}
				for(int i = 0; i < pngs.size(); i++) {
					Element png = pngs.get(i); //获取到单个元素
					imageList.add(png.toString()); //把图片信息存到imageList中
					System.out.println(png.toString());
					if(i == 2)
						break; //只存三张图片信息
				}
			}
		}
		List<Blogger> bloggerList=bloggerService.findTop5Blogger();
		model.addAttribute("blogList",blogList);
		model.addAttribute("top5Blogger", bloggerList);
		return "foreground/blog/wx";	
	}
}
