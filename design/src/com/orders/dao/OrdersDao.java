package com.orders.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.orders.entity.Orders;
import com.orders.entity.Ordersdetails;
import com.user.entity.User;

@Repository
public class OrdersDao {

	@Resource
	private SessionFactory sessionfactory;

	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}
	
	public void insert(int productid,String name,Double price,int count,HttpSession session1,String date,int state){
		Session session = sessionfactory.openSession();
		Transaction tran=session.beginTransaction();
		User u = (User) session1.getAttribute("u");
		User user = session.get(User.class,new String(u.getAddress()));
		/*List<Orders> list1 = new ArrayList<Orders>();
		Query<Orders> query = session.createQuery("from Orders");
		List<Orders> list = query.list();
		Iterator<Orders> i = list.iterator();
		int k = 0;*/
		/*while(i.hasNext()){
			
			Orders o = i.next();
			String useraddress1 = o.getUser().getAddress();
			if(useraddress1==user.getAddress()){
				if(o.getProductid()==productid){
					int count1=o.getCount();
					count+=count1;
					o.setCount(count);
					session.update(o);
					tran.commit();
					session.close();
					break;
				}
			}
			k++;
		}*/
		//if(k>=list.size()){
			Orders o = new Orders();
			o.setProductid(productid);
			o.setName(name);
			o.setPrice(price);
			o.setCount(count);
			o.setDate(date);
			o.setState(state);
			user.getOrdersset().add(o);
			o.setUser(user);
			session.save(o);
			tran.commit();
			session.close();
		//}	
			
	}
	
	public List<Orders> get(HttpSession session1,int state){
		Session session = sessionfactory.openSession();
		Transaction tran = session.beginTransaction();
		User u = (User)session1.getAttribute("u");
		String address = u.getAddress();
		Query<Orders> query = session.createQuery("from Orders where state=?");
		query.setParameter(0, state);
		List list = query.list();
	
		tran.commit();
		return list;
	}
	
	public void xiaorders(String date){
		Session session =sessionfactory.openSession();
		Transaction tran = session.beginTransaction();

		Query query = session.createQuery("from Orders where date=?");
		query.setParameter(0,date);
		List list = query.list();
		Iterator i = list.iterator();
		while(i.hasNext()){
			Orders o = (Orders)i.next();
			o.setState(1);
			session.update(o);
		}
		
		tran.commit();
	}
	
	public void del(int productid,String date,int state){
		Session session = sessionfactory.openSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery("delete from Orders where productid=? and date=? and state=?");
		query.setParameter(0,productid);
		query.setParameter(1,date);
		query.setParameter(2,state);
		int count = query.executeUpdate();
		System.out.println("count==========="+count);
		tran.commit();
	}
	
	public void addshouhuo(Ordersdetails od){
		Session session = sessionfactory.openSession();
		Transaction tran =session.beginTransaction();
		session.save(od);
		tran.commit();
		session.close();
		
	}
}
