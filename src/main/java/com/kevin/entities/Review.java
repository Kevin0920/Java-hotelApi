package com.kevin.entities;


public class Review {
	
	private String userName;
	private int rating;
	private Boolean approved;
	
	
	protected Review() {

	}
	
	public Review(String userName, int rating, Boolean approved) {
		super();
		this.userName = userName;
		this.rating = rating;
		this.approved = approved;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Boolean getApproved() {
		return approved;
	}
	public void setApproved(Boolean approved) {
		this.approved = approved;
	}
	
	

}
