package com.bunfly.model;

public class Menu {

	private int pid;
	private String pname;
	private int mid;
	private int kid;
	private int price;
	private int hid;
	private Merchant mname;
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
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getKid() {
		return kid;
	}
	public void setKid(int kid) {
		this.kid = kid;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getHid() {
		return hid;
	}
	public void setHid(int hid) {
		this.hid = hid;
	}
	public Merchant getMname() {
		return mname;
	}
	public void setMname(Merchant mname) {
		this.mname = mname;
	}
	public Menu(int pid, String pname, int mid, int kid, int price, int hid, Merchant mname) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.mid = mid;
		this.kid = kid;
		this.price = price;
		this.hid = hid;
		this.mname = mname;
	}
	public Menu() {
		super();
	}
	@Override
	public String toString() {
		return "Menu [pid=" + pid + ", pname=" + pname + ", mid=" + mid + ", kid=" + kid + ", price=" + price + ", hid="
				+ hid + ", mname=" + mname + "]";
	}
	
}
