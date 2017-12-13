package com.product.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;


@Repository
public class ProductDao {
	@Resource
	private SessionFactory sessionfactory;
	
	public List<Product> findAll(){
		Session session = sessionfactory.openSession();
		Transaction tran = session.beginTransaction();
		Query<Product> query = session.createQuery("from Product");
		List<Product> list  = query.list();
		tran.commit();
		return list;
	}
	
	public List<Product> findByTypeId(int typeid){
		Session session  = sessionfactory.openSession();
		Transaction tran = session.beginTransaction();
		
		NativeQuery query = session.createNativeQuery("select * from product where typeid="+typeid);
		List<Product> list = query.list();
		tran.commit();
		return list;
	}
	
	public Product fingById(int id){
		Session session = sessionfactory.openSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery("from Product p where p.id=?");
		query.setParameter(0,id);
		Product product= (Product)query.uniqueResult();
		tran.commit();
		return product;
	}
	
	public void editcount(int count,int productId){
		Session session = sessionfactory.openSession();
		Transaction tran =session.beginTransaction();
		Query<Product> query = session.createQuery("update Product p set p.count=? where p.id=?");
		query.setParameter(0,count);
		query.setParameter(1,productId);
		query.executeUpdate();
		tran.commit();
		/*try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/design?useUnicode=true&characterEncoding=UTF-8","root","");
			PreparedStatement pstm = con.prepareStatement("update product set count=? where id=?");
			pstm.setInt(1,count);
			pstm.setInt(2,productId);
			
			pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}*/
	}
}
