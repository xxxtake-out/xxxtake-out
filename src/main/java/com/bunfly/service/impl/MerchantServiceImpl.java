package com.bunfly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bunfly.dao.IMerchantDao;
import com.bunfly.model.Menu;
import com.bunfly.model.MenuLimit;
import com.bunfly.model.Merchant;
import com.bunfly.model.Order;
import com.bunfly.model.OrderInfo;
import com.bunfly.service.IMerchantService;
@Service
public class MerchantServiceImpl implements IMerchantService {

	@Resource
	private IMerchantDao dao;
	
	@Override
	public Merchant selectByName(Merchant mer) {
		
		return dao.selectByName(mer);
	}

	@Override
	public void register(Merchant mer) {
		
		dao.register(mer);
	}

	@Override
	public String findp(Merchant mer) {
		
		return dao.findp(mer);
	}

	@Override
	public List<Menu> selectMenu(MenuLimit ml) {
		List<Menu> m = dao.selectMenu(ml);
		for (Menu menu : m) {
			menu.setPageview(pageview(menu));
		}
		
		return m;
	}

	@Override
	public Merchant selectById(int id) {
		
		return dao.selectById(id);
	}

	@Override
	public void upload(Menu menu) {
		
		dao.uploadMenu(menu);
	}

	@Override
	public void updateMenu(Menu menu) {
		
		dao.updateMenu(menu);
	}

	@Override
	public void deleteMenu(int menu) {
		
		dao.deleteMenu(menu);
	}

	@Override
	public int count(int id) {
		
		return dao.count(id);
	}

	@Override
	public int pageview(Menu menu) {
		
		return dao.pageview(menu);
	}

	@Override
	public List<Order> order(int id) {
		
		return dao.order(id);
	}

	@Override
	public OrderInfo selectPid(int mid,int pid,int uid) {
		
		return dao.selectPid(mid, pid, uid);
	}

	@Override
	public void clean(int mid, int pid, int uid) {
		
		dao.clean(mid, pid, uid);
	}

	@Override
	public void addOrderInfo(OrderInfo orderinfo) {
		
		dao.addOrderInfo(orderinfo);
	}

	@Override
	public int allprice(int id) {
		
		return dao.allprice(id);
	}

	@Override
	public int allcount(int id) {
		
		return dao.allcount(id);
	}

	

}
