package com.codeo.sms.dao;

import com.codeo.sms.entity.SuperAdmin;

public interface SuperAdminDao {

	public boolean insertSuperAdmin(SuperAdmin superadmin);
	public SuperAdmin loginServlet(String username, String password);
}
