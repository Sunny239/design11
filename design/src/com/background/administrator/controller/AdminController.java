package com.background.administrator.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.background.administrator.service.AdminService;
import com.user.entity.User;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Resource
	private AdminService adminservice;
	
	public AdminService getAdminservice() {
		return adminservice;
	}
	
	public void setAdminservice(AdminService adminservice) {
		this.adminservice = adminservice;
	}

	@RequestMapping(value="/checkaddress",method=RequestMethod.POST)
	public String checkaddress(@RequestParam("address") String address,
				@RequestParam("password") String password){
		User user = adminservice.checkaddress(address);
		if(user!=null && user.getPassword().equals(password)&&user.getRole().getRoleid()==1){
			JOptionPane.showMessageDialog(null, "您没有访问权限!");
			return "bglogin";
		}else if(user!=null && user.getPassword().equals(password)&&user.getRole().getRoleid()!=1){
				return "bgindex";
			}else{
				JOptionPane.showMessageDialog(null, "登陆失败,检查邮箱或密码是否正确!");
				return "bglogin";
			}
		}
	
	@RequestMapping(value="findall",method=RequestMethod.GET)
	public String findAll(HttpSession session){
		List<User> list = adminservice.findAll();
		session.setAttribute("list2", list);
		return "bguserlist";
	}
	
	@RequestMapping(value="/deluser",method=RequestMethod.GET)
	public String deluser(@RequestParam("address") String address){
		int count = adminservice.deluser(address);
		return "forward:findall";
		
	}
		
}
