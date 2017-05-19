package me.xx.blogsystem.dao;

import java.util.List;

import me.xx.blogsystem.entity.Blogger;

public interface BloggerMapper extends BaseMapper<Blogger>{

	List<Blogger> findTop5Blogger();
}