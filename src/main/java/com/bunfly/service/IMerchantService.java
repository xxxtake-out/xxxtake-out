package com.bunfly.service;

import java.util.List;

import com.bunfly.model.Menu;
import com.bunfly.model.MenuLimit;
import com.bunfly.model.Merchant;
import com.bunfly.model.Order;
import com.bunfly.model.OrderInfo;

public interface IMerchantService {

	//����id�����̼�
	Merchant selectById(int id);
	//�����û��������̼�
	Merchant selectByName(Merchant mer);
	//�̼�ע��
	void register(Merchant mer);
	//�����û��ṩ����Ϣ�һ�����
	String findp(Merchant mer);
	//�����̼�id��ѯ�����̼ҵ�������Ʒ
	List<Menu> selectMenu(MenuLimit ml);
	//�ϴ���Ʒ
	void upload(Menu menu);
	//�޸���Ʒ��Ϣ
	void updateMenu(Menu menu);
	//ɾ����Ʒ
	void deleteMenu(int menu);
	//�鿴��Ʒ����
	int count(int id);
	//��Ʒ�����
	int pageview(Menu menu);
	//��ѯ����
	List<Order> order(int id);
	//��ѯ����id
	OrderInfo selectPid(int mid,int pid,int uid);
	//ɾ������
	void clean(int mid,int pid,int uid);
	//�Ƿ���ܶ���
	void addOrderInfo(OrderInfo orderinfo);
	//��ѯ�����ܶ�
	int allprice(int id);
	//��ѯ������
	int allcount(int id);
}
