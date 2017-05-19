package me.xx.blogsystem.entity;

import java.util.Date;

public class TComment {
    private Integer id;

    private Integer blogId;
  

	public Integer getBlogId() {
		return blogId;
	}

	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}

	private String userip;

    private String content;

    private Date commentdate;

    private Integer state;

    private Blog blog;

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

    public Date getCommentdate() {
        return commentdate;
    }

    public void setCommentdate(Date commentdate) {
        this.commentdate = commentdate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	@Override
	public String toString() {
		return "TComment [id=" + id + ", blogId=" + blogId + ", userip="
				+ userip + ", content=" + content + ", commentdate="
				+ commentdate + ", state=" + state + ", blog=" + blog + "]";
	}
	

}