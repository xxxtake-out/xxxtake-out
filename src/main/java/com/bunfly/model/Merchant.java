package com.bunfly.model;

import java.util.List;

public class Merchant {

	private int mid;
	private String username;
	private String password;
	private int cid;
	private int hid;
	private List<Menu> menu;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
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
	public List<Menu> getMenu() {
		return menu;
	}
	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}
	public Merchant(int mid, String username, String password, int cid, int hid, List<Menu> menu) {
		super();
		this.mid = mid;
		this.username = username;
		this.password = password;
		this.cid = cid;
		this.hid = hid;
		this.menu = menu;
	}
	public Merchant() {
		super();
	}
	@Override
	public String toString() {
		return "Merchant [mid=" + mid + ", username=" + username + ", password=" + password + ", cid=" + cid + ", menu="
				+ menu + "]";
	}
	public int getHid() {
		return hid;
	}
	public void setHid(int hid) {
		this.hid = hid;
	}
	
}
