package com.cart.service;

import java.util.HashMap;
import java.util.Map;

import com.cart.entity.CartItem;
import com.product.dao.Product;


public class Cart {
	public Map<Integer,CartItem> container = new HashMap<Integer,CartItem>();
	
	public Map<Integer, CartItem> getContainer() {
		return container;
	}

	public void setContainer(Map<Integer, CartItem> container) {
		this.container = container;
	}

	public void addCart(Product pro){
		if(container.containsKey(pro.getId())){
			CartItem ci=container.get(pro.getId());
			ci.setCount(ci.getCount()+1);
		}else{
			CartItem ci=new CartItem();
			ci.setProduct(pro);
			ci.setCount(1);
			container.put(pro.getId(),ci);
		}
	}
}
