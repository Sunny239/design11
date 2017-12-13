package com.page.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.page.entity.Page;
import com.page.service.PageService;
import com.product.dao.Product;
import com.product.service.ProductService;

@Controller
@RequestMapping("/page")
public class PageController {
	
	@Resource
	private PageService pageservice;
	@Resource
	private ProductService productservice;

	public PageService getPageservice() {
		return pageservice;
	}

	public void setPageservice(PageService pageservice) {
		this.pageservice = pageservice;
	}
	
	
	public ProductService getProductservice() {
		return productservice;
	}

	public void setProductservice(ProductService productservice) {
		this.productservice = productservice;
	}
	/**
	 * 全部商品
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public String getpage(HttpServletRequest request,
			HttpSession session){
		
		String pageNum = request.getParameter("pageNum");
		
		int num=0;
		if(pageNum==null||pageNum.equals("")){
			num=1;
		}else{
			num=new Integer(pageNum);
		}
		int count=pageservice.getCountByPage();
		List<Product> list = pageservice.getByPage(num, 4);
		Page p =new Page(num,4);
		p.setList(list);
		p.setTotalCount(count);
		session.setAttribute("page", p);
		session.setAttribute("action", "page/get");
		return "product";
	}
	/**
	 * 按类型
	 */
	@RequestMapping(value="/gettype",method=RequestMethod.GET)
	public String gettype(HttpServletRequest request,
				HttpSession session,@RequestParam("typeId") String typeid
			){
		String pageNum = request.getParameter("pageNum");
		
		int num=0;
		if(pageNum==null||pageNum.equals("")){
			num=1;
		}else{
			num=new Integer(pageNum);
		}
		int count = productservice.gettype(new Integer(typeid)).size();
		/*System.out.println("count="+count);
		List<Product> list1 = productservice.gettype(1);
		System.out.println("name"+list1.get(0).toString());*/
		
		List<Product> list = productservice.gettype(new Integer(typeid));
		List<Product> list1 = new ArrayList<Product>();
		
		for (int i = (num-1)*4; i < (num-1)*4+4; i++) {
			if(i<count){
				list1.add(list.get(i));
			}
		}
		//System.out.println("name="+list.get(0).getName());
		Page p =new Page(num,4);
		p.setList(list1);
		p.setTotalCount(count);
		session.setAttribute("page",p);
		session.setAttribute("action", "page/gettype");
		session.setAttribute("typeid", typeid);
		//System.out.println(list.size());
		return "product";
			
	}
	
	 /**
	  * 转换成字符串
	  */
	 private static String formatdate(Object date) {  
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	        return dateFormat.format(date);  
	 }
	
	@RequestMapping(value="/time",method=RequestMethod.GET)
	public String time(HttpServletRequest request,
				HttpSession session){
		/*List<Product> li = new ArrayList<Product>();
		
		List<Date> list = pageservice.time();
		Iterator<Date> i = list.iterator();
		while(i.hasNext()){
			Date date = i.next();
			System.out.println(formatdate(date));
			
			List<Product> list1 = pageservice.findAll();
			Iterator<Product> i1 = list1.iterator();
			while(i1.hasNext()){
				Product p = i1.next();
				if(p.getDate().equals(formatdate(date))){
					li.add(p);
				}
			}
		}
		
		Iterator<Product> i3 = li.iterator();
		while(i3.hasNext()){
			
			Product p = i3.next();
			System.out.println(p.getId());
		}*/
		String pageNum = request.getParameter("pageNum");
		
		int num=0;
		if(pageNum==null||pageNum.equals("")){
			num=1;
		}else{
			num=new Integer(pageNum);
		}
		
		int count=pageservice.getCountByPage();
		List<Product> list = pageservice.time(num,4);
		Page p =new Page(num,4);
		p.setList(list);
		p.setTotalCount(count);
		session.setAttribute("page", p);
		session.setAttribute("action", "page/time");
		
		/*Iterator<Product> i = list.iterator();
		while(i.hasNext()){
			Product p = i.next();
			System.out.println(p.getId()+"   "+p.getDate());
		}*/
		return "product";
	}
	
	/**
	 * 点击次数超过3次
	 */
	@RequestMapping(value="/getbycount",method=RequestMethod.GET)
	public String getbycount(HttpServletRequest request,
			HttpSession session){
		
		String pageNum = request.getParameter("pageNum");
		
		int num=0;
		if(pageNum==null||pageNum.equals("")){
			num=1;
		}else{
			num=new Integer(pageNum);
		}
		int count=pageservice.findbycount();
		List<Product> list = pageservice.findbypage(num, 4);
		Page p =new Page(num,4);
		p.setList(list);
		p.setTotalCount(count);
		session.setAttribute("page", p);
		session.setAttribute("action", "page/getbycount");
		return "product";
	}
}
