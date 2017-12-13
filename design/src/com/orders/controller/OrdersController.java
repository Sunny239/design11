package com.orders.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cart.entity.CartItem;
import com.cart.service.Cart;
import com.orders.entity.Orders;
import com.orders.entity.Ordersdetails;
import com.orders.service.OrdersService;
import com.user.entity.User;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

@Controller
@RequestMapping("/orders")
public class OrdersController {

	@Resource
	private OrdersService ordersservice;
	
	
	public OrdersService getOrdersservice() {
		return ordersservice;
	}


	public void setOrdersservice(OrdersService ordersservice) {
		this.ordersservice = ordersservice;
	}


	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(HttpSession session,@RequestParam("useraddress") String useraddress){
		List list = new ArrayList();
		
		User u = (User)session.getAttribute("u");		
		Cart c = (Cart)session.getAttribute("cart");
		if(c.getContainer().size()==0||c==null){
			JOptionPane.showMessageDialog(null, "您的购物车为空，不能生成订单!");
			return "checkout1";
		}else{
			Iterator i = c.container.values().iterator();
			while(i.hasNext()){
				CartItem ci = (CartItem)i.next();
				int productid = ci.getProduct().getId();
				String name= ci.getProduct().getName();
				Double price  = ci.getProduct().getPrice();
				int count = ci.getCount();
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String date = df.format(new Date());
				int state = 0;
				session.setAttribute("date", date);
				ordersservice.add(productid, name, price, count, session,date,state);
				list.add(ci);
			}
			session.setAttribute("list1", list);		
			return "orders";
		}

	}
	
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public String get(HttpSession session1,@RequestParam("state") int state){
		List<Orders> list = ordersservice.get(session1,state);
		session1.setAttribute("list",list);
		return "vipOrder";
	}
	@RequestMapping(value="/get1",method=RequestMethod.GET)
	public String get1(HttpSession session1,@RequestParam("state") int state){
		List<Orders> list = ordersservice.get(session1,state);
		session1.setAttribute("list",list);
		return "vipunOrder";
	}
	
	/*@RequestMapping(value="/checkorders",method=RequestMethod.GET)
	public String checkorders(HttpSession session){
		User u = (User)session.getAttribute("u");
		if(u==null){
			JOptionPane.showMessageDialog(null, "您还没有登录!");
			return "index";
		}else{
			return "vipOrder";
		}
	}
	
	@RequestMapping(value="/editorders",method=RequestMethod.GET)
	public String editorders(HttpSession session,@RequestParam("productId") String productId){
		
		Cart c = (Cart)session.getAttribute("cart");
		//CartItem ci = c.container.get(new Integer(productId));
		c.getContainer().remove(new Integer(productId));
		
		
		return "checkout1";
	}
	
	@RequestMapping(value="/del",method=RequestMethod.GET)
	public String del(HttpSession session){
		Cart c = (Cart)session.getAttribute("cart");
		Iterator<Map.Entry<Integer, CartItem>> i= c.container.entrySet().iterator();
		while(i.hasNext()){
			Map.Entry<Integer,CartItem> entry = i.next();
			i.remove();
			
		}
		return "checkout1";
	}*/
	
	
	@RequestMapping(value="/xiaorders",method=RequestMethod.GET)
	public String xiaorders(HttpSession session){
		/*List list = new ArrayList();
		
		User u = (User)session.getAttribute("u");		
		Cart c = (Cart)session.getAttribute("cart");
		Iterator i = c.container.values().iterator();
		while(i.hasNext()){
			CartItem ci = (CartItem)i.next();
			int productid = ci.getProduct().getId();
			String name= ci.getProduct().getName();
			Double price  = ci.getProduct().getPrice();
			int count = ci.getCount();
			//ordersservice.add(productid, name, price, count, session);
		}*/	
		
		List li = (List)session.getAttribute("list1");
		Iterator i = li.iterator();
		while(i.hasNext()){
			CartItem ci = (CartItem)i.next();
			String date=(String)session.getAttribute("date");
			ordersservice.xiaorders(date);
		}
		return "final";
	}
	@RequestMapping(value="/del",method=RequestMethod.GET)
	public String del(@RequestParam("productId") int productid,
				@RequestParam("date") String date,
				@RequestParam("state") int state
			){
		ordersservice.del(productid, date, state);
		
		return "forward:get1";
	}
	@RequestMapping(value="/shouhuodizhi",method=RequestMethod.POST)
	public String addshouhuo(@RequestParam("consignee") String consignee,
				@RequestParam("region") String region,
				@RequestParam("addresss") String addresss,
				@RequestParam("phone") String phone,
				HttpSession session1){
		System.out.println("1111111111111111111111");
		String date = (String)session1.getAttribute("date");
		User u = (User)session1.getAttribute("u");
		Ordersdetails od = new Ordersdetails();
		od.setUseraddress(u.getAddress());
		od.setDate(date);
		od.setConsignee(consignee);
		od.setRegion(region);
		od.setAddresss(addresss);
		od.setPhone(phone);
		session1.setAttribute("od", od);
		ordersservice.addshouhuo(od);
		return "orders";
	}
	
}
