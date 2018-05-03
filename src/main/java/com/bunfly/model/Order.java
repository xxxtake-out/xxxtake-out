package com.bunfly.model;

public class Order {

	private int uid;//用户ID
	private String username;//用户名
	private int mid;//商家ID
	private int pid;//菜品ID
	private String pname;//菜名
	private String comment;//备注
	private String time;//时间戳
	private int phonenumber;//用户联系方式
	private String addr;//用户地址
	private int price;//价格
	public Order(int uid, String username, int mid, int pid, String pname, String comment, String time, int phonenumber,
			String addr, int price) {
		super();
		this.uid = uid;
		this.username = username;
		this.mid = mid;
		this.pid = pid;
		this.pname = pname;
		this.comment = comment;
		this.time = time;
		this.phonenumber = phonenumber;
		this.addr = addr;
		this.price = price;
	}
	public Order() {
		super();
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Order [uid=" + uid + ", username=" + username + ", mid=" + mid + ", pid=" + pid + ", pname=" + pname
				+ ", comment=" + comment + ", time=" + time + ", phonenumber=" + phonenumber + ", addr=" + addr
				+ ", price=" + price + "]";
	}
	
	
}
