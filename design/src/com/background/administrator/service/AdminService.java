package com.background.administrator.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.background.administrator.dao.AdminDao;
import com.user.entity.User;

@Service
public class AdminService {

	@Resource
	private AdminDao admindao;

	public AdminDao getAdmindao() {
		return admindao;
	}

	public void setAdmindao(AdminDao admindao) {
		this.admindao = admindao;
	}
	
	public User checkaddress(String address){
		return admindao.checkaddress(address);
	}
	
	public List<User> findAll(){
		return admindao.findAll();
	}
	public int deluser(String address){
		return admindao.deluser(address);
	}
}
