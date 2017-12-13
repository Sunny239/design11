package com.producttype.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.producttype.dao.ProducttypeDao;
import com.producttype.entity.Producttype;

@Service
public class ProducttypeService {

	@Resource
	private ProducttypeDao producttypedao;
	
	public List<Producttype> findAll(){
		return producttypedao.findAll();
	}
}
