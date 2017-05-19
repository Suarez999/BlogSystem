package me.xx.blogsystem.dao;

import me.xx.blogsystem.entity.Fans;

public interface FansMapper extends BaseMapper<Fans>{
	Fans findByIp(String userIp);
	
	Integer deleteByIp(String userIp);
}
