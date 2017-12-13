package com.cart.controller;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cart.entity.CartItem;
import com.cart.service.Cart;
import com.product.dao.Product;
import com.product.service.ProductService;
import com.user.entity.User;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Resource
	private ProductService productservice;
	
	public ProductService getProductservice() {
		return productservice;
	}

	public void setProductservice(ProductService productservice) {
		this.productservice = productservice;
	}

	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addcart(@RequestParam("productId") String productId,
			HttpSession session,Cart c
			){
		User u = (User) session.getAttribute("u");
		if(u!=null){
			Product p=productservice.getById(new Integer(productId));
			c = (Cart)session.getAttribute("cart");
			if(c==null){
				c = new Cart();
			}
			c.addCart(p);
			session.setAttribute("cart",c);
			return "product";
		}else{
			JOptionPane.showMessageDialog(null, "您还没有登录!");
			return "login";
		}
		
		
	}
	@RequestMapping(value="/jian",method=RequestMethod.GET)
	public String jian(@RequestParam("productId") String productId,
			HttpSession session
			){
		Product p = productservice.getById(new Integer(productId));
		Cart c = (Cart)session.getAttribute("cart");
		int count = c.container.get(new Integer(productId)).getCount();
		//System.out.println(count);
		if(count>0){
			if(count>1){
				count--;
			}else{
				count=1;
			}
		}
		
		c.container.get(new Integer(productId)).setCount(count);
		
		session.setAttribute("p", p);
		return "checkout1";
	}
	@RequestMapping(value="/jia",method=RequestMethod.GET)
	public String jia(@RequestParam("productId") String productId,
			HttpSession session
			){
		Product p = productservice.getById(new Integer(productId));
		Cart c=(Cart)session.getAttribute("cart");
		int count = c.container.get(new Integer(productId)).getCount();
		
		count++;
		CartItem ci = new CartItem();
		c.container.get(new Integer(productId)).setCount(count);
		session.setAttribute("p",p);
		//session.setAttribute("count", count);
		return "checkout1";
	}
	
	@RequestMapping(value="/del",method=RequestMethod.GET)
	public String del(@RequestParam("productId") String productId,
				HttpSession session
			){
		Cart c = (Cart)session.getAttribute("cart");
		//CartItem ci = c.container.get(new Integer(productId));
		c.getContainer().remove(new Integer(productId));
		return "checkout1";
	}
	@RequestMapping(value="/delall",method=RequestMethod.GET)
	public String delall(HttpSession session){
		Cart c = (Cart)session.getAttribute("cart");
		Iterator<Map.Entry<Integer, CartItem>> i= c.container.entrySet().iterator();
		while(i.hasNext()){
			Map.Entry<Integer,CartItem> entry = i.next();
			i.remove();
			
		}
		return "checkout1";
	}
	@RequestMapping(value="/delselect",method=RequestMethod.POST)
	public String delselect(@RequestParam("cartcheckbox") String cartcheckbox,
					HttpServletRequest request,
					HttpSession session){
		String[] id = cartcheckbox.split(",");
		for(int i = 0;i<id.length;i++){
			Cart c = (Cart)session.getAttribute("cart");
			//CartItem ci = c.container.get(new Integer(productId));
			c.getContainer().remove(new Integer(id[i]));
		}
		return "checkout1";
	}
	
	@RequestMapping(value="/checkcart",method=RequestMethod.GET)
	public String checkcart(HttpSession session){
		User u = (User)session.getAttribute("u");
		if(u!=null){
			return "checkout";
		}else{
			JOptionPane.showMessageDialog(null, "您还未登录!");
			return "index";
		}
	}
	
	
}
