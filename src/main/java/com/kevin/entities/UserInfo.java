package com.kevin.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
public class UserInfo {
	@Id
	private String id;
	private String name;
	private String blogUrl;
	
	@Indexed(direction = IndexDirection.ASCENDING)
	private Integer visit_count;
	
	private List<Interest> interests;
	private Date accountCreatedTime;
	
	public UserInfo(String id, String name, String blogUrl, Integer visit_count, List<Interest> interests,
			Date accountCreatedTime) {
		super();
		this.id = id;
		this.name = name;
		this.blogUrl = blogUrl;
		this.visit_count = visit_count;
		this.interests = interests;
		this.accountCreatedTime = accountCreatedTime;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBlogUrl() {
		return blogUrl;
	}
	public void setBlogUrl(String blogUrl) {
		this.blogUrl = blogUrl;
	}
	public Integer getVisit_count() {
		return visit_count;
	}
	public void setVisit_count(Integer visit_count) {
		this.visit_count = visit_count;
	}
	public List<Interest> getInterests() {
		return interests;
	}
	public void setInterests(List<Interest> interests) {
		this.interests = interests;
	}
	public Date getAccountCreatedTime() {
		return accountCreatedTime;
	}
	public void setAccountCreatedTime(Date accountCreatedTime) {
		this.accountCreatedTime = accountCreatedTime;
	}

   @Override
   public String toString() {
       return String.format("UserInfo{name='%s', blogUrl='%s', visit_count=%d,interests='%s'}\n",
               name, blogUrl, visit_count, interests);
   }

	
}
