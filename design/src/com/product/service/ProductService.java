package com.product.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.product.dao.Product;
import com.product.dao.ProductDao;

@Service
public class ProductService {
	@Resource
	private ProductDao productdao;
	
	public List<Product> gettype(int typeid){
		List<Product> list= productdao.findAll();
		List<Product> list1 = new ArrayList<Product>();
		for(int i = 0;i<list.size();i++){
			if(list.get(i).getProducttype().getTypeid()==typeid){
				list1.add(list.get(i));
			}
		}	
			return list1;
	}
	
	public List<Product> getByTypeId(int typeid){
		return productdao.findByTypeId(typeid);
	}
	public Product getById(int id){
		return productdao.fingById(id);
	}
	
	public void editcount(int count,int productId){
		productdao.editcount(count,productId);
	}
}
