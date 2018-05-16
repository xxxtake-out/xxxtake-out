package com.bunfly.dao;

import java.util.List;

import com.bunfly.model.Menu;
import com.bunfly.model.MenuLimit;
import com.bunfly.model.Merchant;
import com.bunfly.model.Order;
import com.bunfly.model.OrderInfo;

public interface IMerchantDao {

	//根基id查找商家
	Merchant selectById(int id);
	//根据用户名查找商家
	Merchant selectByName(Merchant mer);
	//商家注册
	void register(Merchant mer);
	//根据用户提供的信息找回密码
	String findp(Merchant mer);
	//根据商家id查询该商家的所有商品
	List<Menu> selectMenu(MenuLimit ml);
	//上传商品
	void uploadMenu(Menu menu);
	//修改数据
	void updateMenu(Menu menu);
	//删除商品
	void deleteMenu(int menu);
	//查看商品总条数
	int count(int id);
	//查询商品浏览量
	int pageview(Menu menu);
	//查询订单表
	List<Order> order(int id);
	//查询单条待处理订单
	OrderInfo selectPid(int mid, int pid, int uid);
	//删除待处理订单
	void clean(int mid, int pid, int uid);
	//是否接受订单
	void addOrderInfo(OrderInfo orderinfo);
	//查询交易总额
	int allprice(int id);
	//查询交易量
	int allcount(int id);
}
