package com.bunfly.model;

import java.util.List;

public class MenuLimit {

	private int id;
	private int pagesize = 3;
	private int page;
	private int count;
	private int pages;
	private List<Menu> list;
	public MenuLimit(int id, int pagesize, int page, int count, int pages, List<Menu> list) {
		super();
		this.id = id;
		this.pagesize = pagesize;
		this.page = page;
		this.count = count;
		this.pages = pages;
		this.list = list;
	}
	public MenuLimit() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	
	public List<Menu> getList() {
		return list;
	}
	public void setList(List<Menu> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "MenuLimit [id=" + id + ", pagesize=" + pagesize + ", page=" + page + ", count=" + count + ", pages="
				+ pages + ", list=" + list + "]";
	}
	
}
