package com.orders.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.orders.dao.OrdersDao;
import com.orders.entity.Orders;
import com.orders.entity.Ordersdetails;
import com.user.entity.User;

@Service
public class OrdersService {
	@Resource
	private OrdersDao ordersdao;

	public OrdersDao getOrdersdao() {
		return ordersdao;
	}

	public void setOrdersdao(OrdersDao ordersdao) {
		this.ordersdao = ordersdao;
	}
	
	public void add(int productid,String name,Double price,int count,HttpSession session1,String date,int state){
		ordersdao.insert(productid, name, price, count,session1,date,state);
	}
	public List<Orders> get(HttpSession session1,int state){
		User user = (User)session1.getAttribute("u");
		List<Orders> list = ordersdao.get(session1,state);
		List<Orders> list1 = new ArrayList<Orders>();
		Iterator<Orders> i = list.iterator();
		while(i.hasNext()){
			 Orders o = (Orders)i.next();
			 String address = o.getUser().getAddress();
			 if(address.equals(user.getAddress())){
				 list1.add(o);
			 }
		}
		return list1;
	}
	
	public void xiaorders(String date){
		ordersdao.xiaorders(date);
	}
	
	public void del(int productid,String date,int state){
		ordersdao.del(productid, date, state);
	}
	
	public void addshouhuo(Ordersdetails od){
		ordersdao.addshouhuo(od);
	}
}
