package me.xx.blogsystem.entity;

import java.util.Date;

public class Good {
    private Integer id;

    private Date gooddate;

    private Integer blogId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getGooddate() {
        return gooddate;
    }

    public void setGooddate(Date gooddate) {
        this.gooddate = gooddate;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }
}