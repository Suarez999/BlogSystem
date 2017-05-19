package me.xx.blogsystem.service;

import me.xx.blogsystem.entity.Fans;

public interface FansService extends BaseService<Fans>{
	Fans findByIp(String userIp) throws Exception;
	Integer deleteByIp(String userIp) throws Exception;
}
