package com.bunfly.model;

public class Review {

	
	private int id;//评论ID
	private int pname;//菜品
	private int uid;//用户ID
	private String review;//评论
	private String reviewtime;//评论时间
	private int mid;//商家ID
	private String Return;//回复
	private String Returntime;//回复时间
	public Review(int id, int pname, int uid, String review, String reviewtime, int mid, String return1,
			String returntime) {
		super();
		this.id = id;
		this.pname = pname;
		this.uid = uid;
		this.review = review;
		this.reviewtime = reviewtime;
		this.mid = mid;
		Return = return1;
		Returntime = returntime;
	}
	public Review() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPname() {
		return pname;
	}
	public void setPname(int pname) {
		this.pname = pname;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public String getReviewtime() {
		return reviewtime;
	}
	public void setReviewtime(String reviewtime) {
		this.reviewtime = reviewtime;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getReturn() {
		return Return;
	}
	public void setReturn(String return1) {
		Return = return1;
	}
	public String getReturntime() {
		return Returntime;
	}
	public void setReturntime(String returntime) {
		Returntime = returntime;
	}
	@Override
	public String toString() {
		return "Review [id=" + id + ", pname=" + pname + ", uid=" + uid + ", review=" + review + ", reviewtime="
				+ reviewtime + ", mid=" + mid + ", Return=" + Return + ", Returntime=" + Returntime + "]";
	}
	
	
}
