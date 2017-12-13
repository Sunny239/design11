package com.page.dao;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.product.ComparatorDate;
import com.product.dao.Product;

@Repository
public class PageDao {
		
	@Resource
	private SessionFactory sessionfactory;
	
	
	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}
	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}
	
	/**
	 * 统计全部个数
	 * @return
	 */
	public int fingCountByPage(){
		Session session = sessionfactory.openSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery("from Product");
		List<Product> querylist = query.list();
		tran.commit();
		return querylist.size();
	}
	/**
	 * 全部分页技术
	 */
	public List<Product> findByPage(int pageNum,int pageSize){
		Session session = sessionfactory.openSession();
		Transaction tran = session.beginTransaction();
		String hql="from Product";
		Query query = session.createQuery(hql);
		query.setFirstResult((pageNum-1)*pageSize);
		query.setMaxResults(pageSize);
		List<Product> list = query.list();
		tran.commit();
		return list;	
	}
	
	/**
	 * 按类型分页
	 */
	/*public List<Product> findBytypePage(int pageNum,int pageSize,int typeid){
		ProductService ps = new ProductService();
		List<Product> list1 = ps.gettype(typeid);
		List<Product> list = new ArrayList<Product>();
		
		for (int i = (pageNum-1)*pageSize; i < (pageNum-1)*pageSize+pageSize; i++) {
			if(i<list1.size()){
				list.add(list.get(i));
			}
		}
		return list;	
	}*/
	
	/**
	 * 转换成Date
	 */
	 private static Date formatDate(String str) {  
		 Format f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 try {
			return (Date) f.parseObject(str);
		} catch (ParseException e) {
			return null;
		}
	 }
	
	
	/**
	 * 按日期排序
	 */
	public List<Product> time(int pageNum,int pageSize){
		/*List<Date> datelist = new ArrayList<Date>();
		Session session = sessionfactory.openSession();
		Transaction tran = session.beginTransaction();
		Query<Product> query = session.createQuery("from Product");
		List<Product> list = query.list();
		Iterator<Product> i = list.iterator();
		while(i.hasNext()){
			Product p = i.next();
			datelist.add(formatDate(p.getDate()));
		}
		ComparatorDate c = new ComparatorDate();  
        Collections.sort(datelist, c);
        tran.commit();
        return datelist;*/
		
		Session session = sessionfactory.openSession();
		Transaction tran =session.beginTransaction();
		NativeQuery<Product> query = session .createNativeQuery("select * from product order by date desc",Product.class);
		query.setFirstResult((pageNum-1)*pageSize);
		query.setMaxResults(pageSize);
		List<Product> datelist = query.list();
		tran.commit();
		return datelist;
	}
	public List<Product> findAll(){
		Session session = sessionfactory.openSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery("from Product");
		List<Product> querylist = query.list();
		tran.commit();
		return querylist;
	}
	
	/**
	 * 统计点击次数超过3的商品个数
	 */
	 public int findByCount(){
	 	Session session = sessionfactory.openSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery("from Product p where p.count>=3");
		List<Product> querylist = query.list();
		tran.commit();
		return querylist.size();
	 }
	 /**
	  * 分页技术
	  */
	 public List<Product> findbypage(int pageNum,int pageSize){
		 Session session = sessionfactory.openSession();
		Transaction tran = session.beginTransaction();
		String hql="from Product p where p.count>=3";
		Query query = session.createQuery(hql);
		query.setFirstResult((pageNum-1)*pageSize);
		query.setMaxResults(pageSize);
		List<Product> list = query.list();
		tran.commit();
		return list;
	 }
	 
}


