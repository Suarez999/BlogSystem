package me.xx.blogsystem.entity;

import java.util.Date;

public class Chat {

	private Integer id;
	
	private String userIp;
	
	private String content;
	
	private Date chatDate;
	
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getChatDate() {
		return chatDate;
	}

	public void setChatDate(Date chatDate) {
		this.chatDate = chatDate;
	}

	public Integer getBloggerId() {
		return bloggerId;
	}

	public void setBloggerId(Integer bloggerId) {
		this.bloggerId = bloggerId;
	}

	@Override
	public String toString() {
		return "Chat [id=" + id + ", userIp=" + userIp + ", content=" + content
				+ ", chatDate=" + chatDate + ", bloggerId=" + bloggerId + "]";
	}
	
}
