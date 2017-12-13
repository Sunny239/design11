package com.background.dorders.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.background.dorders.dao.DordersDao;
import com.orders.entity.Orders;
import com.orders.entity.Ordersdetails;

@Service
public class DordersService {

	@Resource
	private DordersDao dordersdao;
	
	public List<Ordersdetails> findAll(){
		return dordersdao.findAll();
	}
	
	public List<Orders> findAll1(){
		return dordersdao.findAll1();
	}
	public void del(String useraddress,String date){
		dordersdao.del(useraddress, date);
	}
	public List<Orders> selectorders(String selectorders){
		return dordersdao.selectorders(selectorders);
	}
}
