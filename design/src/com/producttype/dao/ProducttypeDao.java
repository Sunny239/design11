package com.producttype.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.producttype.entity.Producttype;

@Repository
public class ProducttypeDao {

	@Resource
	private SessionFactory sessionfactory;
	
	public List<Producttype> findAll(){
		Session session = sessionfactory.openSession();
		Transaction tran =session.beginTransaction();
		Query<Producttype> query = session.createQuery("from Producttype");
		List<Producttype> list = query.list();
		tran.commit();
		return list;
	}
}
