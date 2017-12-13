package com.product.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.product.dao.Product;
import com.product.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Resource
	private ProductService productservice;
	
	
	public ProductService getProductservice() {
		return productservice;
	}


	public void setProductservice(ProductService productservice) {
		this.productservice = productservice;
	}


	@RequestMapping(value="/getProduct",method=RequestMethod.GET)
	public String getProduct(@RequestParam("productId") int productId,
				HttpSession session
			){
		
		Product  p = productservice.getById(new Integer(productId));
		int count = p.getCount();
		count++;
		productservice.editcount(count,productId);
		session.setAttribute("pro", p);
		return "single";
	}
	
}
