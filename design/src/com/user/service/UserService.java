package com.user.service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.user.dao.UserDao;
import com.user.entity.User;

@Service
public class UserService {
	@Resource
	private UserDao userdao;

	public UserDao getUserdao() {
		return userdao;
	}

	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}
	public boolean adduser(User u,String address){
		return userdao.saveuser(u,address);
	}
	
	public User getuser(String address,String password){
		User u = userdao.checkuser(address);
		if(u!=null && u.getRole().getRoleid()==1){
			if(u.getPassword().equals(password)){
				return u;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
	
	public int editac(String address){
		return userdao.editactive(address);
	}
	
	public Boolean getaddress (String address){
		return userdao.checkaddress(address);
	}
	
	public Boolean checkpwd(String pwd,HttpSession session){
		return userdao.checkpwd(pwd,session);
	}
	
	public Boolean editpwd(String pwd,String newpwd,HttpSession session){
		return userdao.editpwd(pwd, newpwd, session);
	}
}
