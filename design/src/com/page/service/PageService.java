package com.page.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.page.dao.PageDao;
import com.product.dao.Product;

@Service
public class PageService {

	@Resource
	private PageDao pagedao;

	public PageDao getPagedao() {
		return pagedao;
	}

	public void setPagedao(PageDao pagedao) {
		this.pagedao = pagedao;
	}
	/**
	 * 全部商品
	 * @return
	 */
	public int getCountByPage(){
		return pagedao.fingCountByPage();
	}
	
	public List<Product> getByPage(int pageNum,int pageSize){
		return pagedao.findByPage(pageNum, pageSize);
	}
	/**
	 * 商品类型
	 */
	/*public List<Product> getBytypePage(int pageNum,int pageSize,int typeid){
		return pagedao.findBytypePage(pageNum, pageSize,typeid);
	}*/
	
	public List<Product> time(int pageNum,int pageSize){
		return pagedao.time(pageNum,pageSize);
	}
	
	public List<Product> findAll(){
		return pagedao.findAll();
	}
	
	/**
	 * 点击次数超过3次
	 */
	public int findbycount(){
		return pagedao.findByCount();
	}
	public List<Product> findbypage(int pageNum,int pageSize){
		return pagedao.findbypage(pageNum, pageSize);
	}
}

