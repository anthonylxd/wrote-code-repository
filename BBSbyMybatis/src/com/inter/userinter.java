package com.inter;

import java.util.List;

import com.entity.User;

public interface userinter {
	//用户登录
	public User userlogin(User user);
	//删除用户
	public boolean deleteuser(String username);
	//显示所有用户列表
	public List<User> displayuser();
	
	public boolean useradd(User user);
}
