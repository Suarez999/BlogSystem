package me.xx.blogsystem.entity;

import java.util.Date;

public class Word {
    private Integer id;

    private String userip;

    private String content;

    private Date worddate;

    private Integer state;

    private Integer bloggerId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserip() {
        return userip;
    }

    public void setUserip(String userip) {
        this.userip = userip == null ? null : userip.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getWorddate() {
        return worddate;
    }

    public void setWorddate(Date worddate) {
        this.worddate = worddate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

	public Integer getBloggerId() {
		return bloggerId;
	}

	public void setBloggerId(Integer bloggerId) {
		this.bloggerId = bloggerId;
	}

}