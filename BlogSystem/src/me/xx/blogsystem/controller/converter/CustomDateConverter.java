package me.xx.blogsystem.controller.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class CustomDateConverter implements Converter<String,Date>{

	public Date convert(String arg0) {
		
		try{
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(arg0);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
}
