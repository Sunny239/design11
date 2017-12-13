package com.user.dao;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.user.entity.Role;
import com.user.entity.User;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

@Repository
public class UserDao {
	@Resource
	private SessionFactory sessionfactory;

	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}
	public boolean  saveuser(User u,String address){
		Session session = sessionfactory.openSession();
		Transaction tran = session.beginTransaction();
		Role role = session.get(Role.class, new Integer(1));
		User user = session.get(User.class, new String(address));
		if(user==null){
			role.getUserset().add(u);
			u.setRole(role);
			session.save(u);
			tran.commit();
			return true;
		}else{
			return false;
		}
		
	}
	
	public User checkuser(String address){
		Session session = sessionfactory.openSession();
		Transaction tran = session.beginTransaction();
		User u = session.get(User.class, new String(address));
		tran.commit();
		return u;
	}
	
	public int editactive(String address){
		Session session =sessionfactory.openSession();
		Transaction tran = session.beginTransaction();
		String hql = "update User set active=1 where address=?";
		Query query =session.createQuery(hql);
		query.setParameter(0, address);
		int count = query.executeUpdate();
		tran.commit();
		return count;
	}
	public Boolean checkaddress(String address){
		Session session = sessionfactory.openSession();
		Transaction tran = session.beginTransaction();
		User user = session.get(User.class, new String(address));
		//System.out.println(user.getAddress());
		if(user==null){
			return true;
		}else{
			return false;
		}
	}
	
	public Boolean checkpwd(String pwd,HttpSession session1){
		Session session = sessionfactory.openSession();
		Transaction tran = session.beginTransaction();
		User user=(User)session1.getAttribute("u");
		String address = user.getAddress();
		User u = session.get(User.class, new String(address));
		if(u.getPassword().equals(pwd)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public Boolean editpwd(String pwd,String newpwd,HttpSession session1){
		Session session = sessionfactory.openSession();
		Transaction tran =session.beginTransaction();
		User user = (User)session1.getAttribute("u");
		String address =user.getAddress();
		User u = session.get(User.class, new String(address));
		if(u.getPassword().equals(pwd)){
			u.setPassword(newpwd);
			u.setPassword1(newpwd);
			session.update(u);
			tran.commit();
			return true;
		}else{
			return false;
		}
	}
}
