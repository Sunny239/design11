package com.background.dorders.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.background.dorders.service.DordersService;
import com.orders.entity.DigOrders;
import com.orders.entity.Orders;
import com.orders.entity.Ordersdetails;

@Controller
@RequestMapping("/dorders")
public class DodersController {

	@Resource
	private DordersService dordersservice;
	
	@RequestMapping(value="/findall",method=RequestMethod.GET)
	public String findAll(HttpSession session){
		List<DigOrders> li = new ArrayList<DigOrders>();
		
		List<Ordersdetails> list = dordersservice.findAll();		
		Iterator<Ordersdetails> i = list.iterator();
		while(i.hasNext()){
			Ordersdetails od = i.next();
			String useraddress = od.getUseraddress();
			String date = od.getDate();
			System.out.println(useraddress+" "+date);
			List<Orders> list1 = dordersservice.findAll1();
			Iterator<Orders> i1 = list1.iterator();
			while(i1.hasNext()){
				Orders o = i1.next();
				String useraddress1 = o.getUser().getAddress();
				String date1 = o.getDate();
					if(useraddress.equals(useraddress1)&&date.equals(date1)){
							DigOrders d = new DigOrders();
							d.setUseraddress(useraddress1);
							d.setConsignee(od.getConsignee());
							d.setRegion(od.getRegion());
							d.setAddresss(od.getAddresss());
							d.setName(o.getName());
							d.setPrice(o.getPrice());
							d.setCount(o.getCount());
							d.setDate(o.getDate());
							d.setPhone(od.getPhone());
							li.add(d);
					}
			}
		}
		session.setAttribute("list6", li);
		return "bgorders";
	}
	
	@RequestMapping(value="/findfinish",method=RequestMethod.GET)
	public String findfinish(HttpSession session,@RequestParam("state") int state){
		List<DigOrders> li = new ArrayList<DigOrders>();
		
		List<Ordersdetails> list = dordersservice.findAll();		
		Iterator<Ordersdetails> i = list.iterator();
		while(i.hasNext()){
			Ordersdetails od = i.next();
			String useraddress = od.getUseraddress();
			String date = od.getDate();
			System.out.println(useraddress+" "+date);
			List<Orders> list1 = dordersservice.findAll1();
			Iterator<Orders> i1 = list1.iterator();
			while(i1.hasNext()){
				Orders o = i1.next();
				String useraddress1 = o.getUser().getAddress();
				String date1 = o.getDate();
					if(useraddress.equals(useraddress1)&&date.equals(date1)){
						if(o.getState()==state){
							DigOrders d = new DigOrders();
							d.setUseraddress(useraddress1);
							d.setConsignee(od.getConsignee());
							d.setRegion(od.getRegion());
							d.setAddresss(od.getAddresss());
							d.setName(o.getName());
							d.setPrice(o.getPrice());
							d.setCount(o.getCount());
							d.setDate(o.getDate());
							d.setPhone(od.getPhone());
							li.add(d);
						}						
					}
			}
		}
		if(state==1){
			session.setAttribute("state","已完成");
		}else{
			session.setAttribute("state","未完成");
		}
		session.setAttribute("list7", li);
		return "bgorders1";
	}
	
	@RequestMapping(value="/del",method=RequestMethod.GET)
	public String del(@RequestParam("useraddress") String useraddress,
				@RequestParam("date") String date){
		dordersservice.del(useraddress, date);
		
		return "forward:findall";
	}
	
	@RequestMapping(value="/selectorders",method=RequestMethod.GET)
	public String selectorders(@RequestParam("selectorders") String selectorders,
				HttpSession session){
		List<DigOrders> li = new ArrayList<DigOrders>();
		
		List<Orders> list = dordersservice.selectorders(selectorders);
		Iterator<Orders> i = list.iterator();
		while(i.hasNext()){
			Orders o = i.next();
			String useraddress = o.getUser().getAddress();
			String date = o.getDate();
			
			List<Ordersdetails> list1 = dordersservice.findAll();
			Iterator<Ordersdetails> i1 = list1.iterator();
			while(i1.hasNext()){
				Ordersdetails od = i1.next();
				String useraddress1 = od.getUseraddress();
				String date1 = od.getDate();
				if(useraddress1.equals(useraddress) && date1.equals(date)){
					DigOrders d = new DigOrders();
					d.setUseraddress(useraddress1);
					d.setConsignee(od.getConsignee());
					d.setRegion(od.getRegion());
					d.setAddresss(od.getAddresss());
					d.setName(o.getName());
					d.setPrice(o.getPrice());
					d.setCount(o.getCount());
					d.setDate(o.getDate());
					d.setPhone(od.getPhone());
					li.add(d);
				}
			}
		}
		session.setAttribute("list9", li);
		return "bgorders2";
	}
}
