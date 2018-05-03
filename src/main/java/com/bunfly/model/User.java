package com.bunfly.model;

public class User {

	
	private int uid;//用户ID
	private String username;//用户名
	private String password;//密码
	private int cid;//验证信息
	private int hid;//头像识别码
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getHid() {
		return hid;
	}
	public void setHid(int hid) {
		this.hid = hid;
	}
	public User(int uid, String username, String password, int cid, int hid) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.cid = cid;
		this.hid = hid;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", cid=" + cid + ", hid="
				+ hid + "]";
	}
	
	
	
}
