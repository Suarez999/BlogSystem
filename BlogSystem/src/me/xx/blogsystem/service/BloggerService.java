package me.xx.blogsystem.service;

import java.util.List;

import me.xx.blogsystem.entity.Blogger;

public interface BloggerService extends BaseService<Blogger>{

	List<Blogger> findTop5Blogger() throws Exception;
}
