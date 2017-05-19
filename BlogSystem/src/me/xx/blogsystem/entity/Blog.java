package me.xx.blogsystem.entity;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Blog {
    private Integer id;
    
	private Integer blogTypeId;
    
    private Integer bloggerId;
    
    private String title;

    private String summary;

    private Date releasedate;

    private Integer clickhit;

    private Integer replyhit;

    private Integer goodhit;

    private Integer payhit;

    private String keyword;
    
    private String content;
    
    private BlogType blogType; //博客类型
    private Blogger blogger;
	private Integer blogCount; //博客数量
	private String releaseDateStr;
	
	private List<String> imageList = new LinkedList<String>();//博客里存放的图片

	
	  public Integer getBlogTypeId() {
	 		return blogTypeId;
	 	}


	 	public void setBlogTypeId(Integer blogTypeId) {
	 		this.blogTypeId = blogTypeId;
	 	}


	 	public Integer getBloggerId() {
	 		return bloggerId;
	 	}


	 	public void setBloggerId(Integer bloggerId) {
	 		this.bloggerId = bloggerId;
	 	}
		public Blogger getBlogger() {
			return blogger;
		}


		public void setBlogger(Blogger blogger) {
			this.blogger = blogger;
		}

    public BlogType getBlogType() {
		return blogType;
	}


	public void setBlogType(BlogType blogType) {
		this.blogType = blogType;
	}

	public Integer getBlogCount() {
		return blogCount;
	}

	public void setBlogCount(Integer blogCount) {
		this.blogCount = blogCount;
	}

	public String getReleaseDateStr() {
		return releaseDateStr;
	}

	public void setReleaseDateStr(String releaseDateStr) {
		this.releaseDateStr = releaseDateStr;
	}

	public List<String> getImageList() {
		return imageList;
	}

	public void setImageList(List<String> imageList) {
		this.imageList = imageList;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public Date getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(Date releasedate) {
        this.releasedate = releasedate;
    }

    public Integer getClickhit() {
        return clickhit;
    }

    public void setClickhit(Integer clickhit) {
        this.clickhit = clickhit;
    }

    public Integer getReplyhit() {
        return replyhit;
    }

    public void setReplyhit(Integer replyhit) {
        this.replyhit = replyhit;
    }

    public Integer getGoodhit() {
        return goodhit;
    }

    public void setGoodhit(Integer goodhit) {
        this.goodhit = goodhit;
    }

    public Integer getPayhit() {
        return payhit;
    }

    public void setPayhit(Integer payhit) {
        this.payhit = payhit;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }


	@Override
	public String toString() {
		return "Blog [id=" + id + ", blogTypeId=" + blogTypeId + ", bloggerId="
				+ bloggerId + ", title=" + title + ", summary=" + summary
				+ ", releasedate=" + releasedate + ", clickhit=" + clickhit
				+ ", replyhit=" + replyhit + ", goodhit=" + goodhit
				+ ", payhit=" + payhit + ", keyword=" + keyword + ", content="
				+ content + ", blogType=" + blogType + ", blogger=" + blogger
				+ ", blogCount=" + blogCount + ", releaseDateStr="
				+ releaseDateStr + ", imageList=" + imageList + "]";
	}
    
}