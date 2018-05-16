package com.bunfly.model;

public class OrderInfo {

	
	private int uid;//鐢ㄦ埛ID
	private String username;//鐢ㄦ埛鍚�
	private int mid;//鍟嗗ID
	private int pid;//鑿滃搧ID
	private String pname;//鑿滃悕
	private String comment;//澶囨敞
	private String time;//鏃堕棿鎴�
	private int phonenumber;//鐢ㄦ埛鑱旂郴鏂瑰紡
	private String addr;//鐢ㄦ埛鍦板潃
	private int price;//浠锋牸
	private String oid = null ;//璁㈠崟ID
	private int affirm;//閫夋嫨
	
	
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
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public int getAffirm() {
		return affirm;
	}
	public void setAffirm(int affirm) {
		this.affirm = affirm;
	}
	public OrderInfo(int uid, String username, int mid, int pid, String pname, String comment, String time,
			int phonenumber, String addr, int price, String oid, int affirm) {
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
		this.oid = oid;
		this.affirm = affirm;
	}
	public OrderInfo() {
		super();
	}
	@Override
	public String toString() {
		return "OrderInfo [uid=" + uid + ", username=" + username + ", mid=" + mid + ", pid=" + pid + ", pname=" + pname
				+ ", comment=" + comment + ", time=" + time + ", phonenumber=" + phonenumber + ", addr=" + addr
				+ ", price=" + price + ", oid=" + oid + ", affirm=" + affirm + "]";
	}
	
	
}
