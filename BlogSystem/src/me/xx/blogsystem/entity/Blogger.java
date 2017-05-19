package me.xx.blogsystem.entity;

public class Blogger {

	private Integer id;

    private String username;

    private String password;

    private String nickname;

    private String sign;

    private String imagename;

    private Integer attention;

    private String profile;
    
    private Integer fans;

    private Integer wordHit;
    
    private Integer chatnum=0;
    
    public Integer getFans() {
		return fans;
	}

	public void setFans(Integer fans) {
		this.fans = fans;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign == null ? null : sign.trim();
    }

    public String getImagename() {
        return imagename;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename == null ? null : imagename.trim();
    }

    public Integer getAttention() {
        return attention;
    }

    public void setAttention(Integer attention) {
        this.attention = attention;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile == null ? null : profile.trim();
    }

	public Integer getWordHit() {
		return wordHit;
	}

	public void setWordHit(Integer wordHit) {
		this.wordHit = wordHit;
	}

	public Integer getChatnum() {
		return chatnum;
	}

	public void setChatnum(Integer chatnum) {
		this.chatnum = chatnum;
	}

	@Override
	public String toString() {
		return "Blogger [id=" + id + ", username=" + username + ", password="
				+ password + ", nickname=" + nickname + ", sign=" + sign
				+ ", imagename=" + imagename + ", attention=" + attention
				+ ", profile=" + profile + ", fans=" + fans + ", wordHit="
				+ wordHit + ", chatnum=" + chatnum + "]";
	}
	
}