package com.background.products.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import javax.annotation.Resource;
import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.product.dao.Product;
import com.producttype.entity.Producttype;

@Repository
public class ProductsDao {
	@Resource
	private SessionFactory sessionfactory;

	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}
	
	public List<Product> findAll(){
		Session session = sessionfactory.openSession();
		Transaction tran =session.beginTransaction();
		Query<Product> query = session.createQuery("from Product");
		List<Product> list = query.list();
		tran.commit();
		return list;
	}
	
	public void delproduct(int id){
		Session session = sessionfactory.openSession();
		Transaction tran =session.beginTransaction();
		Query query = session.createQuery("delete from Product where id=?");
		query.setParameter(0, id);
		query.executeUpdate();
		tran.commit();
	}
	
	public void editproduct(int id,Product p){
		/*Session session =sessionfactory.openSession();
		Transaction tran = session.beginTransaction();
		Producttype pt = new Producttype();
		p.setProducttype(pt);*/
		/*Query query = session.createQuery("update Product set name=?,price=?,description=?,img1=?,where id=?");
		query.setParameter(0, p.getName());
		query.setParameter(1,p.getPrice());
		query.setParameter(2,p.getDescription());
		query.setParameter(3,p.getImg1());
		query.setParameter(4, p.getProducttype().getTypeid());
		query.setParameter(5,p.getId());
		query.executeUpdate();*/
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/design?useUnicode=true&characterEncoding=UTF-8","root","");
			PreparedStatement pstm = con.prepareStatement("update product set name=?,price=?,description=?,img1=?,typeid=? where id=?");
			pstm.setString(1,p.getName());
			pstm.setDouble(2,p.getPrice());
			pstm.setString(3,p.getDescription());
			pstm.setString(4,p.getImg1());
			pstm.setInt(5, p.getProducttype().getTypeid());
			pstm.setInt(6,id);
			pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		//tran.commit();
	}
	
	public void saveproduct(int producttype,Product p){
		Session session = sessionfactory.openSession();
		Transaction tran = session.beginTransaction();
		Producttype pt = session.get(Producttype.class,new Integer(producttype));
		//Product product = session.get(Product.class, new Integer(p.getId()));
		pt.getProductset().add(p);
		p.setProducttype(pt);
		session.save(p);
		tran.commit();
	}
	
	public Product checkid(int id){
		Session session =sessionfactory.openSession();
		Transaction tran = session.beginTransaction();
		System.out.println("1111111111111111");
		Product p = session.get(Product.class, new Integer(id));
		tran.commit();
		return p;
		
	}
	
	public List<Product> selectproduct(String selectproduct){
		Session session =sessionfactory.openSession();
		Transaction tran = session.beginTransaction();
		String hql = "from Product p where p.name like '%"+selectproduct+"%'";
		Query query = session.createQuery(hql);
		List<Product> list = query.list();
		tran.commit();
		return list;
	}
}
