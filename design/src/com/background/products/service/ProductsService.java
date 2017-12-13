package com.background.products.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.background.products.dao.ProductsDao;
import com.product.dao.Product;

@Service
public class ProductsService {

	@Resource
	private ProductsDao productsdao;

	public ProductsDao getProductsdao() {
		return productsdao;
	}

	public void setProductsdao(ProductsDao productsdao) {
		this.productsdao = productsdao;
	}
	
	public List<Product> findAll(){
		return productsdao.findAll();
	}
	
	public void delproduct(int id){
		productsdao.delproduct(id);
	}
	
	public void editproduct(int id,Product p){
		productsdao.editproduct(id, p);
	}
	
	public void addproduct(int producttype,Product p){
		productsdao.saveproduct(producttype, p);
		
	}
	public Boolean checkid(int id){
		Product p = productsdao.checkid(id);
		if(p==null){
			return true;
		}else{
			return false;
		}
	}
	
	public List<Product> selectproduct(String selectproduct){
		return productsdao.selectproduct(selectproduct);
	}
}
