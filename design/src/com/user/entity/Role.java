package com.user.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="role")
public class Role {
	private int roleid;
	private String permissions; 
	private Set userset = new HashSet<User>();
	@Id
	@GeneratedValue(generator="my_gen")
    @GenericGenerator(name = "my_gen", strategy = "assigned")
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String getPermissions() {
		return permissions;
	}
	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}
	@OneToMany(mappedBy="role", targetEntity=User.class, 
            cascade=CascadeType.ALL)
	public Set getUserset() {
		return userset;
	}
	public void setUserset(Set userset) {
		this.userset = userset;
	}
	
	
	
}
