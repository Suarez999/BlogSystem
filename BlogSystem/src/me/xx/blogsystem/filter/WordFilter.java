package me.xx.blogsystem.filter;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import me.xx.blogsystem.entity.SensitiveWord;
import me.xx.blogsystem.service.SensitiveWordService;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.OncePerRequestFilter;

public class WordFilter extends OncePerRequestFilter{

	 protected void doFilterInternal(HttpServletRequest request,
	            HttpServletResponse response, FilterChain chain)
	            throws ServletException, IOException {
			
	        chain.doFilter(new StringFilterRequest((HttpServletRequest)request), response);
	    }

}

class StringFilterRequest extends HttpServletRequestWrapper {
	
    public StringFilterRequest(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String name) {
 		// 返回值之前 先进行过滤
        return filterDangerString(super.getParameter(name));
    }

    @Override
    public String[] getParameterValues(String name) {
        // 返回值之前 先进行过滤
        String[] values = super.getParameterValues(name);
        if(values==null){
            return null;
        }
        for (int i = 0; i < values.length; i++) {
            values[i] = filterDangerString(values[i]);
        }

        return values;
    }

    @Override
    public Map getParameterMap() {
        Map keys = super.getParameterMap();
        Set set = keys.entrySet();
        Iterator iters = set.iterator();
        while (iters.hasNext()) {
            Object key = iters.next();
            Object value = keys.get(key);
            keys.put(key, filterDangerString((String[]) value));
        }
        return keys;
    }

    /*@Override
    public Object getAttribute(String name) {
        // TODO Auto-generated method stub
        Object object = super.getAttribute(name);
        if (object instanceof String) {
            return filterDangerString((String) super.getAttribute(name));
        } else
            return object;
    }*/

    public String filterDangerString(String value) {

        if (value == null) {
            return null;
        }
        
    	ServletContext context=super.getSession().getServletContext();
 		ApplicationContext ctx=WebApplicationContextUtils.getRequiredWebApplicationContext(context);
 		SensitiveWordService sensitiveWordService=(SensitiveWordService) ctx.getBean("sensitiveWordService");
        try {
			List<SensitiveWord> wordList=sensitiveWordService.findAll();
			for(SensitiveWord word:wordList){
				value=value.replaceAll(word.getWord(),"**");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
//        value = value.replaceAll("\\{", "｛");
//        // content = content.replaceAll("&", "&amp;");
//        value = value.replaceAll("<", "&lt;");
//        value = value.replaceAll(">", "&gt;");
//        value = value.replaceAll("\t", "    ");
//        value = value.replaceAll("\r\n", "\n");
//        value = value.replaceAll("\n", "<br/>");
//        value = value.replaceAll("'", "&#39;");
//        value = value.replaceAll("\\\\", "&#92;");
//        value = value.replaceAll("\"", "&quot;");
//        value = value.replaceAll("\\}", "﹜").trim();
//        value=value.replaceAll("二五","*");
        return value;
    }
   
    public String[] filterDangerString(String[] value) {
        if (value == null) {
            return null;
        }
        for (int i = 0; i < value.length; i++) {
            String val = filterDangerString(value[i]);
            value[i] = val;
        }

        return value;
    }

}