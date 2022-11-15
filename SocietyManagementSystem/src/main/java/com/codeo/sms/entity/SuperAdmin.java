package com.codeo.sms.entity;
// constuctor, encapsulation==> Data Hidding==>declare variable as pvt
//methods as public(setter, getter)
//Alt+Shift+S for autogenrating statements
public class SuperAdmin {

	private int id=0;
	private String name=null;
	private String email=null;
	private String password=null;
	//constructor call from SuperAdminController
	public SuperAdmin(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public SuperAdmin(int id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SuperAdmin() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "SuperAdmin [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}
	
	
	
	
}
