package com.user.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.orders.entity.Orders;
@Entity
@Table(name="user")
public class User {
	private String username;
	private String name;
	private String address;
	private String password;
	private String password1;
	private String date;
	private int active;
	private Role role;
	private Set ordersset = new HashSet<Orders>();
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Id
	@GeneratedValue(generator="my_gen")
    @GenericGenerator(name = "my_gen", strategy = "assigned")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	
	 public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	@ManyToOne
	 @JoinColumn(name="roleid")
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@OneToMany(mappedBy="user", targetEntity=Orders.class, 
            cascade=CascadeType.ALL)
	public Set getOrdersset() {
		return ordersset;
	}
	public void setOrdersset(Set ordersset) {
		this.ordersset = ordersset;
	}
	
}
