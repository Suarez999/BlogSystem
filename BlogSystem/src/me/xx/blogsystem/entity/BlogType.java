package me.xx.blogsystem.entity;

public class BlogType {
    private Integer id;

    private String typename;

    private Integer ordernum;
    
    private Integer blogCount; 
    
    private Blog blog;//¹ØÁª²éÑ¯blog

    public Integer getBlogCount() {
		return blogCount;
	}

	public void setBlogCount(Integer blogCount) {
		this.blogCount = blogCount;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    public Integer getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(Integer ordernum) {
        this.ordernum = ordernum;
    }

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	@Override
	public String toString() {
		return "BlogType [id=" + id + ", typename=" + typename + ", ordernum="
				+ ordernum + ", blogCount=" + blogCount + ", blog=" + blog
				+ "]";
	}


    
}