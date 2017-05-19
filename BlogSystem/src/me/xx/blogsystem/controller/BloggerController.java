package me.xx.blogsystem.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import me.xx.blogsystem.entity.Blog;
import me.xx.blogsystem.entity.BlogType;
import me.xx.blogsystem.entity.Blogger;
import me.xx.blogsystem.entity.Fans;
import me.xx.blogsystem.entity.Word;
import me.xx.blogsystem.service.BlogService;
import me.xx.blogsystem.service.BlogTypeService;
import me.xx.blogsystem.service.BloggerService;
import me.xx.blogsystem.service.FansService;
import me.xx.blogsystem.service.WordService;
import me.xx.blogsystem.utils.ResponseUtil;
import net.sf.json.JSONObject;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/blogger")
public class BloggerController {

	@Autowired
	private BloggerService bloggerService;
	
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private BlogTypeService blogTypeService;
	
	@Autowired
	private FansService fansService;
	
	@Autowired
	private WordService wordService;
	
	@RequestMapping("/login")
	public Object login(Blogger blogger,HttpServletRequest request,HttpServletResponse response) throws Exception{
		JSONObject result = new JSONObject();
		Blogger bgr=bloggerService.select(blogger);
		if(bgr!=null&&!bgr.getNickname().equals("")&&!bgr.getPassword().equals("")){
			HttpSession session=request.getSession();
			session.setAttribute("blogger",bgr);
			//session.setAttribute("nickname",blogger.getNickname());
			//session.setAttribute("bloggerId",bgr.getId());
			//System.out.println(bgr);
			result.put("success", true);
			}else{
				result.put("success",false);
				request.setAttribute("msg","��¼ʧ��,�û������������");
			}
		ResponseUtil.write(response, result);
		return null;
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public Object update(MultipartFile imageFile,
			Blogger blogger,
			HttpServletRequest request) throws Exception{
		if(!imageFile.isEmpty()){
			String filePath=request.getSession().getServletContext().getRealPath("/");
			String imageName=UUID.randomUUID()+imageFile.getOriginalFilename().split("\\.")[1];
			System.out.println(imageFile.getOriginalFilename().split("\\.")[1]);
			imageFile.transferTo(new File(filePath+"static/userImages/"+imageName));
			blogger.setImagename(imageName);
		}
		int i=bloggerService.update(blogger);
		return i;
	}
	
	@RequestMapping("/findById")
	public String findById(String id,Model model) throws Exception{
		Blogger blogger=bloggerService.findById(Integer.parseInt(id));
		List<Blog> blogList=blogService.findByBloggerId(Integer.parseInt(id));
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
				System.out.println(png.toString());
				if(i == 2)
					break; //ֻ������ͼƬ��Ϣ
			}
		}
		List<BlogType> blogType=blogTypeService.findByBloggerId(Integer.parseInt(id));
		List<Blog> blogDate=blogService.selectByDate(Integer.parseInt(id));
		model.addAttribute("nowBlogger",blogger);
		model.addAttribute("nowBlog",blogList);
		model.addAttribute("nowBlogType",blogType);
		model.addAttribute("blogDate",blogDate);
		return "forward:/foreground/blogger/blogger.jsp";
	}
	
	@RequestMapping("/updateAttention")
	@ResponseBody
	public Object updateAttention(String bloggerId,String fans,String flag,HttpServletRequest request) throws Exception{
		int id=Integer.parseInt(bloggerId);
		int fansNum=Integer.parseInt(fans);
		int i=0;
		Fans fan=new Fans();
		fan.setBloggerId(id);
		String userIp=request.getRemoteAddr();
		fan.setUserIp(userIp);
		if(flag.equals("��ע")){
			i=fansService.insert(fan);
		}else if(flag.equals("ȡ����ע")){
			i=fansService.deleteByIp(userIp);
		}
		Blogger blogger=new Blogger();
		blogger.setId(id);
		blogger.setFans(fansNum);
		int j=bloggerService.update(blogger);
		return i&j;
	}
	
	@RequestMapping("/updateWord")
	@ResponseBody
	public Object updateWord(Word word,String bloggerId,String imageCode,String wordHit,HttpServletRequest request) throws Exception{
		int i=0;
		int j=0;
		String sRand=(String) request.getSession().getAttribute("sRand");
		String userIp=request.getRemoteAddr();
		word.setUserip(userIp);
		Blogger blogger=new Blogger();
		blogger.setId(Integer.parseInt(bloggerId));
		blogger.setWordHit(Integer.parseInt(wordHit)+1);
		if(sRand.equals(imageCode)){
			i=wordService.insert(word);
			j=bloggerService.update(blogger);
		}
		return i&j;
	}
	
	@RequestMapping("/insert")
	public String insert(Blogger blogger,String imageCode,Model model,HttpSession session) throws Exception{
		
		String code=(String) session.getAttribute("sRand");
		if(code.equals(imageCode)){
			model.addAttribute("nickname",blogger.getNickname());
			bloggerService.insert(blogger);
			return "success";
		}else{
			model.addAttribute("msg","��֤��������������д");
			return "register";
		}
	}

	@RequestMapping("/modifyPassword")
	public String modifyPassword(Blogger blogger,HttpServletResponse response) throws Exception{
		int i=bloggerService.update(blogger);
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
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}

}
