package com.background.products.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.background.products.service.ProductsService;
import com.product.dao.Product;
import com.product.service.ProductService;
import com.producttype.entity.Producttype;
import com.producttype.service.ProducttypeService;

@Controller
@RequestMapping("/products")
public class ProductsController {

	@Resource
	private ProductsService productsservice;
	@Resource
	private ProductService productservice;
	@Resource
	private ProducttypeService producttypeservice;
	public ProductsService getProductsservice() {
		return productsservice;
	}

	public void setProductsservice(ProductsService productsservice) {
		this.productsservice = productsservice;
	}
	
	@RequestMapping(value="/findall",method=RequestMethod.GET)
	public String findAll(HttpSession session){
		List<Product> list = productsservice.findAll();
		session.setAttribute("list3", list);
		return "bgproduct";
	}
	
	@RequestMapping(value="/delproduct",method=RequestMethod.GET)
	public String delproduct(@RequestParam("productId") int productid){
		productsservice.delproduct(productid);
		return "forward:findall";
	}
	
	@RequestMapping(value="/editproduct",method=RequestMethod.GET)
	public String editproduct(@RequestParam("productId") int productid,
				HttpSession session){
		Product product = productservice.getById(productid);
		List<Producttype> list = producttypeservice.findAll();
		session.setAttribute("pro", product);
		session.setAttribute("list4", list);
		return "bgeditproduct";
	}
	
	@RequestMapping(value="/editproduct1",method=RequestMethod.POST)
	public String editproduct1(HttpServletRequest request,
				@RequestParam("id") int id,@RequestParam("name") String name,
				@RequestParam("price") Double price,@RequestParam("description") String description,
				@RequestParam("producttype") int producttype,@RequestParam(value="file") MultipartFile file){
		String filePath="";
		if(!file.isEmpty()){
			filePath = request.getSession().getServletContext().getRealPath("images/")+file.getOriginalFilename();
			 System.out.println(filePath);
			 try {
	                file.transferTo(new File(filePath));
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
		}
		Product p = new Product();
		Producttype pt = new Producttype();
		p.setId(id);
		p.setName(name);
		p.setPrice(price);
		p.setDescription(description);
		p.setProducttype(pt);
		pt.setTypeid(producttype);
		p.setImg1(file.getOriginalFilename());
		productsservice.editproduct(id, p);
		return "forward:findall1";
	}
	
	@RequestMapping(value="/findall1",method=RequestMethod.POST)
	public String findAll1(HttpSession session){
		List<Product> list = productsservice.findAll();
		session.setAttribute("list3", list);
		return "bgproduct";
	}
	
	@RequestMapping(value="/addproduct",method=RequestMethod.POST)
	public String addproduct(HttpServletRequest request,
			@RequestParam("id") int id,@RequestParam("name") String name,
			@RequestParam("price") Double price,@RequestParam("description") String description,
			@RequestParam("producttype") int producttype,@RequestParam(value="file") MultipartFile file){
		String filePath="";
		if(!file.isEmpty()){
			filePath = request.getSession().getServletContext().getRealPath("images/")+file.getOriginalFilename();
			 System.out.println(filePath);
			 try {
	                file.transferTo(new File(filePath));
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
		}
		Product p = new Product();
		Producttype pt = new Producttype();
		p.setId(id);
		p.setName(name);
		p.setPrice(price);
		p.setDescription(description);
		pt.setTypeid(producttype);
		p.setProducttype(pt);		
		p.setImg1(file.getOriginalFilename());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date = sdf.format(new Date());
		p.setDate(date);
		p.setCount(0);
		productsservice.addproduct(producttype, p);
		
		return "forward:findall1";
		
	}
	
	@RequestMapping(value="/checkid",method=RequestMethod.POST)
	public void checkid(HttpServletResponse response,HttpServletRequest request){
		response.setCharacterEncoding("UTF-8");
		String un = request.getParameter("id");
		Boolean result  = this.productsservice.checkid(new Integer(un));
		System.out.println(result);
		try{
			response.getWriter().print(result);			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String editproduct(HttpSession session){
		List<Producttype> list = producttypeservice.findAll();
		session.setAttribute("list5", list);
		return "bgaddproduct";
	}
	
	@RequestMapping(value="/selectproduct",method=RequestMethod.GET)
	public String selectproduct(@RequestParam("selectproduct") String selectproduct,
				HttpSession session){
		List<Product> list = productsservice.selectproduct(selectproduct);
		session.setAttribute("list8", list);
		return "bgproduct1";
	}
}
