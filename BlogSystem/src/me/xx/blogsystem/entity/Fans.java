package me.xx.blogsystem.entity;

import java.util.Date;

public class Fans {
	private Integer id;
	
	private String userIp;
	
	private Date attentionDate;
	
	private Integer bloggerId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserIp() {
		return userIp;
	}
	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}
	public Date getAttentionDate() {
		return attentionDate;
	}
	public void setAttentionDate(Date attentionDate) {
		this.attentionDate = attentionDate;
	}
	public Integer getBloggerId() {
		return bloggerId;
	}
	public void setBloggerId(Integer bloggerId) {
		this.bloggerId = bloggerId;
	}
	
	
}
