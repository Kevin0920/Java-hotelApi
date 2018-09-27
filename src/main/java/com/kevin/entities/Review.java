package com.kevin.entities;


public class Review {
	
	private String userName;
	private int rating;
	private int ratingCount;
	private Boolean approved;
	
	
	protected Review() {

	}
	
	public Review(String userName, int rating, int ratingCount, Boolean approved) {
		super();
		this.userName = userName;
		this.rating = rating;
		this.ratingCount = ratingCount;
		this.approved = approved;
	}
	public int getRatingCount() {
		return ratingCount;
	}

	public void setRatingCount(int ratingCount) {
		this.ratingCount = ratingCount;
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
