package com.producttype.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.product.dao.Product;
@Entity
@Table(name="producttype")
public class Producttype {
	private int typeid;
	private String type;
	private Set productset = new HashSet<Product>();
	@Id
	@GeneratedValue(generator="my_gen")
    @GenericGenerator(name = "my_gen", strategy = "assigned")
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	 @OneToMany(mappedBy="producttype", targetEntity=Product.class, 
	            cascade=CascadeType.ALL)
	public Set getProductset() {
		return productset;
	}
	public void setProductset(Set productset) {
		this.productset = productset;
	}
	
}
