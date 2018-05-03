package com.bunfly.model;

public class History {
	
	private int uid;//用户ID
	private int pid;//菜品ID
	private int mid;//商家ID
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public History(int uid, int pid, int mid) {
		super();
		this.uid = uid;
		this.pid = pid;
		this.mid = mid;
	}
	public History() {
		super();
	}
	@Override
	public String toString() {
		return "History [uid=" + uid + ", pid=" + pid + ", mid=" + mid + "]";
	}
	
	
}
