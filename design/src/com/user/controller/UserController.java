package com.user.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.annotation.Resource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.user.entity.User;
import com.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userservice;

	public UserService getUserservice() {
		return userservice;
	}

	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@RequestParam("username") String username,
			@RequestParam("name") String name,
			@RequestParam("address") String address,
			@RequestParam("password") String password,
			@RequestParam("password1") String password1,
			HttpServletRequest request,
			HttpServletResponse response
			){
		User user = new User();
		user.setUsername(username);
		user.setName(name);
		user.setAddress(address);
		user.setPassword(password);
		user.setPassword1(password1);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = df.format(new Date());
		user.setDate(date);
		user.setActive(0);
		Boolean b= userservice.adduser(user,address);
		if(b){		
			Properties prop = System.getProperties();
			prop.put("mail.transport.protocol", "smtp");
			prop.put("mail.smtp.host", "smtp.163.com");
			prop.put("mail.smtp.auth", "true");
			
			Session session = Session.getInstance(prop, new Authenticator() {
				public PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("javamail5678", "javamail5678sqm");
				}
			});
			
			Message msg = new MimeMessage(session);
			try{
				msg.setFrom(new InternetAddress("javamail5678@163.com"));
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(address));
				msg.setSubject("邮箱激活");
				MimeBodyPart mimeBodyPart = new MimeBodyPart();
				mimeBodyPart.setContent("<a href='http://localhost:8080/design/user/jihuo?address="+address+"'>点击激活</a>", "text/html;charset=UTF-8");
				MimeMultipart mimeMultipart = new MimeMultipart();
				mimeMultipart.addBodyPart(mimeBodyPart);
				msg.setContent(mimeMultipart);
				msg.setHeader("X-Mailer", "smtpsend");
				msg.setSentDate(new Date());
				Transport.send(msg);
				response.getWriter().print("ok");
				
			}catch(Exception e){
				e.printStackTrace();
			}
			return "login";
		}else{	
			return "register";
		}
		
	}
	@RequestMapping(value="/get",method=RequestMethod.POST)
	public String get(@RequestParam("address") String address,
			@RequestParam("password") String password,
			HttpSession session,Model model
			){
		User u = userservice.getuser(address, password);
		if(u!=null){
			session.setAttribute("u", u);
			JOptionPane.showMessageDialog(null, "登录成功!");
			return "index";
		}else{
			JOptionPane.showMessageDialog(null, "账号或密码错误，请重新登录!");
			return "login";
		}
	}
	@RequestMapping(value="/jihuo",method=RequestMethod.GET)
	public String jihuo(@RequestParam("address") String address){
		System.out.println(address);
		int count = userservice.editac(address);
		if(count!=0){
			JOptionPane.showMessageDialog(null, "激活成功!");
			return "login";
		}else{
			JOptionPane.showMessageDialog(null, "激活失败!");
			return "error";
		}
		
	}
	
	
	@RequestMapping("/checkaddress")
	public void checkaddress(HttpServletResponse response,HttpServletRequest request){
		response.setCharacterEncoding("UTF-8");
		String un = request.getParameter("address");
		Boolean result  = this.userservice.getaddress(un);
		//System.out.println(result);
		try{
				response.getWriter().print(result);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("/checkpwd")
	public void checkpwd(HttpSession session,
			@RequestParam("yuanpwd") String yuanpwd,
			HttpServletResponse response
			){
		Boolean result = userservice.checkpwd(yuanpwd,session);
		/*if(result){
			System.out.println("trueqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
		}else{
			System.out.println("falseqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
		}
		*/
		try{
			response.getWriter().print(result);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/editpwd",method=RequestMethod.POST)
	public String editpwd(@RequestParam("yuanpwd") String yuanpwd,@RequestParam("xinpwd") String xinpwd,
				HttpSession session
			){
		Boolean b = userservice.editpwd(yuanpwd, xinpwd, session);
		if(b==true){
			JOptionPane.showMessageDialog(null, "修改成功!");
			return "login";
		}else{
			JOptionPane.showMessageDialog(null, "修改失败!");
			return "vipPwd";
		}
	}
	
	
}
