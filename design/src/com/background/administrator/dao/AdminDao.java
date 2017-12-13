package com.background.administrator.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.orders.entity.Orders;
import com.orders.entity.Ordersdetails;
import com.user.entity.User;

@Repository
public class AdminDao {

	@Resource
	private SessionFactory sessionfactory;

	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}
	
	public User checkaddress(String address){
		Session session = sessionfactory.openSession();
		Transaction tran = session.beginTransaction();
		User u = session.get(User.class, new String(address));
		
		tran.commit();
		return u;
	}
	
	public List<User> findAll(){
		List<User> list1 = new ArrayList<User>();
		Session session =sessionfactory.openSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery("from User");
		List<User> list = query.list();
		Iterator<User> i = list.iterator();
		while(i.hasNext()){
			User user = (User)i.next();
			if(user.getRole().getRoleid()==1){
				list1.add(user);
			}
		}
		tran.commit();
		return list1;
	}
	public int deluser(String address){
		Session session = sessionfactory.openSession();
		Transaction tran =session.beginTransaction();
		Query<User> query = session.createQuery("delete from User where address=?");
		query.setParameter(0, address);
		int count = query.executeUpdate();
		
		Query<Orders> query1 = session.createQuery("delete from Orders where useraddress=?");
		query1.setParameter(0, address);
		query1.executeUpdate();
		
		Query<Ordersdetails> query2 =  session.createQuery("delete from Ordersdetails where useraddress=?");
		query2.setParameter(0, address);
		query2.executeUpdate();
		tran.commit();
		return count;
	}
}
