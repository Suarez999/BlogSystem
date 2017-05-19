package me.xx.blogsystem.entity;

import java.util.Date;

public class Pay {
    private Integer id;

    private String userIp;
    
    private String paymoney;

    private Date paydate;

    private Integer blogId;

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



    public String getPaymoney() {
        return paymoney;
    }

    public void setPaymoney(String paymoney) {
        this.paymoney = paymoney == null ? null : paymoney.trim();
    }

    public Date getPaydate() {
        return paydate;
    }

    public void setPaydate(Date paydate) {
        this.paydate = paydate;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }
}